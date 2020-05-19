package com.example.EntrantsSystem.controllers;

import com.example.EntrantsSystem.domain.Faculty;
import com.example.EntrantsSystem.domain.Subject;
import com.example.EntrantsSystem.dto.FacultyDto;
import com.example.EntrantsSystem.dto.UserDto;
import com.example.EntrantsSystem.repositories.SubjectRepository;
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
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Controller
public class FacultyController {

    @Autowired
    SubjectRepository subjectRepository;

    FacultyService facultyService;
    SubjectService subjectService;

    @Autowired
    public FacultyController(FacultyService facultyService,SubjectService subjectService) {
        this.facultyService = facultyService;
        this.subjectService = subjectService;
    }

    @PostMapping("/add")
    public String create(@ModelAttribute FacultyDto facultyDto, HttpServletRequest req,Model model){
        Optional<Faculty> maybeFaculty = facultyService.readByName(facultyDto.getName());
        if(maybeFaculty.isPresent()){
            model.addAttribute("msg","Faculty alredy exist");
            return "exceptionPage";
        }else {
            facultyService.create(facultyDto);
            return "home";
        }
        }

    @PostMapping("/update")
    public String update(@RequestParam("id") int id,
                         @RequestParam("name") String name,
                         @RequestParam("budgetPlan") int budgetPlan,
                         @RequestParam("commercialPlan") int commercialPlan,
                         @RequestParam("subjectName1") String  subjectName1,@RequestParam("subjectName2") String  subjectName2,
                         @RequestParam("subjectName3") String  subjectName3){
        Faculty faculty=new Faculty(name,budgetPlan,commercialPlan);
        faculty.setId(id);
        Optional<Subject> maybeSubject1 = subjectService.readByName(subjectName1);
        Optional<Subject> maybeSubject2 = subjectService.readByName(subjectName2);
        Optional<Subject> maybeSubject3 = subjectService.readByName(subjectName3);

        Set<Subject> subjects=new HashSet<>();

        if(maybeSubject1.isPresent()) {
            Subject subject1 = maybeSubject1.get();
            subjects.add(subject1);
        }
        if(maybeSubject2.isPresent()) {
            Subject subject2 = maybeSubject2.get();
            subjects.add(subject2);
        }

        if(maybeSubject3.isPresent()){
            Subject subject3 = maybeSubject3.get();
            subjects.add(subject3);
        }

        faculty.setRequiredSubjects(subjects);
        facultyService.save(faculty);
        return "allFaculties";
    }

    @GetMapping("/new")
    public String getAddFacultyPage(HttpServletRequest req) {
        req.setAttribute("subjects",subjectService.readAll());
        return "addFaculty";
    }

    @GetMapping("/allFaculties")
    public String showAll(Model model){
        model.addAttribute("faculties",facultyService.getAll());
        return "allFaculties";
    }

    @GetMapping("/edit")
    public String getEditPage(@RequestParam(value = "id") int facultyId, Model model){
        Optional<Faculty> maybeFaculty = facultyService.readById(facultyId);
        if(maybeFaculty.isPresent()){
            Faculty faculty=maybeFaculty.get();
            model.addAttribute("faculty",faculty);
            model.addAttribute("subjects",subjectService.readAll());
        }
        return "editFaculty";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(value = "id") int facultyId){
        facultyService.delete(facultyId);
        return "redirect:/allFaculties";
    }
}
