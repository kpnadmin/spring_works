package com.spring63.test.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

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

import com.spring63.test.model.ModelPhone;

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
        assertSame(result.size(), 1);
    }
    
    @Test
    public void testInsertPhone() {
        ModelPhone phone = new ModelPhone("name1", "manu1", 2000);
        
        int result = service.insertPhone(phone);
        
        assertSame(1, result);
    }
    
    @Test
    public void testInsertPhoneList() {
        ModelPhone phone = null;
        List<ModelPhone> list= new ArrayList<ModelPhone>();           
        
        for(int i=1; i<6; i=i+1){           
           phone= new ModelPhone();          
           phone.setName("퇴마록"+ i);
           phone.setManufacturer("엘릭시르");
           phone.setPrice(20000);           
           list.add(phone);            
        }
      
        int result= service.insertPhoneList(list);
        
        assertSame(result, 5);
    }
    
    @Test
    public void testUpdatePhone() {
  ModelPhone searchValue = new ModelPhone();
        
        searchValue.setName("asdasd");
        searchValue.setManufacturer("asdsad");
        searchValue.setPrice(12300);
        
        ModelPhone updateValue= new ModelPhone();
        updateValue.setName("자료실");
        updateValue.setManufacturer("20170720");
        updateValue.setPrice(0);
    
        
        int result = service.updatePhone(searchValue, updateValue);
        
        if(result>=0){
            assertTrue(true);
        }else{
            assertTrue(false);
        }
    }
    
    @Test
    public void testDeletePhone() {
 ModelPhone phone = new ModelPhone();
        
        phone.setName("11");
        phone.setManufacturer("11");
        //phone.setPrice(11);
        
        
        int result = service.deletePhone(phone);
        
        if(result>=0){
            assertTrue(true);
        }else{
            assertTrue(false);
        }
    }
}
