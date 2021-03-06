package com.spring62.phone.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




public class ModelPhone {
    private String name; 
    private String manufacturer;
    private Integer price; 

    
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getManufacturer() {
        return manufacturer;
    }


    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }


    public Integer getPrice() {
        return price;
    }


    public void setPrice(Integer price) {
        this.price = price;
    }


    public ModelPhone() {
        super();
    }


    public ModelPhone(String name, String manufacturer, Integer price) {
        super();
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
    }


    @Override
    public String toString() {
        return "ModelPhone [name=" + name + ", manufacturer=" + manufacturer
                + ", price=" + price + "]";
    }

        
    

}
