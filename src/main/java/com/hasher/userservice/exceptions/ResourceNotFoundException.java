package com.hasher.userservice.exceptions;

/**
 * Throws an exception when a requested resource is not found on the server.
 */
public class ResourceNotFoundException extends RuntimeException{

    /**
     * Constructs a new ResourceNotFoundException with a default message.
     */
    public ResourceNotFoundException(){
        super("Resource not found on server ");
    }

    /**
     * Constructs a new ResourceNotFoundException with a custom message.
     * @param msg the detailed message.
     */
    public ResourceNotFoundException(String msg){
        super(msg);
    }
}
