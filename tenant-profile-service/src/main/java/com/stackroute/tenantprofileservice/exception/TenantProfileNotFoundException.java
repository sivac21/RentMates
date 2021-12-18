package com.stackroute.tenantprofileservice.exception;

/**
 * @Author Siva
 * @Date 11/18/2021 2:25 PM
 */
public class TenantProfileNotFoundException extends Exception {
    String message;

    public TenantProfileNotFoundException(){ }

    public TenantProfileNotFoundException(String message){
        super(message);
        this.message = message;
    }
}
