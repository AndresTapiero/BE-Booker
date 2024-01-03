Feature: Create Booking

  @smoke @happy-path
  Scenario: Create a booking with valid details
    When a POST request is made to "/booking" with the JSON "/createNewBooking"
    Then the response status code should be 200
    And validate the response with a JSON Schema "createBooking"


  @smoke @happy-unhappy
  Scenario: Attempt to create a booking with invalid details
    When a POST request is made to "/booking" with the JSON "/createInvalidBooking"
    Then the response status code should be 500