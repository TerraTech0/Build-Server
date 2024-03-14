package com.example.quiz.Controller;

import com.example.quiz.ApiResponse.ApiResponse;
import com.example.quiz.Model.Teacher;
import com.example.quiz.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;


    @GetMapping("/get")
    public ArrayList<Teacher> getTeachers(){
        return teacherService.getTeachers();
    }

    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("teacher added successfully!"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable int id, @RequestBody @Valid Teacher teacher, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        teacherService.updateTeacher(id, teacher);
        return ResponseEntity.status(200).body(new ApiResponse("teacher updated successfully!"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity removeTeacher(@PathVariable int id){
        teacherService.removeTeacher(id);
        return ResponseEntity.status(200).body(new ApiResponse("teacher deleted successfully!"));
    }


    @GetMapping("/get/{id}")
    public ResponseEntity searchById(@PathVariable int id){
        Teacher teacher = teacherService.searchById(id);
        return ResponseEntity.status(200).body(teacher);
    }


    @GetMapping("/get-salary/{salary}")
    public ResponseEntity searchBySalary(@PathVariable double salary){
        ArrayList<Teacher> teacher = teacherService.searchBySalary(salary);
        return ResponseEntity.status(200).body(teacher);
    }

}
