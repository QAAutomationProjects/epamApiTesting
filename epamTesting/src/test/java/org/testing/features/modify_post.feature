Feature: Validate PATCH /posts/{id} endpoint

  @HappyTestScript
  Scenario: Successfully update a post title
    Given I send a PATCH request to "DEFAULT_API_JSON_PLACEHOLDER_TYPE_CODE" at "/posts/1" with the following body:
      """
      {
        "title": "new patch title"
      }
      """
    Then the response status should be 200

  @HappyTestScript
  Scenario: Successfully modify a post title Json Validation
    Given I send a PATCH request to "DEFAULT_API_JSON_PLACEHOLDER_TYPE_CODE" at "/posts/1" with the following body:
      """
      {
        "title": "new patch title"
      }
      """
    Then the response status should be 200
    And the response should match "modify-schema.json"

  @NegativeTestScript
  Scenario: Wrong Attribute to modify a post title
    Given I send a PATCH request to "DEFAULT_API_JSON_PLACEHOLDER_TYPE_CODE" at "/posts/1" with the following body:
      """
      {
        "new_title": "new patch title"
      }
      """
    Then the response status should be 200
