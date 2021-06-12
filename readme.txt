Scenarios:

Happy Path - Verify Flight Booking for the requested cities and validate ID.

Functional validations:
1. Verify dropdown values are able to select across the pages
2. Verify user can select any flights
3. Verify the selected flight details are appearing on the Choose flight page
4. Verify the credit card 
5. Verify the payment happens through visa, amex, diners 
6. Verify the amount on the Choose Flight page is same as the Payment and confirmation page
7. Verify the cancel button going to back page
8. Verify the flight details columns on the second page
9. Verify ticket Id, ticket Status , Credit Card masked/unmasked

Required Dependencies : Please refer pom.xml

Required JRE : JavaSE - 1.8 version 

How to run :
1. Open Feature File -> Context Click -> Run as -> Cucumber Feature
2. Go to testRunner.java -> Context Click -> Run as -> TestNG Test

Enhancements
- Utilities
- Xpath customization
- Database validation
- Serenity screenplay incorporation
- Extent Reports implementation ( would be really nice )



===================================== API Test ==========================================================

Run spaceDataX_RestAPI.java as java application project
Scenarios covered :
1. 200 GET happy path
2. 404 - If Endpoint is wrong
3. Status code verification
