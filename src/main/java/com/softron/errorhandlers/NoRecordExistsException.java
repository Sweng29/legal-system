package com.softron.errorhandlers;

public class NoRecordExistsException extends RuntimeException {

    private static final long serialVersionUID = 8731677663644923677L;

    public NoRecordExistsException(String message) {
        super(message);
    }

}
