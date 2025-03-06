Feature: Validate /comments?postId={?} API

  @HappyTestScript
  Scenario: Validate successful response from /comments?postId=10 endpoint with a valid application context
    Given I send a request GET "DEFAULT_API_JSON_PLACEHOLDER_TYPE_CODE" to "/comments?postId=10"
    Then the response status should be 200

  @NegativeTestScript
  Scenario: Validate response from /comments?postId when the comment and postId attribute are misspelled
    Given I send a request GET "DEFAULT_API_JSON_PLACEHOLDER_TYPE_CODE" to "/commentss?postIdd=10"
    Then the response status should be 404

  @NegativeTestScript
  Scenario: Validate response from /comments?postId when the postId attribute is misspelled
    Given I send a request GET "DEFAULT_API_JSON_PLACEHOLDER_TYPE_CODE" to "/comments?postIdd=10"
    Then the response status should be 200

  @NegativeTestScript
  Scenario: Validate response from /comments?postId when the comment attribute is misspelled
    Given I send a request GET "DEFAULT_API_JSON_PLACEHOLDER_TYPE_CODE" to "/commentss?postId=10"
    Then the response status should be 404

  @NegativeTestScript
  Scenario: Validate response from /comments?postId with a wrong Id
    Given I send a request GET "DEFAULT_API_JSON_PLACEHOLDER_TYPE_CODE" to "/comments?postId=wrongId"
    Then the response status should be 200

  @NegativeTestScript
  Scenario: Validate response from /comments?postId for a non-existent postId query parameter value
    Given I send a request GET "DEFAULT_API_JSON_PLACEHOLDER_TYPE_CODE" to "/comments?postId=9181716227289876522"
    Then the response status should be 200

  @HappyTestScript
  Scenario: Validate json schema response from /comments?postId endpoint with a valid application context
    Given I send a request GET "DEFAULT_API_JSON_PLACEHOLDER_TYPE_CODE" to "/comments?postId=10"
    And the response status should be 200
    Then the response should match "comments-by-post-schema.json"
