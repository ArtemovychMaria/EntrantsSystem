package com.example.EntrantsSystem.repositories;

import com.example.EntrantsSystem.domain.Faculty;
import com.example.EntrantsSystem.domain.Statement;
import com.example.EntrantsSystem.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface StatementRepository extends JpaRepository<Statement,Integer> {

    List<Statement> findByConfirmedFalseAndRejectedFalse();

    List<Statement> findByUserAndRejectedTrue(User user);

    List<Statement> findByFacultyAndConfirmedTrueOrderByFinalGradeDesc(Faculty faculty);
}
