package com.example.EntrantsSystem.repositories;

import com.example.EntrantsSystem.domain.Faculty;
import com.example.EntrantsSystem.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Integer> {

    public Subject findByName(String name);

}
