package efia.test0112.test;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
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
import org.activiti.engine.history.HistoricProcessInstance;
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
import org.springframework.web.util.HtmlUtils;

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
    public void test01() {
        System.out.println("test");
    }
    /**
     * 創建表測試
     */
    @Test
    public void test02CreateTable() {
        // 獲取流程引擎配置
        ProcessEngineConfiguration pec = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
        pec.setJdbcDriver("org.mariadb.jdbc.Driver");
        pec.setJdbcUrl("jdbc:mariadb://localhost:3306/db_demo0112");
        pec.setJdbcUsername("root");
        pec.setJdbcPassword("admin1234");
        /**
         * 配置模式 true 自動創建和更新表
         */
        pec.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        // 獲取流程引擎對象
        ProcessEngine pe = pec.buildProcessEngine();
    }

    /**
     * 部署測試
     */
    @Test
    public void test01deployTest() {
        Deployment deployment = repositoryService.createDeployment() // 創建部屬
                .addClasspathResource("diagrams/SPMProcess.bpmn") // 加載資源文件
                .addClasspathResource("diagrams/SPMProcess.png") // 加載資源文件
                .name("簡易進館系統流程").deploy(); // 部署
        System.out.println("流程部屬ID:" + deployment.getId());
        System.out.println("流程部屬Name:" + deployment.getName());
    }

    /**
     * 啟動任務
     */
    @Test
    public void test02startProcess(){
        String key = "SPMProcess";
        Map<String,Object> variables = new HashMap<String,Object>();
        variables.put("userId", "測試");
        ProcessInstance pi = runtimeService.startProcessInstanceByKey(key,variables);
        System.out.println("流程實例ID:" + pi.getId());
        System.out.println("流程定義ID:" + pi.getProcessDefinitionId());
    }
    
    /**
     * 完成任務
     */
    @Test
    public void test02completeTask01() {
        List<Task> taskList = taskService // 任务相关Service
                .createTaskQuery()// 创建任务查询
                .taskAssignee("系統負責人") // 指定某个人
                .list();
        for (Task task : taskList) {
            taskService.complete(task.getId());
        }
    }

    /**
     * 完成任務
     */
    @Test
    public void test02completeTask02() {
        List<Task> taskList = taskService // 任务相关Service
                .createTaskQuery()// 创建任务查询
                .taskAssignee("程式品管人員") // 指定某个人
                .list();
        for (Task task : taskList) {
            taskService.complete(task.getId());
        }
    }
    
    /**
     * 查找任務測試
     */
    @Test
    public void test03findTask() {
        List<Task> taskList = taskService // 任务相关Service
                .createTaskQuery()// 创建任务查询
                .taskAssignee("程式品管人員") // 指定某个人
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
    }
    
    /**
     * 完成任務測試
     */
    @Test
    public void test04completeTask() {
        taskService.complete("35002");
    }

    @Test
    public void test05deleteProcessInstance() {
        String taskId = "47501";
        Task task = taskService
        .createTaskQuery()
        .taskId(taskId)
        .singleResult();
        //要改成用reqCd找，因為可能流程在system task，沒有taskId。
        String processInstanceId = task.getProcessInstanceId();       
        runtimeService.deleteProcessInstance(processInstanceId, null);
        //要連帶一起刪，不然下次找不到processInstanceId
        HistoricProcessInstance historicProcessInstance = historyService.createHistoricProcessInstanceQuery()
                .processInstanceId(processInstanceId).singleResult();
        if (historicProcessInstance != null) {
            historyService.deleteHistoricProcessInstance(historicProcessInstance.getId());
        }      
    }
    
    @Test
    public void test06base64() {
        final Base64.Decoder decoder = Base64.getDecoder();  
        final Base64.Encoder encoder = Base64.getEncoder();  
        final String text = "字串文字";  
        byte[] textByte;
        try {
            textByte = text.getBytes("UTF-8");
          //編碼  
            final String encodedText = encoder.encodeToString(textByte);  
            System.out.println(encodedText);  
            //解碼  
            System.out.println(new String(decoder.decode(encodedText), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }          
    }
    
    @Test
    public void test07escapehtml() {
        System.out.println(escapehtml("中文<>.txt"));
    }
    public String Encoder(String input){
        //要考慮副檔名
        return input;
    }
    
    public String Decoder(String input){
        
        return input;
    }
    
    private String escapehtml(String filepath){
        String str_out="";
        if(filepath!=null){ 
            str_out = "";
            char[] chars = filepath.toCharArray();
            int length = chars.length;
            HashMap<String,String> map = new HashMap<String,String>();
            map.put("a", "a");
            map.put("b", "b");
            map.put("c", "c");
            map.put("d", "d");
            map.put("e", "e");
            map.put("f", "f");
            map.put("g", "g");
            map.put("h", "h");
            map.put("i", "i");
            map.put("j", "j");
            map.put("k", "k");
            map.put("l", "l");
            map.put("m", "m");
            map.put("n", "n");
            map.put("o", "o");
            map.put("p", "p");
            map.put("q", "q");
            map.put("r", "r");
            map.put("s", "s");
            map.put("t", "t");
            map.put("u", "u");
            map.put("v", "v");
            map.put("w", "w");
            map.put("x", "x");
            map.put("y", "y");
            map.put("z", "z");
            
            
            map.put("A", "A");
            map.put("B", "B");
            map.put("C", "C");
            map.put("D", "D");
            map.put("E", "E");
            map.put("F", "F");
            map.put("G", "G");
            map.put("H", "H");
            map.put("I", "I");
            map.put("J", "J");
            map.put("K", "K");
            map.put("L", "L");
            map.put("M", "M");
            map.put("N", "N");
            map.put("O", "O");
            map.put("P", "P");
            map.put("Q", "Q");
            map.put("R", "R");
            map.put("S", "S");
            map.put("T", "T");
            map.put("U", "U");
            map.put("V", "V");
            map.put("W", "W");
            map.put("X", "X");
            map.put("Y", "Y");
            map.put("Z", "Z");
            map.put(":",":");
            map.put(".",".");
            map.put("/","/");
            map.put("\\","\\");
            map.put("0","0");
            map.put("1","1");
            map.put("2","2");
            map.put("3","3");
            map.put("4","4");
            map.put("5","5");
            map.put("6","6");
            map.put("7","7");
            map.put("8","8");
            map.put("9","9");
            for(int i=0;i<length;i++){
                if(map.get(String.valueOf(chars[i]))!=null){
                    str_out+=map.get(String.valueOf(chars[i]));
                }
            }
        }
        if(filepath.length()>0){
            str_out = HtmlUtils.htmlEscape(filepath);
            //filepath = StringEscapeUtils.escapeXml(filepath);
        }
        return str_out;
    }
}
