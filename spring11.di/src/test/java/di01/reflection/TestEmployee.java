package di01.reflection;

import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import di00.model.Employee;

public class TestEmployee {
    // SLF4J Logging

    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }
    
    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void testMakeInstanceWithNew() {
       Employee emp1 = new Employee();
       
       emp1.setFirstname("aaa");
       emp1.setLastname("bbb");
       emp1.setSalary(6000);
       assertEquals(emp1.getFirstname(), "aaa");
       
       Employee emp2 = new Employee("aaaa","bbbb", 1000);
       assertEquals(emp2.getLastname(), "bbbb");
      
    }
    
    @Test
    public void testMakeInstanceWithReflection() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
       
        // Employee emp2 = new Employee("aaaa","bbbb", 100)
        
        Class klass = Class.forName("di00.model.Employee");
        Class[] paramTypes = {String.class, String.class, Integer.TYPE};
        
        
        Constructor cons = klass.getConstructor(paramTypes);
        
        Object [] objs = {"aaaa", "bbbb", 100};
        // 인스턴스 만들기 
        Object instance = cons.newInstance(objs);
        System.out.println(instance.toString());
        
        
        // setter을 이용한 값 바꾸기 
        // 메서드 지정
        Method m = klass.getMethod("setFirstname", String.class);
        // 메서드 호출
        Object [] params = {"hello"};
        m.invoke(instance, params);
        // 인스턴스의 값 출력 
       System.out.println(instance.toString());
       
       // getter 을 이용해 필드값 가져오기 
       m = klass.getMethod("getFirstname");
       Object result = m.invoke(instance);
       // 인스턴스의 값 출력 
       System.out.println(result);
       
       assertEquals("hello", result);
        
    }
    
    
}
