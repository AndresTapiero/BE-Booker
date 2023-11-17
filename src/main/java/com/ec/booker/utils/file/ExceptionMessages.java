package com.ec.booker.utils.file;

public enum ExceptionMessages {
    ERROR_READING_JSON_FILE("Error al leer archivo Json ");

    private String message;

    ExceptionMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
