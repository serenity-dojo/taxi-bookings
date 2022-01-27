Feature: Search for available flights

  Rule: When searching on the English site English placenames should be used

    @English
    Scenario: Traveller searches for taxis within the same city
      Given Tracy wants to book a flight
      When she searches for flights for the following trip:
        | From         | To     | Depart   | Return  |
        | London Luton | Dublin | Tomorrow | +5 days |
      Then the available flights should be displayed for the following itineraries:
        | London Luton to Dublin |
        | Dublin to London Luton |


  Rule: When searching on the Spanish site Spanish placenames should be used

    @Spanish
    Scenario: Traveller searches for taxis within the same city
      Given Tracy wants to book a flight
      When she searches for flights for the following trip:
        | From          | To                | Depart   | Return  |
        | Londres Luton | Barcelona-El Prat | Tomorrow | +5 days |
      Then the available flights should be displayed for the following itineraries:
        | Londres Luton a Barcelona-El Prat |
        | Barcelona-El Prat a Londres Luton |
