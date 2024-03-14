package com.example.quiz.Model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {

    @NotNull(message = "id can't be null!")
    private int Id;

    @NotEmpty(message = "name can't be empty!")
    private String name;

    @NotNull(message = "age can't be null!")
    @Min(value = 18, message = "the age must be over 18")
    private int age;

    @NotEmpty(message = "major can't be empty!")
    @Pattern(regexp = "^(CS|Networks|CyberSecurity)$")
    private String major;

}
