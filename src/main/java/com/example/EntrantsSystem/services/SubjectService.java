package com.example.EntrantsSystem.services;

import com.example.EntrantsSystem.domain.Faculty;
import com.example.EntrantsSystem.domain.Subject;
import com.example.EntrantsSystem.repositories.FacultyRepository;
import com.example.EntrantsSystem.repositories.SubjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    private static final Logger Log= LoggerFactory.getLogger(SubjectService.class);


    private SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public void create(Subject subject){
        Log.trace("Saving new subject to db");
        subjectRepository.save(subject);
    }

    public List<Subject> readAll(){
        return subjectRepository.findAll();
    }

    public Optional<Subject> readByName(String name){
        return subjectRepository.findByName(name);
    }

}
