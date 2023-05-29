Feature: Scan New Genetic Code

  Scenario: Virologist scans a new genetic code
    Given a Virologist exists
    And a VaccineGene exists
    And a Laboratory exists
    And the genetic code is set in the Laboratory
    When the Virologist moves to the Laboratory
    And the Virologist collects from the field
    Then the Virologist gains information about the new genetic code
