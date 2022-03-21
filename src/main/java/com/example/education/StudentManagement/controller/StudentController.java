package com.example.education.StudentManagement.controller;

import com.example.education.StudentManagement.Service.StudentService;
import com.example.education.StudentManagement.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
 @Autowired
    StudentService studentService;
    @PostMapping("/create")
    public String createStudent(@ModelAttribute Student student )
    {
        studentService.createStudent(student);
        return "redirect:/student/readall";

    }
    @GetMapping("/readall")
    public String getallStudent(Model model)
    {
        model.addAttribute("students",studentService.getallStudent());
        return "list-students";
    }
    @GetMapping("/edit/{id}")
    public String updateStudent(@PathVariable("id") Long id, Model model)
    {
        //studentService.getStudentByName(student);
        model.addAttribute("student",studentService.getStudentById(id));
        return "update-student";

    }
    @PostMapping("edit")


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
    @GetMapping("/add")
    public String showAddStudentForm(@ModelAttribute Student student){
        return "add-student";

    }



}
