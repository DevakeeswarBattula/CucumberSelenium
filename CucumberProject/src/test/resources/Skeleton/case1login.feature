Feature: Login TestMe app
@login
Scenario: Admin User login
    Given The URL of TestMe App
    When user logged in as admin
    Then user is in admin home page
@addcategory
 Scenario: Adding category
     Given select add category
     When user enters category name and description
     Then adding products successfully
     
     
 