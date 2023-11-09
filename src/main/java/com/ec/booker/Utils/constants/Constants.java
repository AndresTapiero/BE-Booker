package com.ec.booker.Utils.constants;

public enum Constants {

    BASE_URI("https://restful-booker.herokuapp.com");

    private String value;

    Constants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
