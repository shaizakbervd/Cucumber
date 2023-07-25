Feature: Login and add items whose name ends with M
@M
Scenario Outline: Try to Login using email and password and add items whose name ends with M

Given User is on Login Page
When User enters username "<username>" and password "<password>"
And User tries to Login
Then User is on the Landing page
When User selects MEN products only
When User selects product whose name ends with "M"
And Add items to the cart
Then verify the selected product has ending name with "M"


Examples:
  | username | password |
  | shaiz  | vivov11pro |