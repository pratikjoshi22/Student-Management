package com.example.education.StudentManagement.Service;

import com.example.education.StudentManagement.dto.StudentDtoByName;
import com.example.education.StudentManagement.model.Student;
import com.example.education.StudentManagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    public Student createStudent(Student student)
    {
        Student student1=new Student();
        if (student!=null)
        {
            student1 = studentRepository.save(student);
        }
        return  student1;
    }
    public List<Student> getallStudent()
    {
        List<Student> studentlist =studentRepository.findAll();
        if(!studentlist.isEmpty())
        {
            return studentlist;
        }
        return null;
    }
    public Student getStudentById(Long id)
    {
        Student student1=new Student();
        student1 = studentRepository.findById(id).orElse(null);


        return student1;
    }
    public List<Student> getStudentByName(String name)
    {
        List<Student> studentlist =studentRepository.findByFirstName(name);

        if(!studentlist.isEmpty())
        {
            return studentlist;
        }
        else
        {
            return null;
        }


    }
    public  List<Student> getStudentBycollegeName(String name)
    {
        List<Student> studentlist = studentRepository.findByCollegeName(name);
        if (!studentlist.isEmpty())
        {
            return  studentlist;
        }
        else
        {
            return null;
        }
    }




}
