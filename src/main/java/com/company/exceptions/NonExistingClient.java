package com.company.exceptions;

public class NonExistingClient extends Exception {
    public NonExistingClient(String message) {
        super(message);
    }
}
