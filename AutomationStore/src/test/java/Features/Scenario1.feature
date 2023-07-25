Feature: Login and select latest DOVE product
Scenario Outline: Try to Login using email and password and add DOVE product

Given User is on Login Page
When User enters username "<username>" and password "<password>"
And User tries to Login
Then User is on the Landing page
When User selects MEN products
When User selects latest "DOVE" product
And Add it to the cart
Then verify the selected product has price "6.70" and quantity is "1"

Examples:
  | username | password |
  | shaiz  | vivov11pro |