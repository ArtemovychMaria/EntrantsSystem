package com.example.EntrantsSystem.services;

import com.example.EntrantsSystem.domain.Faculty;
import com.example.EntrantsSystem.domain.Statement;
import com.example.EntrantsSystem.domain.User;
import com.example.EntrantsSystem.dto.StatementDto;
import com.example.EntrantsSystem.repositories.StatementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class StatementService {

    private final EntityManager entityManager;
    private final StatementRepository statementRepository;

    @Autowired
    public StatementService(EntityManager entityManager, StatementRepository statementRepository) {
        this.entityManager = entityManager;
        this.statementRepository = statementRepository;
    }

    public void add(StatementDto statementDto, int userId) {
        Statement statement=new Statement();
        Faculty faculty = entityManager.getReference(Faculty.class, statementDto.getFacultyId());
        User user = entityManager.getReference(User.class,userId);

        statement.setUser(user);
        statement.setFaculty(faculty);
        statement.setAverageGradeOfCertificate(statementDto.getCertificateGrade());
        statement.setSubjectGrade1(statementDto.getSubjectGrade1());
        statement.setSubjectGrade2(statementDto.getSubjectGrade2());
        statement.setSubjectGrade3(statementDto.getSubjectGrade3());
        statement.setFinalGrade(statementDto.getSubjectGrade1() + statementDto.getSubjectGrade2()
                + statementDto.getSubjectGrade3() +
                statementDto.getCertificateGrade());
        statement.setConfirmed(false);
        statementRepository.save(statement);
    }
}
