package com.stackroute.tenantmatchmakingservice.exception;

/**
 * @Author Rohit
 * @Date 07-Dec-21 8:20 AM
 */
public class TenantProfileAlreadyExistsException extends Exception{
    String message;
    public TenantProfileAlreadyExistsException(){ }

    public TenantProfileAlreadyExistsException(String message){
        super(message);
        this.message = message;
    }
}
