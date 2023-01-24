package com.abhay.app.controller;

import com.abhay.app.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StudentController {

    @GetMapping("/get/students")
    public List<Student> getStudents(){
        List listStudent = new ArrayList<>();

        Student student1 = new Student("1","rohan","15","male");
        Student student2 = new Student("2","riya","17","female");
        Student student3 = new Student("3","raj","18","male");

        listStudent.add(student1);
        listStudent.add(student2);
        listStudent.add(student3);

        return listStudent;

    }

   @GetMapping("/map/students")
    public Map mapStudents() {

        Map studentMap = new HashMap();

       Student student1 = new Student("1","rohan","15","male");
       Student student2 = new Student("2","riya","17","female");
       Student student3 = new Student("3","raj","18","male");

       studentMap.put(student1.getId(),student1);
       studentMap.put(student2.getId(),student2);
       studentMap.put(student3.getId(),student3);

       return studentMap;
   }
}
