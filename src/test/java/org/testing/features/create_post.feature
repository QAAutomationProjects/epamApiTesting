Feature: Validate Creation POST

  @HappyTestScript
  Scenario: Successfully create a new post
    Given I send a request POST "DEFAULT_API_JSON_PLACEHOLDER_TYPE_CODE" to "/posts" with the following body:
      """
      {
        "userId": 8,
        "id": 55,
        "title": "Api Testing",
        "body": "Different Kind of Validations"
      }
      """
    Then the response status should be 201
    And the response by POST body should contain:
       | title        | body                             |
       | Api Testing  | Different Kind of Validations    |

  @HappyTestScript
  Scenario: Successfully create a new post Validating JSON
    Given I send a request POST "DEFAULT_API_JSON_PLACEHOLDER_TYPE_CODE" to "/posts" with the following body:
      """
      {
        "userId": 8,
        "id": 55,
        "title": "Post created by Nikola",
        "body": "Information..."
      }
      """
    Then the response status should be 201
    And the response should match "create-post-schema.json"


  @NegativeTestScript
  Scenario: Null Values for create a new post
    Given I send a request POST "DEFAULT_API_JSON_PLACEHOLDER_TYPE_CODE" to "/posts" with the following body:
      """
      {
        "userId": null,
        "id": null,
        "title": null,
        "body": null
      }
      """
    Then the response status should be 201

  @NegativeTestScript
  Scenario: Empty Values for create a new post
    Given I send a request POST "DEFAULT_API_JSON_PLACEHOLDER_TYPE_CODE" to "/posts" with the following body:
      """
      {
        "userId": " ",
        "id": " ",
        "title": " ",
        "body": " "
      }
      """
    Then the response status should be 201