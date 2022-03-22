package com.example.education.StudentManagement.Service;

import com.example.education.StudentManagement.dto.StudentDtoByName;
import com.example.education.StudentManagement.model.Student;
import com.example.education.StudentManagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student createStudent(Student student) {
        Student student1 = new Student();
        if (student != null) {
            student1 = studentRepository.save(student);
        }
        return student1;
    }

    public List<Student> getallStudent() {
        List<Student> studentlist = studentRepository.findAll();
        if (!studentlist.isEmpty()) {
            return studentlist;
        }
        return null;
    }

    public Student getStudentById(Long id) {
        Student student1 = new Student();
        student1 = studentRepository.findById(id).orElse(null);


        return student1;
    }

    public List<Student> getStudentByName(String name) {
        List<Student> studentlist = studentRepository.findByFirstName(name);

        if (!studentlist.isEmpty()) {
            return studentlist;
        } else {
            return null;
        }


    }

    public List<Student> getStudentBycollegeName(String name) {
        List<Student> studentlist = studentRepository.findByCollegeName(name);
        if (!studentlist.isEmpty()) {
            return studentlist;
        } else {
            return null;
        }
    }

    public Student updateStudent(Student student) {
        if (student.getId() == null) {
            return studentRepository.save(student);
        } else {
            Optional<Student> studentExisting = studentRepository.findById(student.getId());
            if (studentExisting != null) {
                Student student1 = studentExisting.get();
                student1.setFirstName(student.getFirstName());
                student1.setCollegeName(student.getCollegeName());
                student1 = studentRepository.save(student1);
                return student1;
            }
            else
            {
                student = studentRepository.save(student);
                return student;
            }
        }
    }




}
