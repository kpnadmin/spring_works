package com.spring64.rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring64.rest.model.ModelPerson;
import com.spring64.rest.service.IServicePerson;

public class TestServicePerson {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    private static ApplicationContext context = null; 
    private static IServicePerson service  = null; 
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
  
        context = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml");
        service = context.getBean("servicePerson", IServicePerson.class);
        
    }
    
    @Test
    public void testLogin() {
        ModelPerson person = new ModelPerson("test1id", "test1pw");
        int result = service.Login(person);
        assertEquals(1, result);
        
        person = new ModelPerson("test2id", "test2pw");
        result = service.Login(person);
        assertEquals(0, result);
        
    }
    
    @Test
    public void testGetPersonList() {
       
        ModelPerson person = new ModelPerson();
        List<ModelPerson> result = service.getPersonList(person);
        assertNotNull(result);
        assertNotEquals(0, result.size());
    }
    
    @Test
    public void testInsertPerson() {
        ModelPerson person = new ModelPerson("test1id", "test1pw", "test1name", "test1email");
        int result = service.insertPerson(person);
        assertEquals(1, result);
    }
    @Test
    public void testInsertPersonList() {
        List<ModelPerson> persons = new ArrayList<ModelPerson>();
       //String t = new Date();
        String t = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
        persons.add(new ModelPerson("t1id"+t, "t1pw", "t1name", "t1email"));
        persons.add(new ModelPerson("t2id"+t, "t2pw", "t2name", "t2email"));
       
        int result = service.insertPersonList(persons);
        assertEquals(2, result);
    }
    
    
}
