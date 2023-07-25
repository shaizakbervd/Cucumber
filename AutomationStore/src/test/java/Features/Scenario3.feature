Feature: Login and add items that are on sale
  @skin
Scenario Outline: Try to Login using email and password and add sale items

Given User is on Login Page
When User enters username "<username>" and password "<password>"
And User tries to Login
Then User is on the Landing page
When User navigates to skin care section
And checks how many items are on Sale
And checks how many items are Out of Stock
And Add the "Sale" items in cart
Then verify the selected items count

Examples:
  | username | password |
  | shaiz  | vivov11pro |