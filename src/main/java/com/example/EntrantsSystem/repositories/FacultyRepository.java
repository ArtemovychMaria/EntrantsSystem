package com.example.EntrantsSystem.repositories;

import com.example.EntrantsSystem.domain.Faculty;
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
public interface FacultyRepository extends JpaRepository<Faculty,Integer> {

    public Optional<Faculty> findByName(String name);

}
