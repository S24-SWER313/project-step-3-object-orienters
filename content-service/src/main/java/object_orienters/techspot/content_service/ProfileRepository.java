package object_orienters.techspot.content_service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends PagingAndSortingRepository<Profile, String> {

    @Query("SELECT f FROM Profile u JOIN u.followers f WHERE u.username = :userName")
    Page<Profile> findFollowersByUserId(String userName, Pageable pageable);

    @Query("SELECT f FROM Profile u JOIN u.followers f WHERE f.username = :username AND u.username = :accountUsername")
    Optional<Profile> findFollowerByUsername(String accountUsername, String username); // fixme

    @Query("SELECT f FROM Profile u JOIN u.following f WHERE u.username = :userName")
    Page<Profile> findFollowingByUserId(String userName, Pageable pageable);

    @Query("SELECT f FROM Profile u JOIN u.following f WHERE f.username = :username AND u.username = :accountUsername")
    Optional<Profile> findFollowingByUsername(String accountUsername, String username);

    Optional<Profile> findByUsername(String username);

    Optional<Profile> findByEmail(String email);

    List<Profile> findByName(String Name);

    @Query("SELECT u FROM Profile u WHERE u.username = :username")
    Optional<Profile> findById(String username);

    Profile save(Profile profile);

    void delete(Profile profile);

    @Query("SELECT p FROM Profile p WHERE lower(p.name) LIKE lower(concat('%', :searchTerm, '%')) " +
            "OR lower(p.username) LIKE lower(concat('%', :searchTerm, '%')) " +
            "OR lower(p.email) LIKE lower(concat('%', :searchTerm, '%'))")
    Page<Profile> findBySearchCriteria(@Param("searchTerm") String searchTerm, Pageable pageable);

    @Query("SELECT f FROM Profile u JOIN u.following v JOIN v.following f WHERE u.username = :username")
    Page<Profile> findFollowingOfFollowing(String username, Pageable pageable);

    @Query("SELECT f FROM Profile u JOIN u.followers f WHERE u.username = :username")
    List<Profile> findFollowersByUserId(String username);

    @Query("SELECT f FROM Profile u JOIN u.following f WHERE u.username = :userName")
    List<Profile> findFollowingByUserId(String userName);

}
