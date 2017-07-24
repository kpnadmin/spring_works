package com.spring61.mvc.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModelLogin {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    private String name; 
    private String phone ;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
    public ModelLogin() {
        super();
    } 
    
    
    
    
}
