package com.codingshuttle.linkedin.uploader_service.config;

import com.cloudinary.Cloudinary;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Map;

@Configuration
public class UploaderConfig {

    @Value("${cloudinary.cloud-name}")
    private String cloudName;

    @Value("${cloudinary.api-key}")
    private String apiKey;

    @Value("${cloudinary.api-secret}")
    private String apiSecret;

    @Bean
    public Cloudinary cloudinary() {

        Map<String, String> configMap = Map.of(
                "cloud_name", cloudName,
                "api_key", apiKey,
                "api_secret", apiSecret
        );

        return new Cloudinary(configMap);
    }

    @Value("${gcs.access-account}")
    private String serviceAccountJson;

    @Bean
    public Storage storage() throws IOException {
        return StorageOptions.newBuilder()
                .setCredentials(ServiceAccountCredentials.fromStream(
                        new ByteArrayInputStream(serviceAccountJson.getBytes())))
                .build()
                .getService();
    }
}
