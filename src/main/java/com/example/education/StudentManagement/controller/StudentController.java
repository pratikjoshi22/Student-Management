package com.example.education.StudentManagement.controller;

import com.example.education.StudentManagement.Service.StudentService;
import com.example.education.StudentManagement.dto.StudentDtoByName;
import com.example.education.StudentManagement.model.Student;
import net.bytebuddy.implementation.bytecode.assign.TypeCasting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
 @Autowired
    StudentService studentService;
    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student )
    {
        return  studentService.createStudent(student);

    }
    @GetMapping("/readall")
    public List<Student> getallStudent()
    {

        return studentService.getallStudent();
    }
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id)
    {
        Student student1=new Student();
        if (id != null) {
            return studentService.getStudentById(id);
        }
        return student1;


    }
    @GetMapping("/findbyname")
    public List<Student> getStudentByName(@RequestParam String name)
    {
            //System.out.println(name);
            return studentService.getStudentByName(name);


    }
    @GetMapping("/findbycname")
    public List<Student> getStudentBycollegeName(@RequestParam String coName){
        return studentService.getStudentBycollegeName(coName);
    }


}
