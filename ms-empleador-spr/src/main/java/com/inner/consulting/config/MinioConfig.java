package com.inner.consulting.config;

import io.minio.MinioClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinioConfig {

    @Bean
    public MinioClient minioClient() {
        return MinioClient.builder()
                .endpoint("http://minio-service-clusterip:9000")
                //.endpoint("http://localhost:9000")
               // .endpoint("http://34.28.236.187:9000")
                .credentials("minio", "minio123")
                .build();
    }
}
