package com.stackroute.tenantprofileservice.exception;

/**
 * @Author Siva
 * @Date 12/11/2021 12:36 PM
 */
public class TenantGroupNotFoundException extends Exception{
    String message;

    public TenantGroupNotFoundException(){ }

    public TenantGroupNotFoundException(String message){
        super(message);
        this.message = message;
    }
}
