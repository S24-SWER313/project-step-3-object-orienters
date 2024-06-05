// package object_orienters.techspot.contentservice.feed;

// import object_orienters.techspot.contentservice.profile.Profile;
// import object_orienters.techspot.contentservice.profile.ProfileRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.PageRequest;
// import org.springframework.stereotype.Service;

// @Service
// public class SearchByName extends Strategy<Profile, String>{

//     @Autowired
//     public SearchByName(ProfileRepository profileRepository) {
//         this.profileRepository = profileRepository;
//     }
//     @Override
//     Page<Profile> operate(String factor, int pageNumber, int pageSize) {
//         return profileRepository.findBySearchCriteria(factor, PageRequest.of(pageNumber, pageSize));
//     }
// }
