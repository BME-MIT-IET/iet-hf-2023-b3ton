Feature: Use ChoreaVirus

  Scenario: Virologist applies ChoreaVirus to another Virologist
    Given there are two virologists
    And there is a ChoreaVirus
    And there is a SackEquipment
    And the SackEquipment is added to one of the virologists
    When the ChoreaVirus is used on the other virologist by the first virologist
    Then the other virologist should be infected with ChoreaVirus
