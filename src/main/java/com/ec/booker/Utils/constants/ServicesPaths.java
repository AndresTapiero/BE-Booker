package com.ec.booker.Utils.constants;

public enum ServicesPaths {
    LOGIN("/auth");

    private String path;

    ServicesPaths(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
