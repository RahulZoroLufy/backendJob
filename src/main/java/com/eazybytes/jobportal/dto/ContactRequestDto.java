package com.eazybytes.jobportal.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

/**
 * DTO for {@link com.eazybytes.jobportal.entity.Contact}
 */
public record ContactRequestDto(
        @NotBlank(message = "Email can't be empty")
        @Email(message = "Invalid Emai")
        String email,

        @NotBlank(message = "Message can't be empty")
        @Size(min=5, max=500, message = "message should be between 5 to 500")
        String message,

        @NotBlank(message = "Name can't be empty")
        String name,

        @NotBlank(message = "Subject can't be empty")
        String subject,

        @NotBlank(message = "userType can't be empty")
        @Pattern(regexp = "JobSeeker|Employer|Other", message = "The user Type you provided is incorrect")
        String userType

) implements Serializable {
}