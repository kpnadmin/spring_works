package com.spring64.rest.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring64.rest.dao.IDaoPerson;
import com.spring64.rest.model.ModelPerson;

@Service("servicePerson")
public class ServicePerson implements IServicePerson {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    @Qualifier("daoPerson")
    IDaoPerson dao;
    
    @Override
    public int Login(ModelPerson person) {
        int result = -1;
        try {
            result = dao.Login(person);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("Login" + e.getMessage());
            throw e;
        }
        return result;
    }
    
    @Override
    public List<ModelPerson> getPersonList(ModelPerson person) {
        List<ModelPerson> result = null;
        
        try {
            result = dao.getPersonList(person);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("getPersonList" + e.getMessage() );
            throw e;
        }
        
        
        return result;
    }
    
    @Override
    public int insertPerson(ModelPerson person) {
        int result = -1; 
        
        try {
            result = dao.insertPerson(person);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("insertPerson" + e.getMessage() );
            throw e;
        }
        
        
        return result;
    }
}