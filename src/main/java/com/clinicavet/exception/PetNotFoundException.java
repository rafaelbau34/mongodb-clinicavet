package com.clinicavet.exception;

public class PetNotFoundException extends RuntimeException {
    public PetNotFoundException(String id) {
        super("No se encontró la mascota con ID: " + id);
    }
}
