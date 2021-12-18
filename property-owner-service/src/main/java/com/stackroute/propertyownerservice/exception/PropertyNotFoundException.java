package com.stackroute.propertyownerservice.exception;
/**
 * @Author Rohit
 * @Date 11/18/2021 2:26 PM
 */
public class PropertyNotFoundException extends Exception{

    String message;

    public PropertyNotFoundException(){ }

    public PropertyNotFoundException(String message){
        super(message);
        this.message = message;
    }
}
