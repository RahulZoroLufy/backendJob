package com.eazybytes.jobportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAwareImpl")
//@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class}
//exclude means spring boot will not create bean for this class at the stratup or using auto configuration.
public class JobPortalApplocation {

    public static void main(String[] args) {
        SpringApplication.run(JobPortalApplocation.class, args);
    }

}
