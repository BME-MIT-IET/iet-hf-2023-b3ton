Feature: Collect Material
  Background:
    Given a Virologist
    And a Storage
    And a Timed Chorea Effect lasting for 10 seconds
    And the Virologist is at the Storage
    And the Virologist has the Timed Chorea Effect
    And the Storage contains 10 Amino Acids
    And the Storage contains 15 Nucleotides

  Scenario: Virologist collects material without a sack
    Given a pair of Gloves Equipment
    And the Virologist has the Gloves Equipment
    When the Virologist collects from the field
    Then the Virologist should collect 10 Nucleotides

  Scenario: Virologist collects material with a sack
    Given a Sack Equipment
    And the Virologist has the Sack Equipment
    When the Virologist collects from the field
    Then the Virologist should successfully collect 15 Nucleotides with the sack

