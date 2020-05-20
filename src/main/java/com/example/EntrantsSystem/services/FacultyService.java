package com.example.EntrantsSystem.services;

import com.example.EntrantsSystem.domain.Faculty;
import com.example.EntrantsSystem.domain.Subject;
import com.example.EntrantsSystem.dto.FacultyDto;
import com.example.EntrantsSystem.repositories.FacultyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyService {

    private static final Logger Log= LoggerFactory.getLogger(FacultyService.class);

    private FacultyRepository facultyRepository;
    private SubjectService subjectService;
    private StatementService statementService;

    @Autowired
    public FacultyService(FacultyRepository facultyRepository, SubjectService subjectService,
                          StatementService statementService) {
        this.facultyRepository = facultyRepository;
        this.subjectService = subjectService;
        this.statementService = statementService;
    }

    public void create(FacultyDto facultyDto){
        Faculty faculty=new Faculty(facultyDto.getName(),facultyDto.getBudgetPlan(),facultyDto.getCommercialPlan());
        Optional<Subject> byName1 = subjectService.readByName(facultyDto.getSubjectName1());
        Optional<Subject> byName2 = subjectService.readByName(facultyDto.getSubjectName2());
        Optional<Subject> byName3 = subjectService.readByName(facultyDto.getSubjectName3());
        if(byName1.isPresent()){
            Subject subject1 = byName1.get();
            subject1.addFaculty(faculty);
            faculty.addSubject(subject1);
        }
        if(byName2.isPresent()){
            Subject subject2 = byName2.get();
            subject2.addFaculty(faculty);
            faculty.addSubject(subject2);
        }
        if(byName3.isPresent()){
            Subject subject3 = byName3.get();
            subject3.addFaculty(faculty);
            faculty.addSubject(subject3);
        }

        facultyRepository.save(faculty);
    }

    public void save(Faculty faculty){
        Log.trace("Updating faculty");
        facultyRepository.save(faculty);
    }

    public List<Faculty> getAll(){
        return facultyRepository.findAll();
    }

    public Optional<Faculty> getById(int id) {
        return facultyRepository.findById(id);
    }

    public Optional<Faculty> readById(int id) {
        return facultyRepository.findById(id);
    }

    public Optional<Faculty> readByName(String name) {
        return facultyRepository.findByName(name);
    }

    public void delete(int facultyId){
        statementService.deleteByFacultyId(facultyId);
        facultyRepository.deleteById(facultyId);
    }
}
