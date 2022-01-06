Feature: Search for available taxis

  Scenario: Traveller searches for taxis within the same city
    Given Tracy wants to book a taxi
    When she searches for taxis for the following trip:
      | From               | To                     | Date     | Time |
      | Paddington Station | British Museum         | Tomorrow | 9:00 |
    Then the available taxis should be displayed
