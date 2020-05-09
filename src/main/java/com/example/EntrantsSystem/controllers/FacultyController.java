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
    public String create(@ModelAttribute FacultyDto facultyDto, HttpServletRequest req){
            facultyService.create(facultyDto);
            return "home";
        }

    @PostMapping("/update")
    public String update(@RequestParam("id") int id,
                         @RequestParam("name") String name,
                         @RequestParam("numberOfStudents") int numberOfStudents,
                         @RequestParam("subjectName1") String  subjectName1,@RequestParam("subjectName2") String  subjectName2,
                         @RequestParam("subjectName3") String  subjectName3){
        Faculty faculty=new Faculty(name,numberOfStudents);
        faculty.setId(id);
        faculty.setRequiredSubjects(new HashSet<>(Arrays.asList(subjectRepository.findByName(subjectName1),
                subjectRepository.findByName(subjectName2),subjectRepository.findByName(subjectName3))));
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
    public String showAll(@RequestParam(value = "id") int facultyId, Model model){
        Optional<Faculty> maybeFaculty = facultyService.readById(facultyId);
        if(maybeFaculty.isPresent()){
            Faculty faculty=maybeFaculty.get();
            model.addAttribute("faculty",faculty);
            model.addAttribute("subjects",subjectService.readAll());
        }
        return "editFaculty";
    }




}
