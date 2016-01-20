Feature: Adding posts

  Scenario: Should allow adding post
    Given user is logged in
    When user adds simple post
    Then added post should be visible in blog page

#  Scenario: Should added privat post be not visible to other users
#    Given user adds new post
#    When user changes visibility to privat
#    Then after adding post should be not visible to other users