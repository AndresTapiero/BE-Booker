Feature: Ping Health Check Validation

  @smoke @happy-path
  Scenario: Ping check validation
    Given do a request to the endpoint "/ping"
    Then the response status code should be 201
    And the response text is "Created"