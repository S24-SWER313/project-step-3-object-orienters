package object_orienters.techspot.api_gateway.security.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import object_orienters.techspot.api_gateway.exceptions.EmailAlreadyExistsException;
import object_orienters.techspot.api_gateway.exceptions.ProfileNotFoundException;
import object_orienters.techspot.api_gateway.exceptions.UserNotFoundException;
import object_orienters.techspot.api_gateway.exceptions.UsernameAlreadyExistsException;
import object_orienters.techspot.api_gateway.security.blacklist.ImpleTokenBlackListService;
import object_orienters.techspot.api_gateway.security.jwt.JwtUtils;
import object_orienters.techspot.api_gateway.security.model.RefreshToken;
import object_orienters.techspot.api_gateway.security.model.User;
import object_orienters.techspot.api_gateway.security.payload.request.LoginRequest;
import object_orienters.techspot.api_gateway.security.payload.request.SignupRequest;
import object_orienters.techspot.api_gateway.security.payload.response.JwtResponse;
import object_orienters.techspot.api_gateway.security.repository.RefreshTokenRepository;
import object_orienters.techspot.api_gateway.security.repository.UserRepository;

import java.io.IOException;
import java.sql.Timestamp;

@Service
public class GeneralAuthServices {
    @Autowired
    UserRepository userRepository;

    // @Autowired
    // ProfileRepository profileRepository;

    // @Autowired
    // PostRepository postRepository;

    @Autowired
    RefreshTokenRepository refreshTokenRepository;

    // @Autowired
    // FileStorageService fileStorageService;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    ImpleTokenBlackListService blackListService;

    // @Autowired
    // ProfileService profileService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    RefreshTokenService refreshTokenService;

    public boolean usernameExists(String username) {
        return userRepository.existsByUsername(username);
    }

    @Transactional
    public JwtResponse authenticateUser(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                        loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        ImpleUserDetails userDetails = (ImpleUserDetails) authentication.getPrincipal();

        String jwt = jwtUtils.generateJwtToken(authentication);

        RefreshToken refreshToken = refreshTokenService.createRefreshToken(userDetails.getUsername());

        User user = userRepository.findByUsername(userDetails.getUsername())
                .orElseThrow(() -> new UserNotFoundException(userDetails.getUsername()));

        user.setLastLogin(new Timestamp(System.currentTimeMillis()));

        userRepository.save(user);

        return new JwtResponse(
                jwt,
                refreshToken.getToken(),
                userDetails.getUsername(),
                userDetails.getEmail());
    }

    @Transactional
    public void logoutUser(String token) {
        blackListService.blacklistToken(token);
        SecurityContextHolder.clearContext();
    }

    @Transactional
    public User registerUser(SignupRequest signUpRequest) throws IOException {
        if (userRepository.existsByUsername(signUpRequest.getUsername()))
            throw new UsernameAlreadyExistsException(signUpRequest.getUsername());

        if (userRepository.existsByEmail(signUpRequest.getEmail()))
            throw new EmailAlreadyExistsException(signUpRequest.getEmail());

        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));
        userRepository.save(user);
       // profileService.createNewProfile(user.getUsername(), user.getEmail(), signUpRequest.getName());

        return user;
    }



    @Transactional
    public User updateUser(String clientUsername, SignupRequest signUpRequest) {
        if (!signUpRequest.getUsername().equals(clientUsername)
                && userRepository.existsByUsername(signUpRequest.getUsername())) {
            throw new UsernameAlreadyExistsException(signUpRequest.getUsername());
        }

        if (!signUpRequest.getEmail()
                .equals(userRepository.findByUsername(clientUsername)
                        .orElseThrow(() -> new UserNotFoundException(clientUsername))
                        .getEmail())
                && userRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new EmailAlreadyExistsException(signUpRequest.getEmail());
        }

        User user = userRepository.findByUsername(clientUsername)
                .orElseThrow(() -> new UserNotFoundException(clientUsername));
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(encoder.encode(signUpRequest.getPassword()));
        user.setUsername(signUpRequest.getUsername());
        userRepository.save(user);

        return user;
    }


    @Transactional
    public void deleteUser(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(username));
        // Profile profile = profileRepository.findByUsername(username)
        //         .orElseThrow(() -> new ProfileNotFoundException(username));
        // commentRepository.deleteAllByCommentAuthorUsername(username);

        // profile.getPublishedPosts().stream().forEach(post -> {
        //     post.getMediaData().stream().forEach(media -> {
        //         fileStorageService.deleteFile(media.getFileName());
        //     });
        //     postRepository.delete(post);
        // });
        // refreshTokenRepository.deleteByUser(user);
        // userRepository.delete(user);
        // profileRepository.delete(profile);
    }



}
