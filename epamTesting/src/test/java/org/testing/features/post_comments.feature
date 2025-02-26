Feature: Validate /posts/{id}/comments API

  @HappyTestScript
  Scenario: Validate successful response from /posts/{id}/comments endpoint with a valid application context
    Given I send a request GET "DEFAULT_API_JSON_PLACEHOLDER_TYPE_CODE" to "/posts/10/comments"
    Then the response status should be 200

  @NegativeTestScript
  Scenario: Validate response from /posts/{id}/comments when the posts and comments attribute are misspelled
    Given I send a request GET "DEFAULT_API_JSON_PLACEHOLDER_TYPE_CODE" to "/postss/10/commentss"
    Then the response status should be 404

  @NegativeTestScript
  Scenario: Validate response from /posts/{id}/comments when the comment attribute is misspelled
    Given I send a request GET "DEFAULT_API_JSON_PLACEHOLDER_TYPE_CODE" to "/posts/10/commentss"
    Then the response status should be 404

  @NegativeTestScript
  Scenario: Validate response from /posts/{id}/comments when the posts attribute is misspelled
    Given I send a request GET "DEFAULT_API_JSON_PLACEHOLDER_TYPE_CODE" to "/postss/10/comments"
    Then the response status should be 200

  @NegativeTestScript
  Scenario: Validate response from /posts/{id}/comments with a wrong Id
    Given I send a request GET "DEFAULT_API_JSON_PLACEHOLDER_TYPE_CODE" to "/postss/wrongId/comments"
    Then the response status should be 200

  @NegativeTestScript
  Scenario: Validate response from /posts/{id}/comments for a non-existent postId query parameter value
    Given I send a request GET "DEFAULT_API_JSON_PLACEHOLDER_TYPE_CODE" to "/postss/546100099999999/comments"
    Then the response status should be 200

  @HappyTestScript
  Scenario: Validate json schema response from /posts/{id}/comments endpoint with a valid application context
    Given I send a request GET "DEFAULT_API_JSON_PLACEHOLDER_TYPE_CODE" to "/posts/10/comments"
    And the response status should be 200
    Then the response should match "comments-by-post-schema.json"

