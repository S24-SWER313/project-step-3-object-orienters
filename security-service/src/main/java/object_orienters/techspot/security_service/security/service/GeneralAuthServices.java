package object_orienters.techspot.security_service.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import object_orienters.techspot.security_service.ContentServiceProxy;
import object_orienters.techspot.security_service.exceptions.EmailAlreadyExistsException;
import object_orienters.techspot.security_service.exceptions.UserNotFoundException;
import object_orienters.techspot.security_service.exceptions.UsernameAlreadyExistsException;
import object_orienters.techspot.security_service.security.blacklist.ImpleTokenBlackListService;
import object_orienters.techspot.security_service.security.jwt.JwtUtils;
import object_orienters.techspot.security_service.security.model.RefreshToken;
import object_orienters.techspot.security_service.security.model.UpdateProfile;
import object_orienters.techspot.security_service.security.model.User;
import object_orienters.techspot.security_service.security.payload.request.LoginRequest;
import object_orienters.techspot.security_service.security.payload.request.SignupRequest;
import object_orienters.techspot.security_service.security.payload.response.JwtResponse;
import object_orienters.techspot.security_service.security.repository.RefreshTokenRepository;
import object_orienters.techspot.security_service.security.repository.UserRepository;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Map;
import java.util.Optional;

@Service
public class GeneralAuthServices {
    @Autowired
    UserRepository userRepository;

    @Autowired
    ContentServiceProxy contentServiceProxy;

    @Autowired
    RefreshTokenRepository refreshTokenRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    ImpleTokenBlackListService blackListService;

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

        contentServiceProxy.createProf(signUpRequest);

        return user;
    }

    @Transactional
    public UpdateProfile updateUserProfile(UpdateProfile newUser, String username) throws UserNotFoundException {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(username));

        user.setPassword(encoder.encode(newUser.getPassword()));
        userRepository.save(user);

        contentServiceProxy.updateProfile(newUser, username);

        return newUser;

        // return us.findByUsername(username).map(user -> {
        // Optional.ofNullable(newUser.getDob()).ifPresent(user::setDob);
        // Optional.ofNullable(newUser.getName()).ifPresent(user::setName);
        // Optional.ofNullable(newUser.getAbout()).ifPresent(user::setAbout);
        // Optional.ofNullable(newUser.getProfession()).ifPresent(user::setProfession);
        // Optional.ofNullable(newUser.getGender()).ifPresent(user::setGender);

        // Optional.ofNullable(newUser.getPassword()).ifPresent(password -> {
        // user.getOwner().setPassword(encoder.encode(password));
        // userRepository.save(user.getOwner());
        // });

        // return repo.save(user);
        // }).orElseThrow(() -> new UserNotFoundException(username));
    }

    @Transactional
    public void deleteUser(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(username));

        refreshTokenRepository.deleteByUser(user);

        contentServiceProxy.deleteProfile(username);

        userRepository.delete(user);

    }

    public Map<String, ?> verifyUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        if (userRepository.existsByUsername(username)) {
            return Map.of("username", username);
        }
        return Map.of("username", "null");
    }
}
