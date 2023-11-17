package com.ec.booker.utils.constants;

public enum Constants {

    BASE_URI("https://restful-booker.herokuapp.com"),
    AUTHORIZATION("Authorization"),

    TOKEN("token"),
    FIRST_NAME("firstname"),
    COOKIE("Cookie"),
    AUTHORIZATION_VALUE("Basic YWRtaW46cGFzc3dvcmQxMjM="),
    BOOKING_ID("bookingid"),
    CREATED("Created");

    private String value;

    Constants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
