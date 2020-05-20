package com.example.EntrantsSystem.controllers;

import com.example.EntrantsSystem.domain.Faculty;
import com.example.EntrantsSystem.domain.Subject;
import com.example.EntrantsSystem.services.FacultyService;
import com.example.EntrantsSystem.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
public class SubjectController {

    SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping("/addSubject")
    public String create(@ModelAttribute Subject subject, HttpServletRequest req, Model model) {
        Optional<Subject> maybeSubject = subjectService.readByName(subject.getName());
        if (maybeSubject.isPresent()) {
            model.addAttribute("msg", "Subject already exist");
            return "exceptionPage";
        } else {
            subjectService.create(subject);
            return "redirect:/newSubject";
        }
    }

    @GetMapping("/newSubject")
    public String getAddSubjectPage() {
        return "addSubject";
    }
}
