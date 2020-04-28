package com.example.EntrantsSystem.repositories;

import com.example.EntrantsSystem.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    public Optional<User> findByUsername(String username);
}
