package com.spring63.test.dao;

import java.util.List;

import com.spring63.test.model.ModelPhone;

public interface IDaoPhone {
    
    ModelPhone getPhoneOne(String name);
    List<ModelPhone> getPhoneList();
    int insertPhone(ModelPhone phone);
    int insertPhoneList(List<ModelPhone> phones);
    int updatePhone(ModelPhone searchValue, ModelPhone updateValue);
    int deletePhone(ModelPhone phone);
}
