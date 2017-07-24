package com.spring63.test.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModelPhone {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());

   private String name          ;      
   private String manufacturer  ;      
   private Integer price        ;
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
