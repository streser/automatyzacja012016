Feature: Post Creation
  Scenario: Simple Post Creation
    Given user is logged
    When he adds new post with totle and simple content
    Then by default it should be visible on the blog

  Scenario: Post removing
    Given user is logged
    And he adds new post with totle and simple content
    When he delete post with selected title
    Then by default it shouldn't be visible on the blog
