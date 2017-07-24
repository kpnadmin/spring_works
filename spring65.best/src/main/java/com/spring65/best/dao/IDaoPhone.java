package com.spring65.best.dao;

import java.util.List;

import com.spring65.best.model.ModelPhone;

public interface IDaoPhone {
    
    ModelPhone getPhoneOne(String name);
    List<ModelPhone> getPhoneList();
    int insertPhone(ModelPhone phone);
    int inserPhoneList(List<ModelPhone> phones);
    int updatePhone(ModelPhone searchValue, ModelPhone updateValue);
    int deletePhone(ModelPhone phone);
    
    
    
}
