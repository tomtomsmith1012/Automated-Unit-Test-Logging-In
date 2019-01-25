Feature: Registering with a simple form
As a user who is not yet a member
I want to register using the form
So that I can store my personalised information

   Scenario Outline: 
   Given I navigate to the React Application
   When I click the Link to Automated Testing Exercise Form
   And I fill click the "<country>" dropdown menu
   And I fill out the email field with "<email>"
   And I fill out the first password field with "<password>"
   And I fill out the second password field with "<password>"
   Then I should see a Success! Message
   
Examples:
    | country  | email | password |
    | United Kingdom | jh@juhg.com |ww3£www|
    | United Kingdom | ygf@df.com |tt3£tt|
    | France | wef@aef.com |pp£3pp|
    | Germany | wer@fwef.com |q3£2WW|

Scenario Outline: 
   Given I navigate to the React Application
   When I click the Link to Automated Testing Exercise Form
   And I fill click the "<country>" dropdown menu
   And I fill out the email field with "<email>"
   And I fill out the first password field with "<password>"
   And I fill out the second password field with the wrong password "<error>"
   Then I should see a message stating that the passwords do not match.
   
Examples:
    | country  | email | password | error |
    | United Kingdom | jh@juhg.com |ww£3www| tytyty |
    | United Kingdom | ygf@df.com |tt£3tt| 67tydf |
    | France | wef@aef.com |pp£3pp| rt5rt4 |
    | Germany | wer@fwef.com |qq£3WW| we34kj |