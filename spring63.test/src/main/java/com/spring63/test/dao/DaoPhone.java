package com.spring63.test.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.spring63.test.model.ModelPhone;

@Repository("daoPhone")
public class DaoPhone implements IDaoPhone {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    @Qualifier("sqlSession")
    private SqlSession session;
    
    
    @Override
    public ModelPhone getPhoneOne(String name) {
       
        return session.selectOne("mapper.mysql.mapperPhone.getPhoneOne",name);
        
    }
    
    @Override
    public List<ModelPhone> getPhoneList() {
       
        return session.selectList("mapper.mysql.mapperPhone.getPhoneList");
        
    }
    
    @Override
    public int insertPhone(ModelPhone phone) {
       
        return session.insert("mapper.mysql.mapperPhone.insertPhone",phone);
        
    }
    
    @Override
    public int insertPhoneList(List<ModelPhone> phones) {
       
        return session.insert("mapper.mysql.mapperPhone.insertPhoneList",phones);
        
    }
    
    @Override
    public int updatePhone(ModelPhone searchValue, ModelPhone updateValue) {
        Map<String, ModelPhone> map = new HashMap<String, ModelPhone>();
        map.put("searchValue", searchValue);
        map.put("updateValue", updateValue);
        return session.update("mapper.mysql.mapperPhone.updatePhone",map);
        
    }
    
    @Override
    public int deletePhone(ModelPhone phone) {
       
        return session.delete("mapper.mysql.mapperPhone.deletePhone",phone);
        
    }
}
