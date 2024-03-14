package com.example.quiz.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Teacher {

    @NotNull(message = "id can't be null!")
    private int id;

    @NotEmpty(message = "name can't be empty!")
    private String name;

    @NotNull(message = "salary can't be null!")
    private double salary;
}
