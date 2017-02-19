package efia.test0112.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import efia.test0112.entity.Student;
import efia.test0112.service.StudentService;

@Controller
@RequestMapping("/TEST0112F1")
public class TEST0112F1Controller {

    @Autowired
    private StudentService studentService;
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private HistoryService historyService;
    @Autowired
    private ManagementService managementService;

    /**
     * 顯示目前學生數
     * 
     * @return
     */
    @RequestMapping("/list")
    public ModelAndView list() {
        ModelAndView mav = new ModelAndView();
        List<Student> studentList = studentService.listStudent();
        mav.addObject("studentList", studentList);
        mav.setViewName("TEST0112F1/list");
        return mav;
    }

    /**
     * 顯示輸入表單
     * 
     * @return
     */
    @RequestMapping("/showReqForm")
    public String index() {
        return "TEST0112F1/reqForm";
    }

    /**
     * 將表單資料加入資料庫
     * 
     * @param request
     * @return
     */
    @RequestMapping("/addReqForm")
    public String addReqForm(HttpServletRequest request) {
        String name = request.getParameter("name");
        Integer age = Integer.parseInt(request.getParameter("age"));
        Student student = new Student(name, age);
        studentService.addStudent(student);
        return "forward:/TEST0112F1/list.do";
    }

    /**
     * 部署
     * @param request
     * @return
     */
    @RequestMapping("/deploy")
    public String addReqForm() {
        Deployment deployment = repositoryService.createDeployment() // 創建部屬
                .addClasspathResource("diagrams/SPMProcess.bpmn") // 加載資源文件
                .addClasspathResource("diagrams/SPMProcess.png") // 加載資源文件
                .name("簡易進館系統流程").deploy(); // 部屬
        System.out.println("流程部屬ID:" + deployment.getId());
        System.out.println("流程部屬Name:" + deployment.getName());
        return "TEST0112F1/deploy";
    }
    
    /**
     * 啟動流程
     * @param request
     * @return
     */
    @RequestMapping("/startProcess")
    public String startProcess(@RequestParam("id") int id) {
        Student student = studentService.getStudentById(id);
        String key = student.getClass().getSimpleName();
        Map<String,Object> variables = new HashMap<String,Object>();
        variables.put("userId", student.getName());
        String objId = key + "." + id;
        System.out.println(student.getName());
        runtimeService.startProcessInstanceByKey(key,objId,variables);
        //runtimeService.startProcessInstanceByKey(key,variables);
        return "TEST0112F1/deploy";
    }
}
