package com.example.EntrantsSystem.services;

import com.example.EntrantsSystem.domain.Faculty;
import com.example.EntrantsSystem.domain.Statement;
import com.example.EntrantsSystem.domain.Subject;
import com.example.EntrantsSystem.domain.User;
import com.example.EntrantsSystem.dto.StatementDto;
import com.example.EntrantsSystem.repositories.StatementRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Service
public class StatementService {

    private static final Logger Log= LoggerFactory.getLogger(StatementService.class);

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
        int summarySubjectsGrade=statementDto.getSubjectGrade1() + statementDto.getSubjectGrade2()
                + statementDto.getSubjectGrade3();
        statement.setSummarySubjectsGrade(summarySubjectsGrade);
        statement.setFinalGrade(summarySubjectsGrade + statementDto.getCertificateGrade());
        statement.setConfirmed(false);
        statement.setRejected(false);
        statementRepository.save(statement);
    }

    public List<Statement> readAllRejectedByUser(int userId){
        Log.info("Getting all rejected user`s statements");
        return statementRepository.findByUserIdAndRejectedTrue(userId);
    }

    public List<Statement> readAllUnconfirmed(){
        return statementRepository.findByConfirmedFalseAndRejectedFalse();
    }

    public Optional<Statement> readById(int statementId){
        Log.info("Getting statement by id");
        return statementRepository.findById(statementId);
    }

    public void save(Statement statement){
        statementRepository.save(statement);
    }

    public List<Statement> showAllConfirmedByFaculty(int facultyId){
        Log.info("Showing all confirmed statements");
        return statementRepository.findByFacultyIdAndConfirmedTrueOrderByFinalGradeDesc(facultyId);
    }

    public void updateConfirmedById(boolean confirmed, int statementId){
        statementRepository.updateConfirmedById(confirmed,statementId);
    }

    public void updateRejectedById(boolean rejected, int statementId){
        statementRepository.updateRejectedById(rejected,statementId);
    }

    public boolean checkIfExist(int facultyId,int userId){
        return statementRepository.checkIfExist(facultyId,userId);
    }

    public void deleteByFacultyId(int facultyId){
        statementRepository.deleteByFacultyId(facultyId);
    }

    public void deleteStatement(int facultyId,int userId) {
        statementRepository.deleteByFacultyIdAndUserId(facultyId,userId);
    }

    public boolean checkIfContainsRequiredSubjects(Subject[] requiredSubjects,List<String> userSubjects){
        for(int i=0;i<3;i++){
            if(!userSubjects.contains(requiredSubjects[i].getName())){
                return false;
            }
        }
        return true;
    }
}
