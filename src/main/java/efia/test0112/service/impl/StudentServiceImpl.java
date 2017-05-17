package efia.test0112.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import efia.test0112.dao.StudentDao;
import efia.test0112.entity.Student;
import efia.test0112.service.StudentService;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
    
    @Autowired
    private StudentDao studentDao;
    
    public int addStudent(Student student) {
        // TODO Auto-generated method stub
        return studentDao.addStudent(student);
    }

    public int deleteStudent(int id) {
        // TODO Auto-generated method stub
        return studentDao.deleteStudent(id);
    }

    public int updateStudent(Student student) {
        // TODO Auto-generated method stub
        return studentDao.updateStudent(student);
    }

    public Student getStudentById(int id) {
        // TODO Auto-generated method stub
        return studentDao.getStudentById(id);
    }

    public List<Student> listStudent() {
        // TODO Auto-generated method stub
        return studentDao.listStudent();
    }

    public void syncQizTable() {
        System.out.println("123");
    }
}
