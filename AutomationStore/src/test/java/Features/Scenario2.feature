Feature: Login and add items whose name ends with relevant filters
@last
Scenario Outline: Try to Login using email and password and add items based on filters

Given User is on Login Page
When User enters username "<username>" and password "<password>"
And User tries to Login
Then User is on the Landing page
When User navigates to Apparel page
And Then navigates to tshirts page
When User sort elements from "Price Low > High"
And Selects top 3 lowest t-shirts and add it to cart
When Go back to Apparels section
When Navigate to Shoes Page
And Add highest price product in cart
And Select quantity "2" and proceed
Then Verify the "3" items in cart




Examples:
| username | password |
| shaiz  | vivov11pro |