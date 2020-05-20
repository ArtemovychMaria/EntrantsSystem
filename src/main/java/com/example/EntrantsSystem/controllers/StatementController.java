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
    public String create(@ModelAttribute StatementDto statementDto, Authentication authentication,Model model){
            CustomUserDetails customUserDetails= (CustomUserDetails) authentication.getPrincipal();
            if(!statementService.checkIfExist(statementDto.getFacultyId(),customUserDetails.getUserId())){
            statementService.add(statementDto,customUserDetails.getUserId());
            return "redirect:/allFaculties";
        }else{
                model.addAttribute("msg","You have already applied to this faculty");
                return "exceptionPage";
            }
        }

    @GetMapping("/apply")
    public String getAddStatementPage(@RequestParam(value = "id") int facultyId, HttpServletRequest req,
                                      Authentication authentication,Model model) {
        CustomUserDetails customUserDetails= (CustomUserDetails) authentication.getPrincipal();
        if(statementService.checkIfExist(facultyId,customUserDetails.getUserId())){
            model.addAttribute("msg","You have already applied to this faculty");
            return "exceptionPage";
        }else {
            Optional<Faculty> byId = facultyService.getById(facultyId);
            if (byId.isPresent()) {
                Faculty faculty = byId.get();
                Set<Subject> requiredSubjects = faculty.getRequiredSubjects();
                Subject[] subjects = new Subject[requiredSubjects.size()];
                requiredSubjects.toArray(subjects);
                req.setAttribute("faculty", faculty);
                req.setAttribute("subject1", subjects[0]);
                req.setAttribute("subject2", subjects[1]);
                req.setAttribute("subject3", subjects[2]);
            }
            return "addStatement";
        }
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

    @GetMapping("/cancel")
    public String reject(@RequestParam(value = "id") int facultyId,Authentication authentication,Model model){
        CustomUserDetails customUserDetails= (CustomUserDetails) authentication.getPrincipal();
        int userId=customUserDetails.getUserId();
        if(statementService.checkIfExist(facultyId,userId)){
            statementService.deleteStatement(facultyId,userId);
            return "redirect:/allFaculties";
        }else{
            model.addAttribute("msg","You don`t have application to this faculty");
            return "exceptionPage";
        }
    }


}
