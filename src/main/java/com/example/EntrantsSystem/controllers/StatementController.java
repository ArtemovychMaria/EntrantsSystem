package com.example.EntrantsSystem.controllers;

import com.example.EntrantsSystem.domain.Faculty;
import com.example.EntrantsSystem.domain.Statement;
import com.example.EntrantsSystem.domain.Subject;
import com.example.EntrantsSystem.dto.StatementDto;
import com.example.EntrantsSystem.security.CustomUserDetails;
import com.example.EntrantsSystem.services.FacultyService;
import com.example.EntrantsSystem.services.StatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
import java.util.Set;

@Controller
public class StatementController {

    FacultyService facultyService;
    StatementService statementService;

    @Autowired
    public StatementController(FacultyService facultyService,StatementService statementService) {
        this.facultyService = facultyService;
        this.statementService=statementService;
    }

    @PostMapping("/addStatement")
    public String create(@ModelAttribute StatementDto statementDto, Authentication authentication){
            CustomUserDetails customUserDetails= (CustomUserDetails) authentication.getPrincipal();
            statementService.add(statementDto,customUserDetails.getUserId());
            return "home";
        }

    @GetMapping("/apply")
    public String getAddStatementPage(@RequestParam(value = "id") int facultyId, HttpServletRequest req) {
        Optional<Faculty> byId = facultyService.getById(facultyId);
        if(byId.isPresent()){
            Faculty faculty=byId.get();
            Set<Subject> requiredSubjects = faculty.getRequiredSubjects();
            Subject [] subjects=new Subject[requiredSubjects.size()];
            requiredSubjects.toArray(subjects);
            req.setAttribute("faculty",faculty);
            req.setAttribute("subject1",subjects[0]);
            req.setAttribute("subject2",subjects[1]);
            req.setAttribute("subject3",subjects[2]);
        }
        return "addStatement";
    }

    @GetMapping("/applications")
    public String getConfirmApplicationPage(Model model){
        model.addAttribute("statements", statementService.readAllUnconfirmed());
        return "confirmingApplications";
    }

    @GetMapping("/confirm")
    public String confirm(@RequestParam(value = "id") int statementId){
        statementService.updateConfirmedById(true,statementId);
        return "home";
    }

    @GetMapping("/reject")
    public String reject(@RequestParam(value = "id") int statementId){
        statementService.updateRejectedById(true,statementId);
        return "home";
    }

    @GetMapping("/show")
    public String showAll(@RequestParam(value = "id") int facultyId,Model model){
            model.addAttribute("statements",statementService.showAllConfirmedByFaculty(facultyId));
        return "allStatements";
    }


}
