package com.example.quiz.Service;

import com.example.quiz.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherService {
    ArrayList<Teacher> teachers = new ArrayList<>();


    //CRUD

    public ArrayList<Teacher> getTeachers(){
        return teachers;
    }

    public void addTeacher(Teacher teacher){
        teachers.add(teacher);
    }

    public boolean updateTeacher(int id, Teacher teacher){
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id){
                teachers.set(i, teacher);
                return true;
            }
        }
        return false;
    }


    public boolean removeTeacher(int id){
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id){
                teachers.remove(i);
                return true;
            }
        }
        return false;
    }

    /*
    Create an endpoint that takes a teacher id and returns one teacher .
    Create an endpoint that takes a salary and return all teachers who have this salary or above .
     */
    public Teacher searchById(int id){
        for (Teacher teacher : teachers){
            if (teacher.getId() == id){
                return teacher;
            }
        }
        return null;
    }

    public ArrayList<Teacher> searchBySalary(double salary){
        ArrayList<Teacher> teachers1 = new ArrayList<>();
        for (Teacher teacher : teachers){
            if (teacher.getSalary() == salary){
                teachers1.add(teacher);
                return teachers1;
            }
        }
        return null;
    }
}
