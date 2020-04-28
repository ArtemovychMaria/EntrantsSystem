package com.example.EntrantsSystem.controllers;

import com.example.EntrantsSystem.dto.UserDto;
import com.example.EntrantsSystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/create")
    public String create(@ModelAttribute UserDto userDto, HttpServletRequest req){
        userService.save(userDto);
        return "redirect:/login";
    }
}
