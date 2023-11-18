package com.ec.booker.utils.constants;

public enum Constants {

    BASE_URI("https://restful-booker.herokuapp.com"),
    AUTHORIZATION("Authorization"),

    TOKEN("token"),
    TOKEN_EQUAL("token="),
    FIRST_NAME("firstname"),
    LAST_NAME("lastname"),
    TOTAL_PRICE("totalprice"),
    ADDITIONAL_NEEDS("additionalneeds"),
    COOKIE("Cookie"),
    BOOKING_ID("bookingid");

    private String value;

    Constants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
