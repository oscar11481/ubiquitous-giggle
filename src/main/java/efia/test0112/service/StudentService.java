package efia.test0112.service;

import java.util.List;

import efia.test0112.entity.Student;

public interface StudentService {

    int addStudent(Student student);

    int deleteStudent(int id);

    int updateStudent(Student student);

    Student getStudentById(int id);

    List<Student> listStudent();
    
    void syncQizTable();
}
