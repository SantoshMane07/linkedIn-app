package com.codingshuttle.linkedin.uploader_service.controller;

import com.codingshuttle.linkedin.uploader_service.service.FileUploaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
public class FileUploadController {

    private final FileUploaderService fileUploaderService;

    @PostMapping
    public ResponseEntity<String> uploadImage(@RequestParam MultipartFile file) {
        try {
            String url = fileUploaderService.upload(file);
            return ResponseEntity.ok(url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
