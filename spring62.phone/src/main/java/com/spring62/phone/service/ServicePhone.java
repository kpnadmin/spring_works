package com.spring62.phone.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring62.phone.dao.IDaoPhone;
import com.spring62.phone.model.ModelPhone;


@Service("svrphone")
public class ServicePhone implements IServicePhone {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    @Qualifier("daoPhone")
    IDaoPhone dao;
    
    
    @Override
    public ModelPhone getPhoneOne(String name) {
       ModelPhone result = null; 
       
       try {
        result = dao.getPhoneOne(name);
    } catch (Exception e) {
        // TODO Auto-generated catch block
        // e.printStackTrace();
        logger.error("getPhoneOne" + e.getMessage() );
        throw e;
    }
        
        
        return result;
    }
    
    @Override
    public List<ModelPhone> getPhoneList() {
       List<ModelPhone> result = null; 
       
       try {
        result = dao.getPhoneList();
    } catch (Exception e) {
        // TODO Auto-generated catch block
        // e.printStackTrace();
        logger.error("getPhoneList" + e.getMessage() );
        throw e;
    }
        
        
        return result;
    }
    
    @Override
    public int insertPhone(ModelPhone phone) {
       int result = -1; 
       
       try {
        result = dao.insertPhone(phone);
    } catch (Exception e) {
        // TODO Auto-generated catch block
        // e.printStackTrace();
        logger.error("insertPhone" + e.getMessage() );
        throw e;
    }
        
        return result;
    }
    
    @Override
    public int insertPhoneList(List<ModelPhone> phones) {
       int result = -1; 
       
       try {
        result = dao.insertPhoneList(phones);
    } catch (Exception e) {
        // TODO Auto-generated catch block
        // e.printStackTrace();
        logger.error("insertPhoneList" + e.getMessage() );
        throw e;
    }
       
        return result;
    }

    @Override
    public int updatePhone(ModelPhone updateValue, ModelPhone searchValue) {
        int result = -1 ;

        try {
            result = dao.updatePhone(searchValue, updateValue);
        } catch (Exception e) {
            logger.error("updatePhone"+e.getMessage());

        }

        return result;
    }

    @Override
    public int deletePhone(ModelPhone phone) {
        int result = -1 ;

        try {
            result = dao.deletePhone(phone);
        } catch (Exception e) {
            logger.error("deletePhone"+e.getMessage());

        }

        return result;
    }

}
