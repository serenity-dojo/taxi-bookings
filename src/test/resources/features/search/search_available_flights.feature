Feature: Search for available flights

  Scenario: Traveller searches for taxis within the same city
    Given Tracy wants to book a flight
    When she searches for flights for the following trip:
      | From         | To     | Depart   | Return  |
      | London Luton | Dublin | Tomorrow | +5 days |
    Then the available flights should be displayed