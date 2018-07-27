Feature: Assessment
As an Admin,
I want to manage the details of owners in the system,
So that I can keep up to date information about all owners.

Scenario: Add owner on site
  Given the home page
  When i click on the owner tab
  And i click on the add button
  When i fill out the details and save
  Then i click the all button again
  Then i want to view all the pet owners

