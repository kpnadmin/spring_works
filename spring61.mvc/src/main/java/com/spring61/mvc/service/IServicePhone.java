package com.spring61.mvc.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spring61.mvc.model.ModelPhone;

public interface IServicePhone {
    
    ModelPhone getPhoneOne(String name);
    List<ModelPhone> getPhoneList();
    int insertPhone(ModelPhone phone);
    int insertPhoneList(List<ModelPhone> phones);
    
    
}
