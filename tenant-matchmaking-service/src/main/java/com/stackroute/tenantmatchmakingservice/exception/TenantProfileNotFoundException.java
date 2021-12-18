package com.stackroute.tenantmatchmakingservice.exception;

/**
 * @Author Rohit
 * @Date 07-Dec-21 8:20 AM
 */
public class TenantProfileNotFoundException extends Exception{
    String message;

    public TenantProfileNotFoundException(){ }

    public TenantProfileNotFoundException(String message){
        super(message);
        this.message = message;
    }
}
