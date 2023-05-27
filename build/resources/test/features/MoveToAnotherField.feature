Feature: MoveToAnotherField
  Scenario: Virologist moves to another field
    Given a Virologist
    And two neighboring Fields
    When the Virologist steps into the first Field
    And the Virologist moves to the second Field
    Then the Virologist should be on the second Field
