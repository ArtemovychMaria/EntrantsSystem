package com.example.EntrantsSystem.controllers;

import com.example.EntrantsSystem.domain.Faculty;
import com.example.EntrantsSystem.dto.FacultyDto;
import com.example.EntrantsSystem.dto.UserDto;
import com.example.EntrantsSystem.services.FacultyService;
import com.example.EntrantsSystem.services.SubjectService;
import com.example.EntrantsSystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class FacultyController {

    FacultyService facultyService;
    SubjectService subjectService;

    @Autowired
    public FacultyController(FacultyService facultyService,SubjectService subjectService) {
        this.facultyService = facultyService;
        this.subjectService = subjectService;
    }

    @PostMapping("/add")
    public String create(@ModelAttribute FacultyDto facultyDto, HttpServletRequest req){
            facultyService.create(facultyDto);
            return "home";
        }

    @GetMapping("/new")
    public String getAddFacultyPage(HttpServletRequest req) {
        req.setAttribute("subjects",subjectService.readAll());
        return "addFaculty";
    }
}
