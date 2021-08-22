Feature: Authenticating in Login Page
  Scenario: Authentication with valid credentials
    Given User accesses the login page at "http://localhost:8080/login"
    When input "admin" as username
    And input "1234" as password
    And Press the login button
    Then Check if the title is "SpringBoot AdminLTE2 - Dashboard"

