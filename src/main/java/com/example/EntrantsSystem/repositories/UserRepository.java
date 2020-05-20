package com.example.EntrantsSystem.repositories;

import com.example.EntrantsSystem.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User,Integer> {

    public Optional<User> findByUsername(String username);

    Optional<User> findByVerifyEmailHash(String hash);

    @Modifying(clearAutomatically=true)
    @Query("Update User u set u.isEmailVerified=TRUE where u.id = :userId")
    void confirmEmail(@Param("userId") int userId);

    Optional<User> findByEmail(String email);

}
