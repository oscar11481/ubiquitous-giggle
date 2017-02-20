package efia.test0112.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import efia.test0112.service.StudentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:application-context.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeployTest {

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

    
    @Test
    public void test(){
        System.out.println("Hello");
    }
    /**
     * 創建表測試
     */
/*    @Test
    public void test01CreateTable() {
        // 獲取流程引擎配置
        ProcessEngineConfiguration pec = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
        pec.setJdbcDriver("org.mariadb.jdbc.Driver");
        pec.setJdbcUrl("jdbc:mariadb://localhost:3306/db_demo0112");
        pec.setJdbcUsername("root");
        pec.setJdbcPassword("admin1234");
        *//**
         * 配置模式 true 自動創建和更新表
         *//*
        pec.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        // 獲取流程引擎對象
        ProcessEngine pe = pec.buildProcessEngine();
    }*/

    /**
     * 部署測試
     */
/*    @Test
    public void test01deployTest() {
        Deployment deployment = repositoryService.createDeployment() // 創建部屬
                .addClasspathResource("diagrams/SPMProcess.bpmn") // 加載資源文件
                .addClasspathResource("diagrams/SPMProcess.png") // 加載資源文件
                .name("簡易進館系統流程").deploy(); // 部屬
        System.out.println("流程部屬ID:" + deployment.getId());
        System.out.println("流程部屬Name:" + deployment.getName());
    }*/

    /**
     * 啟動任務
     */
/*    @Test
    public void test02startProcess(){
        String key = "Student";
        Map<String,Object> variables = new HashMap<String,Object>();
        variables.put("userId", "測試");
        ProcessInstance pi = runtimeService.startProcessInstanceByKey(key,variables);
        System.out.println("流程實例ID:" + pi.getId());
        System.out.println("流程定義ID:" + pi.getProcessDefinitionId());
    }*/
    
    /**
     * 查找任務測試
     */
/*    @Test
    public void test02findTask() {

        List<Task> taskList = taskService // 任务相关Service
                .createTaskQuery()// 创建任务查询
                .taskAssignee("王五") // 指定某个人
                .list();
        for (Task task : taskList) {
            String executionId = task.getExecutionId();
            String instanceId = task.getProcessInstanceId();
            ProcessInstance pi = runtimeService.createProcessInstanceQuery().processInstanceId(instanceId)
                    .singleResult();
            Map<String, Object> variables = pi.getProcessVariables();
            System.out.println("inputUser=" + variables.get("inputUser"));
            System.out.println("任务ID:" + task.getId());
            System.out.println("任务名称:" + task.getName());
            System.out.println("任务创建时间:" + task.getCreateTime());
            System.out.println("任务委派人:" + task.getAssignee());
            System.out.println("流程实例ID:" + task.getProcessInstanceId());
        }
    }*/

    /**
     * 完成任務測試
     */
/*    @Test
    public void test03completeTask() {
        taskService.complete("27509");
    }*/

}
