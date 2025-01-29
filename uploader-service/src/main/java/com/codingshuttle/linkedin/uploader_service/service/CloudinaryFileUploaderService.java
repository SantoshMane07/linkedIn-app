package com.codingshuttle.linkedin.uploader_service.service;

import com.cloudinary.Cloudinary;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

//@Service
@RequiredArgsConstructor
@Slf4j
public class CloudinaryFileUploaderService implements FileUploaderService{

    private final Cloudinary cloudinary;

    @Override
    public String upload(MultipartFile file) throws IOException {
        Map uploadResult = cloudinary.uploader().upload(file.getBytes(), Map.of());
        return uploadResult.get("secure_url").toString();
    }
}
