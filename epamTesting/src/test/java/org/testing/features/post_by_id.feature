Feature: Validate JSONPlaceholder API

  @HappyTestScript
  Scenario: Validate successful response from /posts/{id} endpoint with a valid parameter
    Given I send a request GET "DEFAULT_API_JSON_PLACEHOLDER_TYPE_CODE" to "/posts/10"
    Then the response status should be 200

  @NegativeTestScript
  Scenario: Validate successful response from /posts/{id} endpoint with a wrong parameter
    Given I send a request GET "DEFAULT_API_JSON_PLACEHOLDER_TYPE_CODE" to "/posts/wrongParameter"
    Then the response status should be 404

  @NegativeTestScript
  Scenario: Scenario: Validate error response for /posts/{id} with a non-existent ID
    Given I send a request GET "DEFAULT_API_JSON_PLACEHOLDER_TYPE_CODE" to "/posts/32008799999999999"
    Then the response status should be 404
