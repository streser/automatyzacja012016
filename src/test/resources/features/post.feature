Feature: Posts creation
  Scenario:Simple Post Creation
    Given user is logged in
    When User adds new post with title and some content
    Then by default it should be visible on the blog


  Scenario: Post Updating
    Given user is logged in and is editing the post
    When user sets Private Visibility and Pending Status for the post
    Then by defsult post should not be visible