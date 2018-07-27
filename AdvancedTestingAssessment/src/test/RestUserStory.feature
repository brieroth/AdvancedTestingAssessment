Feature: Assessment
  As an Admin,
  I want to manage the details of owners in the system,
  So that I can keep up to date information about all owners.


  Scenario: Testing gettting owners
    Given owners exist in database
    When retrieve owners
    Then the response code reads 200

  Scenario: Testing adding an owner

  Scenario: Testing the API using parameters
