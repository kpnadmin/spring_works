package com.spring64.rest.dao;

import java.util.List;

import com.spring64.rest.model.ModelPerson;

public interface IDaoPerson {
    
    int Login(ModelPerson person);
    List<ModelPerson> getPersonList(ModelPerson person);
    int insertPerson(ModelPerson person);
    
    
}
