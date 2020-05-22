package com.example.EntrantsSystem.controllers;

import com.example.EntrantsSystem.domain.Certificate;
import com.example.EntrantsSystem.domain.User;
import com.example.EntrantsSystem.dto.CertificateDto;
import com.example.EntrantsSystem.security.CustomUserDetails;
import com.example.EntrantsSystem.services.CertificateService;
import com.example.EntrantsSystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class CertificateController {

    CertificateService certificateService;
    UserService userService;

    @Autowired
    public CertificateController(CertificateService certificateService,UserService userService){
        this.certificateService=certificateService;
        this.userService=userService;
    }

    @GetMapping("/createCertificate")
    public String getAddCertificatePage(){
        return "addCertificate";
    }

    @PostMapping("/addCertificate")
    public String addCertificate(@ModelAttribute CertificateDto certificateDto, Authentication authentication,
                                 Model model){
        CustomUserDetails customUserDetails= (CustomUserDetails) authentication.getPrincipal();
        int userId=customUserDetails.getUserId();
        if(certificateService.checkIfExist(userId)){
            model.addAttribute("msg","You have already added your certificate");
            return "exceptionPage";
        }else {
            certificateService.save(userId,certificateDto);
            return "home";
        }
    }

}
