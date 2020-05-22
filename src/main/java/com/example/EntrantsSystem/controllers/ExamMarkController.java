package com.example.EntrantsSystem.controllers;

import com.example.EntrantsSystem.domain.ExamMark;
import com.example.EntrantsSystem.dto.ExamMarkDto;
import com.example.EntrantsSystem.security.CustomUserDetails;
import com.example.EntrantsSystem.services.ExamMarkService;
import com.example.EntrantsSystem.services.SubjectService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ExamMarkController {

    ExamMarkService examMarkService;
    SubjectService subjectService;

    public ExamMarkController(ExamMarkService examMarkService,SubjectService subjectService){
        this.examMarkService=examMarkService;
        this.subjectService=subjectService;
    }

    @GetMapping("/createExamMark")
    public String getAddMarkPage(Model model){
        model.addAttribute("subjects",subjectService.readAll());
        return "addExamMark";
    }

    @PostMapping("/addExamMark")
    public String addExamMark(@ModelAttribute ExamMarkDto examMarkDto, Authentication authentication){
        CustomUserDetails customUserDetails= (CustomUserDetails) authentication.getPrincipal();
        int userId=customUserDetails.getUserId();
        examMarkService.save(examMarkDto,userId);
        return "home";
    }
}
