package spring21.aop;

import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.ModelProduct;
import service.IServiceProduct;

public class TestFirstAspect {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private static ApplicationContext  context = null;
    private static IServiceProduct service = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {  
       
        try {
            context = new ClassPathXmlApplicationContext("classpath:aop.xml");
      //@Service 의 이름을 ""에 추가 
      service = context.getBean("serviceProduct", IServiceProduct.class);
        } catch (Exception e) {
            // TODO Auto-generated catch block
             e.printStackTrace();
           // logger.error("setUpBeforeClass" + e.getMessage() );
           // throw e;
        }
    }
    
    @Test
    public void testGetProduct() {
       logger.debug("Using Spring AOP:");
       ModelProduct product = null ; 
       try {
        product = service.getProduct("");
    } catch (Exception e) {
        logger.error("testGetProduct" + e.getMessage() );
        // TODO Auto-generated catch block
        e.printStackTrace();
        //throw e;
    }
       logger.info(product.toString());
       logger.debug("It should be now cached!");
      /*  
        fail("Not yet implemented");
        */
    }
    
    @Test
    public void testGetException() {
      logger.debug("Using Spring AOP:");
      try {
        service.getException("");
    } catch (Exception e) {
        // TODO Auto-generated catch block
        // e.printStackTrace();
        logger.error("testGetException" + e.getMessage() );
        
    }
      logger.debug("It should be now cached!");
    }
    
    @Test
    public void testGetNone() {
      logger.debug("Using Spring AOP:");
      service.getNone();
      logger.debug("It should be now cached!");
      
    }
}
