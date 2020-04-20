Feature: Alex Want to Purchase Head Phones in TestMeApp 

 Scenario: The one where the users moves to cart without adding any item


 Given  Logininto TestMeapp
 Then    he is search for a product like headphones
 And     Try to proceed to payment without adding any item in the cart
 When    TestMe does not display the icon  
Scenario: Adding item into cart with out login into the page
Given opened TestMeApp Page
Then search for HeadPhones 
And click on add to cart
When sees the login Page to enter Username and Password

Scenario: Searching product with four letters 
Given opened  TestMeApp Page
Then logged into TestMeApp with valid Username And Password
And Searched for 4 letters word head
And clicked on the add to cart button 
When done product payment successfully

Scenario: Payment options
Given opened  TestMeApp Page
Then searches for a product headphones
And adding into cart he tried to proceed to payment
When didn't finds payment option