package com.example.EntrantsSystem.services;

import com.example.EntrantsSystem.domain.Certificate;
import com.example.EntrantsSystem.domain.User;
import com.example.EntrantsSystem.dto.CertificateDto;
import com.example.EntrantsSystem.repositories.CertificateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CertificateService {


    private CertificateRepository certificateRepository;
    UserService userService;

    @Autowired
    public CertificateService(CertificateRepository certificateRepository,UserService userService) {
        this.certificateRepository = certificateRepository;
        this.userService=userService;
    }

    public void save(int userId, CertificateDto certificateDto) {
        Certificate certificate=new Certificate(certificateDto.getIdentificationNumber(),
                certificateDto.getAverageGrade());
        Optional<User> maybeUser = userService.readById(userId);
        if(maybeUser.isPresent()){
            certificate.setUser(maybeUser.get());
        }
        certificateRepository.save(certificate);
    }

    public Certificate readByUserId(int userId){
        return certificateRepository.findByUserId(userId);
    }

    public boolean checkIfExist(int userId){
        return certificateRepository.checkIfExist(userId);
    }

}
