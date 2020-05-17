package com.example.EntrantsSystem.controllers;

import com.example.EntrantsSystem.domain.UserPhotoFile;
import com.example.EntrantsSystem.services.UserPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/user-photo-files")
public class UserPhotoController {

    @Autowired
    private UserPhotoService userPhotoService;

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("photoFile") MultipartFile file) {
        UserPhotoFile userPhotoFile = userPhotoService.save(file);
        return userPhotoFile.getId();
    }

    @GetMapping("/download/{fileId}")
    public ResponseEntity <Resource> downloadFile(@PathVariable String fileId) {
        UserPhotoFile userPhotoFile = userPhotoService.findById(fileId);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(userPhotoFile.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + userPhotoFile.getFileName())
                .body(new ByteArrayResource(userPhotoFile.getData()));
    }
}
