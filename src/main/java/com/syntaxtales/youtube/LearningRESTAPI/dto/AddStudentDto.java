package com.syntaxtales.youtube.LearningRESTAPI.dto;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class AddStudentDto {


    @NotBlank
    @Size(min = 3, max = 30, message = "Name Should be length of 30")
    private String name;
    @Email
    @NotBlank(message = "Email is required")
    private String email;
}
