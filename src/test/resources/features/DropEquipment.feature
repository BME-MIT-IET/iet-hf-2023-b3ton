Feature: Drop Equipment

  Scenario: Virologist drops equipment
    Given a Virologist
    And a SackEquipment
    When the Virologist adds the SackEquipment
    And the Virologist drops the SackEquipment
    Then the Virologist should no longer have the SackEquipment
