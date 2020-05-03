package com.example.EntrantsSystem.controllers;

import com.example.EntrantsSystem.domain.User;
import com.example.EntrantsSystem.dto.UserDto;
import com.example.EntrantsSystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/create")
    public String create(@ModelAttribute UserDto userDto, HttpServletRequest req){
        boolean usernameExist=false;
        List<User> users=userService.readAll();
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()){
            if(iterator.next().getUsername().equals(userDto.getUsername())){
                usernameExist=true;
            }
        }
        if(usernameExist){
            return "registration";
        }else {
            userService.save(userDto);
            return "redirect:/login";
        }
    }

    @GetMapping("/confirmEmail")
    public String confirmEmail(@RequestParam String hash) {
        userService.confirmEmail(hash);
        return "redirect:/login";
    }
}
