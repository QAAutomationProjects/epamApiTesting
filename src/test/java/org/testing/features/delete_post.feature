Feature: Validate Delete API

  @HappyTestScriptTestScript
  Scenario: Successfully delete a post by ID
    Given I send a request DELETE "DEFAULT_API_JSON_PLACEHOLDER_TYPE_CODE" to "/posts/9"
    Then the DELETE response status should be 200
    And the DELETE response body should be empty

  @NegativeTestScript
  Scenario: Attempt to delete a post with an invalid ID
    Given I send a request DELETE "DEFAULT_API_JSON_PLACEHOLDER_TYPE_CODE" to "/posts/wrongValue"
    Then the DELETE response status should be 200
    And the DELETE response body should be empty