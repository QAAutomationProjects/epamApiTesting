Feature: Validate JSONPlaceholder API

  @HappyTestScript
  Scenario: Validate successful response from /posts endpoint with a valid application context
    Given I send a request GET "DEFAULT_API_JSON_PLACEHOLDER_TYPE_CODE" to "/posts"
    Then the response status should be 200

  @HappyTestScript
  Scenario: Validate json schema response from /posts endpoint with a valid application context
    Given I send a request GET "DEFAULT_API_JSON_PLACEHOLDER_TYPE_CODE" to "/posts"
    And the response status should be 200
    Then the response should match "post-schema.json"

  @NegativeTestScript
  Scenario: Validate error response for an invalid endpoint request
    Given I send a request GET "DEFAULT_API_JSON_PLACEHOLDER_TYPE_CODE" to "/invalid-endpoint"
    Then the response status should be 404