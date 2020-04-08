package com.spring.notetaker.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "mynote")
@Getter
@Setter
public class MyNoteProperties {

    @Value("${uploadDir:/tmp/uploads/}")
    private String uploadDir;
}
