Feature: Steal Equipment from Paralyzed Virologist

  Scenario: Virologist attempts to steal equipment from a paralyzed virologist
    Given a Virologist exists
    And another Virologist exists
    And a pair of Gloves
    And the second Virologist has the Gloves
    And a TimedChoreaEffect exists with a duration of 10
    And a TimedParalyzingEffect exists with a duration of 10
    And the second Virologist is affected by the TimedChoreaEffect and TimedParalyzingEffect
    When the first Virologist attempts to steal equipment from the second Virologist
    Then the first Virologist successfully steals the equipment
