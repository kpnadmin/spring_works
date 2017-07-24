package com.spring65.best;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring65.best.model.ModelPhone;
import com.spring65.best.service.IServicePhone;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ServicePhoneTest {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private static ApplicationContext context = null; 
    private static IServicePhone service  = null; 
    
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        context = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml");
        service = context.getBean("svrphone", IServicePhone.class);
    
    }
    
    @Test
    public void testGetPhoneOne() {
        String name = "sunny";
        ModelPhone result = service.getPhoneOne(name);
        assertEquals(result.getManufacturer(), "manufacturer");
        
    }
    
    @Test
    public void testGetPhoneList() {
       ModelPhone phone = new ModelPhone();
       List<ModelPhone> result = service.getPhoneList();
       assertSame(result.size(), 15);
       
    }
    
    @Test
    public void testInsertPhone() {
       ModelPhone phone = new ModelPhone("newPhone1", "newMenu1", 30000);
       int result = service.insertPhone(phone);
       
       assertSame(result, 1);
    }
    
    @Test
    public void testInserPhoneList() {
       ModelPhone phone = null;
       List<ModelPhone> list = new ArrayList<ModelPhone>();
       
       for(int i = 01; i< 6; i=i+1){
           phone = new ModelPhone();
           phone.setName("드래곤라자"+i);
           phone.setManufacturer("포션");
           phone.setPrice(10000);
           
           list.add(phone);
       }
       int result = service.inserPhoneList(list);
       
       assertSame(result, 5);
    }
    
    @Test
    public void testUpdatePhone() {
        ModelPhone searchValue = new ModelPhone();
        
        searchValue.setName("name1");
        searchValue.setManufacturer("manu1");
        searchValue.setPrice(2000);
        
        ModelPhone updateValue= new ModelPhone();
        updateValue.setName("자료실");
        updateValue.setManufacturer("20170720");
        updateValue.setPrice(0);
    
        
        int result = service.updatePhone(searchValue, updateValue);
        
        assertSame(result, 1);
    }
    
    @Test
    public void testDeletePhone() {
        ModelPhone phone = new ModelPhone("newPhone1", "newMenu1", 30000);
        int result = service.deletePhone(phone);
        
        assertSame(result, 1);
        
    }
}
