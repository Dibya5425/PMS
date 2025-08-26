package com.pm.patientservice.exception;

public class PatirentNotFoundException extends RuntimeException {
    public PatirentNotFoundException(String message) {
        super(message);
    }
}
