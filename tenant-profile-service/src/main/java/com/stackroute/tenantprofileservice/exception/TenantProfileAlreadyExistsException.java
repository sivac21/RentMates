package com.stackroute.tenantprofileservice.exception;

/**
 * @Author Siva
 * @Date 11/18/2021 2:24 PM
 */
public class TenantProfileAlreadyExistsException extends Exception{
    String message;
    public TenantProfileAlreadyExistsException(){ }

    public TenantProfileAlreadyExistsException(String message){
        super(message);
        this.message = message;
    }
}
