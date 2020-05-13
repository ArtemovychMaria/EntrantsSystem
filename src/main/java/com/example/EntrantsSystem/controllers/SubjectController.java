package com.example.EntrantsSystem.controllers;

import com.example.EntrantsSystem.domain.Faculty;
import com.example.EntrantsSystem.domain.Subject;
import com.example.EntrantsSystem.services.FacultyService;
import com.example.EntrantsSystem.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SubjectController {

    SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping("/addSubject")
    public String create(@ModelAttribute Subject subject, HttpServletRequest req){
            subjectService.create(subject);
            return "home";
        }

    @GetMapping("/newSubject")
    public String getAddSubjectPage() {
        return "addSubject";
    }
}
