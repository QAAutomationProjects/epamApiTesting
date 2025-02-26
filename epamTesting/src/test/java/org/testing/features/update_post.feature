Feature: Validate PUT /posts/{id} endpoint

  Scenario: Successfully update a post
    Given I send a PUT request to "DEFAULT_API_JSON_PLACEHOLDER_TYPE_CODE" at "/posts/1" with the following body:
      """
      {
        "userId": 8,
        "title": "JSON placeholder put request",
        "body": "Put request used"
      }
      """
    Then the response status should be 200
    And the response PUT body should contain:
      | userId | id  | title                          | body              |
      | 8      | 1   | JSON placeholder put request   | Put request used  |

  Scenario: Unsuccessfully update a post
    Given I send a PUT request to "DEFAULT_API_JSON_PLACEHOLDER_TYPE_CODE" at "/posts/1" with the following body:
      """
      {
        "userIdNull": null,
        "titleNull": null,
        "bodyNull": null
      }
      """
    Then the response status should be 200
