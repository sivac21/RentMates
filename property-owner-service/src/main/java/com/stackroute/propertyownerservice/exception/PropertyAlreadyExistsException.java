package com.stackroute.propertyownerservice.exception;
/**
 * @Author Rohit
 * @Date 11/18/2021 2:26 PM
 */
public class PropertyAlreadyExistsException extends Exception{

    String message;
    public PropertyAlreadyExistsException(){ }

    public PropertyAlreadyExistsException(String message){
        super(message);
        this.message = message;
    }
}
