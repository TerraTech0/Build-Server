package com.example.quiz.Service;

import com.example.quiz.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {

    ArrayList<Student> students = new ArrayList<>();

    public ArrayList<Student> getStudents(){
        return students;
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public boolean updateStudent(int id, Student student){
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id){
                students.set(i, student);
                return true;
            }
        }
        return false;
    }

    public boolean removeStudent(int id){
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id){
                students.remove(i);
                return true;
            }
        }
        return false;
    }


    //search by name!
    public Student searchByName(String name){
        for (Student student : students){
            if (student.getName().equalsIgnoreCase(name)){
                return student;
            }
        }
        return null;
    }

    //search by major and return a list of student
    public ArrayList<Student> searchByMajor(String major){
        ArrayList<Student> student = new ArrayList<>();
        for (Student student1 : students){
            if (student1.getMajor().equalsIgnoreCase(major)){
                student.add(student1);
                return student;
            }
        }
        return null;
    }


}
