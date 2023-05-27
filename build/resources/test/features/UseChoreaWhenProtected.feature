Feature: Use ChoreaVirus when protected by vaccine

  Scenario: Virologist tries to use ChoreaVirus on another Virologist protected by vaccine
    Given there are two Virologists
    And there is a ChoreaVirus
    And there is a SackEquipment
    And there is a TimedProtectingEffect with a duration of 10
    And the SackEquipment is added to one of the Virologists
    And the TimedProtectingEffect is added to the other Virologist
    When the ChoreaVirus is used on the Virologist protected by vaccine
    Then the ChoreaVirus should have no effect on the Virologist
