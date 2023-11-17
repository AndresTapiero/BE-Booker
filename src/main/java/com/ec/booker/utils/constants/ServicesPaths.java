package com.ec.booker.utils.constants;

public enum ServicesPaths {
    LOGIN("/auth"),
    BOOKING("/booking"),
    PING("/ping");

    private String path;

    ServicesPaths(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
