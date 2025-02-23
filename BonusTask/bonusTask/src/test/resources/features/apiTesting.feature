Feature: API Testing with Cucumber and RestAssured

  Scenario: User sends a GET request to retrieve a post
    Given The API endpoint is "https://jsonplaceholder.typicode.com/posts/1"
    When I send a GET request
    Then The response status code should be 200
    And The response body should contain "sunt aut facere repellat provident occaecati excepturi optio reprehenderit"




  Scenario: Create a new post via POST request
    Given The API endpoint is "https://jsonplaceholder.typicode.com/posts"
    When I send a POST request with the following body
      """
      {
        "userId": 1,
        "title": "Fatih Onur Yenice Post",
        "body": "Post Body for Case Study."
      }
      """
    Then The response status code should be 201
    And The response body should contain "Fatih Onur Yenice Post"


  Scenario: Send a POST request with an invalid body (400 Bad Request) (Negative Test)
    Given The API endpoint is "https://jsonplaceholder.typicode.com/posts"
    When I send a POST request with an invalid body
    Then The response status code should be 400

  Scenario: Send a POST request to a non-existent endpoint (500 Internal Server Error) (Negative Test)
    Given The API endpoint is "https://jsonplaceholder.typicode.com/invalid-endpoint"
    When I send a POST request with the following body
      """
      {
        "userId": 1,
        "title": "Fatih Onur Yenice Post",
        "body": "Post Body for Case Study."
      }
      """
    Then The response status code should be 500
