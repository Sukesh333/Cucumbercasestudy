Feature: Searching for product
  I want to use this template for my feature file

  Scenario Outline:  Valid login condition
 Given  open online testmeapp and login
 When   enter the item "<search>" and click on findDetails
 And    he is able to see his product
 Then   click on cart
 And    Select bank and enter bank details
 And    click on payment
 
 Examples:
 |search|
 |Head|