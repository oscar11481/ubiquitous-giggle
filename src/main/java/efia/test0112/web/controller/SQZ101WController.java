package efia.test0112.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import efia.test0112.web.form.UserForm;

@Controller
@RequestMapping("/TEST0112F2")
public class SQZ101WController {
    
    @RequestMapping("/home")
    public String index() {
        return "SQZ100/SQZ101W";
    }
    
    @RequestMapping("/ajax")
    public @ResponseBody UserForm ajax(HttpServletRequest request){
        UserForm user = new UserForm("neo");
        return user;
    }
    
    @RequestMapping("/ajax2")
    public @ResponseBody Map<String, Object> ajax2(HttpServletRequest request){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userName", "neo");
        map.put("password", "neo1234");
        return map;
    }
    
    @RequestMapping("/ajax3")
    public @ResponseBody List<UserForm> ajax3(HttpServletRequest request){
        List<UserForm> users = new ArrayList<UserForm>();
        users.add(new UserForm("john"));
        users.add(new UserForm("marry"));
        return users;
    }
    
}
