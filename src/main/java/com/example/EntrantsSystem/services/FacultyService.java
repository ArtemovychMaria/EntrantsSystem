package com.example.EntrantsSystem.services;

import com.example.EntrantsSystem.domain.Faculty;
import com.example.EntrantsSystem.domain.Subject;
import com.example.EntrantsSystem.dto.FacultyDto;
import com.example.EntrantsSystem.repositories.FacultyRepository;
import com.example.EntrantsSystem.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

@Service
public class FacultyService {


    private FacultyRepository facultyRepository;
    private SubjectRepository subjectRepository;

    @Autowired
    public FacultyService(FacultyRepository facultyRepository, SubjectRepository subjectRepository) {
        this.facultyRepository = facultyRepository;
        this.subjectRepository = subjectRepository;
    }

    public void create(FacultyDto facultyDto){
        Faculty faculty=new Faculty(facultyDto.getName(),
                Integer.parseInt(facultyDto.getNumberOfStudents()));
        Subject subject1=subjectRepository.findByName(facultyDto.getSubjectName1());
        Subject subject2=subjectRepository.findByName(facultyDto.getSubjectName2());
        Subject subject3=subjectRepository.findByName(facultyDto.getSubjectName3());
        subject1.addFaculty(faculty);
        subject2.addFaculty(faculty);
        subject3.addFaculty(faculty);
        faculty.addSubject(subject1);
        faculty.addSubject(subject2);
        faculty.addSubject(subject3);
        facultyRepository.save(faculty);
    }
}
