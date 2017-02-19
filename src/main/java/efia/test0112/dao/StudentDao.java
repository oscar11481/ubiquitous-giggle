package efia.test0112.dao;

import java.util.List;

import efia.test0112.entity.Student;

public interface StudentDao {
    int addStudent(Student student);

    int deleteStudent(int id);//成功傳1，失敗傳0

    int updateStudent(Student student);

    Student getStudentById(int id);

    List<Student> listStudent();
}
