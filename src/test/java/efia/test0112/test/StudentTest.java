package efia.test0112.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import efia.test0112.entity.Student;
import efia.test0112.service.StudentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:application-context.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void test01test() {
        System.out.println("test");
    }
    
//    @Test
//    public void test01addStudent() {
//        Student student = new Student("test", 18);
//        int row = studentService.addStudent(student);
//        System.out.println("row = " + row);
//    }
//
//    @Test
//    public void test02addStudents() {
//        Student student = new Student("john", 15);
//        int row = studentService.addStudent(student);
//        student = new Student("mary", 18);
//        row += studentService.addStudent(student);
//        student = new Student("tom", 17);
//        row += studentService.addStudent(student);
//        System.out.println("row = " + row);
//    }
//
//    @Test
//    public void test03deleteStudent() {
//        int id = 1;
//        int row = studentService.deleteStudent(id);
//        System.out.println("row = " + row);
//    }
//
//    @Test
//    public void test04updateStudent() {
//        int id = 1;
//        Student student = studentService.getStudentById(id);
//        student.setName("mary");
//        student.setAge(18);
//        int row = studentService.updateStudent(student);
//        System.out.println("row = " + row);
//    }
//
//    @Test
//    public void test05getStudentById() {
//        int id = 1;
//        Student student = studentService.getStudentById(id);
//        System.out.println(student);
//    }
//
//    @Test
//    public void test06listStudent() {
//        List<Student> students = studentService.listStudent();
//        for (Student student:students) {
//            System.out.println(student);
//        }
//    }

}
