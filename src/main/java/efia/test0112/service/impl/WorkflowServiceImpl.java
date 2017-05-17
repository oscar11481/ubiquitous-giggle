package efia.test0112.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import efia.test0112.entity.Student;
import efia.test0112.service.StudentService;
import efia.test0112.service.WorkflowService;

@Service("WorkflowService")
public class WorkflowServiceImpl implements WorkflowService,JavaDelegate {

    @Autowired
    private StudentService studentService;
    // Activiti服務
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
    @Autowired
    private IdentityService identityService;
    @Autowired
    private FormService formService;

    public void startProcess() {
        String key = "SPMProcess";
        Map<String,Object> variables = new HashMap<String,Object>();
        variables.put("userId", "測試");
        runtimeService.startProcessInstanceByKey(key,variables);
    }
    
    public void execute(DelegateExecution execution) throws Exception {
        Student student = new Student("execution", 1);
        int row = studentService.addStudent(student);
        System.out.println("row = " + row);      
    }



}
