package com.bolsadeideas.springboot.error.app.errors;


public class DataNotFoundException extends RuntimeException{

    public DataNotFoundException(String idData) {
        super("Data with ID: ".concat(idData).concat(" not exists"));
    }
}
