Feature: New post creation

  Scenario: Should new post be created
    Given user is logged in
    When user adds new post
    Then new post created and visibles on Post page



