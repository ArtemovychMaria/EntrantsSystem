package com.example.EntrantsSystem.services;

import com.example.EntrantsSystem.domain.UserPhotoFile;
import com.example.EntrantsSystem.repositories.UserPhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class UserPhotoService {

    private UserPhotoRepository userPhotoRepository;

    @Autowired
    public UserPhotoService(UserPhotoRepository userPhotoRepository){
        this.userPhotoRepository=userPhotoRepository;
    }

    public UserPhotoFile save(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            UserPhotoFile userPhotoFile = new UserPhotoFile(fileName, file.getContentType(), file.getBytes());
            return userPhotoRepository.save(userPhotoFile);
        } catch (IOException ex) {
            throw new RuntimeException("Could not store file " + fileName, ex);
        }
    }

    public UserPhotoFile findById(String fileId) {
        return userPhotoRepository.findById(fileId)
                .orElseThrow(() -> new RuntimeException("File not found with id " + fileId));
    }
}
