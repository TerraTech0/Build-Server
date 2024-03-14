package com.example.quiz.Controller;

import com.example.quiz.ApiResponse.ApiResponse;
import com.example.quiz.Model.Student;
import com.example.quiz.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;


    @GetMapping("/get")
    public ArrayList<Student> getStudents(){
        return studentService.getStudents();
    }


    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody @Valid Student student, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        studentService.addStudent(student);
        return ResponseEntity.status(200).body(new ApiResponse("Student added successfully!"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable int id, @RequestBody @Valid Student student, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        studentService.updateStudent(id, student);
        return ResponseEntity.status(200).body(new ApiResponse("student updated succesffuly!"));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity removeStudent(@PathVariable int id){
        studentService.removeStudent(id);
        return ResponseEntity.status(200).body(new ApiResponse("student deleted successfully!"));
    }

    @GetMapping("/get-name/{name}")
    public ResponseEntity searchByName(@PathVariable String name){
        Student student = studentService.searchByName(name);
        return ResponseEntity.status(200).body(student);
    }

    @GetMapping("get-major/{major}") //i must put them in list
    public ResponseEntity searchByMajor(@PathVariable String major){
        ArrayList<Student> students = studentService.searchByMajor(major);
        return ResponseEntity.status(200).body(students);
    }
}
