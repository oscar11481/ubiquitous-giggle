package efia.test0112.web.form;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserForm {
    
    private String userName;
    
    @JsonIgnore
    private boolean admin;
    @JsonIgnore
    private String email = "daiuan@gmail.com";
    
    public UserForm() {
        super();
    }
    
    public UserForm(String userName) {
        super();
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
