Feature: SignIn
   
  Scenario Outline: Valid login condition
 Given  open online testmeapp
 When   lalitha gives valid username and valid password "<uname>" "<pwd>"
 Then   he is able to see his name and title is home page
 
 Examples:
 |uname  |pwd|
 |Lalitha|Password123|