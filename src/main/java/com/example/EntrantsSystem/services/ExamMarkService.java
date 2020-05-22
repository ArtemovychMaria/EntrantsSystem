package com.example.EntrantsSystem.services;

import com.example.EntrantsSystem.domain.ExamMark;
import com.example.EntrantsSystem.domain.Subject;
import com.example.EntrantsSystem.domain.User;
import com.example.EntrantsSystem.dto.ExamMarkDto;
import com.example.EntrantsSystem.repositories.ExamMarkRepository;
import jdk.internal.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamMarkService {

    private ExamMarkRepository examMarkRepository;
    private SubjectService subjectService;
    private UserService userService;

    @Autowired
    public ExamMarkService(ExamMarkRepository examMarkRepository, SubjectService subjectService, UserService userService) {
        this.examMarkRepository = examMarkRepository;
        this.subjectService = subjectService;
        this.userService = userService;
    }

    public void save(ExamMarkDto examMarkDto, int userId) {
        ExamMark examMark=new ExamMark();
        examMark.setValue(examMarkDto.getMark());
        Optional<Subject> maybeSubject = subjectService.readByName(examMarkDto.getSubjectName());
        if(maybeSubject.isPresent()){
            examMark.setSubject(maybeSubject.get());
        }

        Optional<User> maybeUser = userService.readById(userId);
        if(maybeUser.isPresent()){
            examMark.setUser(maybeUser.get());
        }
        examMarkRepository.save(examMark);
    }

    public int getSubjectMarkByUser(int subjectId,int userId){
        ExamMark bySubjectIdAndUserId = examMarkRepository.findBySubjectIdAndUserId(subjectId, userId);
        return bySubjectIdAndUserId.getValue();
    }

    public List<String> allSubjectsByUser(int userId){
        return examMarkRepository.getSubjects(userId);
    }
}
