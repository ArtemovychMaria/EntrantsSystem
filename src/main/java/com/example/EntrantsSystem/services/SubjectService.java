package com.example.EntrantsSystem.services;

import com.example.EntrantsSystem.domain.Faculty;
import com.example.EntrantsSystem.domain.Subject;
import com.example.EntrantsSystem.repositories.FacultyRepository;
import com.example.EntrantsSystem.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {


    private SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public void create(Subject subject){
        subjectRepository.save(subject);
    }

    public List<Subject> readAll(){
        return subjectRepository.findAll();
    }

}
