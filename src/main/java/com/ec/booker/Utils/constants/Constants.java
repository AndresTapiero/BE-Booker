package com.ec.booker.Utils.constants;

public enum Constants {

    BASE_URI("https://restful-booker.herokuapp.com"),
    AUTHORIZATION("Authorization"),
    AUTHORIZATION_VALUE("Basic YWRtaW46cGFzc3dvcmQxMjM="),
    CREATED("Created");

    private String value;

    Constants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
