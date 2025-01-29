package com.codingshuttle.linkedin.uploader_service.service;

import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GoogleCloudStorageFileUploaderService implements FileUploaderService{

    private final Storage storage;

    @Value("${gcs.bucket-name}")
    private String bucketName;

    @Override
    public String upload(MultipartFile file) throws IOException {
        String fileName = UUID.randomUUID() + "-" + file.getOriginalFilename();
        BlobInfo blobInfo = BlobInfo.newBuilder(bucketName, fileName).build();
        storage.create(blobInfo, file.getBytes());
        return String.format("https://storage.googleapis.com/%s/%s", bucketName, fileName);
    }
}
