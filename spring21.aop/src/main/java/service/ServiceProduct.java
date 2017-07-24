package service;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import dao.IDaoProduct;
import model.ModelProduct;


@Service("serviceProduct")
public class ServiceProduct implements IServiceProduct {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    @Qualifier("productDao")
    private IDaoProduct productDao;
    public IDaoProduct getProductDao() {return productDao;}
    public void setProductDao(IDaoProduct productDao) {this.productDao = productDao;}
    
    
    @Override
    public ModelProduct getProduct(String name) {
       ModelProduct product = productDao.getProduct("빵");
        return product;
    }
    
    @Override
    public ModelProduct getException(String name) throws Exception {
    /*   try {
        productDao.getException("빵");
    } catch (Throwable e) {
        logger.error("getException" + e.getMessage() );
        throw e;
    }*/
        ModelProduct result = productDao.getException("빵");
       
        return result;
    }
    
    @Override
    public void getNone() {
            productDao.getProduct("빵");
            return ;
        
    }
}
