Feature: Navegate page
    As a users
    I want to navegate in the pages
    So I want to go to page when I click the link
    
    Scenario: Users can se contacts
      When I am in homepage
      And I follow "Contact"
      Then I should see contact informations