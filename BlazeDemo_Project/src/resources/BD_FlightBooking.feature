@BDtests
Feature: E2E test cases

@PR_P0 @regression @smoke @jira_id_1
  Scenario: Verify booking a flight and validate confirmation ID
    Given verify travel agency home page
    When select the departure and destination
    | Departure | Destination  |
    | San Diego | London       |
    When choose the flight from "San Diego" to "London"
    | Flight # | Airline        |
    | 12       | Virgin America |
    When verify entering passenger details for flightNum "12"
    | Name  | Address          | City      | State   | Zip Code | Card Type        | Credit Card Number | Month | Year | Name on Card |
    | John  | #23, Gree valley | Amsterdam | France  | NE12 3BJ | American Express | 2297 7237 3746 4946| Jan   | 2022 | John Daniel  |
    Then verify the booking confirmation ID
    
   @PR_P0 @regression @smoke @jira_id_2
 Scenario Outline: Verify all cities are selected from dropdown and able to proceed with next page, also verify the combinatino of the cities
   Given verify travel agency home page
    When choose the "<departure>" and "<destination>"
    Then flights selection successful
    
    Examples:
    | departure   | destination  |
    | San Diego   | London       |
    | Paris       | Buenos Aires |
    | Philadelphia| Rome         |
    | Boston      | Berlin       |
    | Portland    | New York     |
    | Mexico City | Dublin       |
  
    
@PR_P0 @regression @smoke @jira_id_3
 Scenario Outline: Verify booking a flight and validate whether all flights choose button is working or not
    Given verify travel agency home page
    When select the departure and destination
    | Departure | Destination  |
    | San Diego | London       |
    Then choose below flights "<flightNum>" and "<airLine>"
    Then flights selection successful
    
    Examples:
    | flightNum| airLine        |
    | 43       | Virgin America |
    | 234      | United Airlines|
    | 9696     | Aer Lingus     |
    | 12       | Virgin America |
    | 4346     | Lufthansa      |
    