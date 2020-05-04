package com.example.EntrantsSystem.controllers;

import com.example.EntrantsSystem.domain.User;
import com.example.EntrantsSystem.dto.UserDto;
import com.example.EntrantsSystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Iterator;
import java.util.List;

@Controller
public class UserController {

    UserService userService;
    Validator validator;

    @Autowired
    public UserController(UserService userService,
                          @Qualifier("userRegisterValidator") Validator validator) {
        this.userService = userService;
        this.validator = validator;
    }

    @PostMapping("/create")
    public String create(Model model, @ModelAttribute @Valid UserDto userDto, HttpServletRequest req,
                         BindingResult res ){
        validator.validate(userDto,res);
        if(res.hasErrors()){
            return "registration";
        }
            userService.save(userDto);
            return "redirect:/login";
        }

    @GetMapping("/confirmEmail")
    public String confirmEmail(@RequestParam String hash) {
        userService.confirmEmail(hash);
        return "redirect:/login";
    }

    @GetMapping("/registration")
    public String getRegistrationPage(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "registration";
    }
}
