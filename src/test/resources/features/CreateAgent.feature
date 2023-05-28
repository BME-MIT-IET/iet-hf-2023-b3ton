Feature: CreateAgent
  Background:
    Given a Virologist

  Scenario: Virologist creates Chorea Virus
    Given a ChoreaVirusGene
    When the Virologist adds the ChoreaVirusGene
    And the Virologist is provided with the necessary amino acid and nucleotide
    Then the Virologist creates the Chorea Virus agent

  Scenario: Virologist creates Memory Loss Virus
    Given a MemoryLossVirusGene
    When the Virologist adds the MemoryLossVirusGene
    And the Virologist is provided with the necessary amino acid and nucleotide
    Then the Virologist creates the Memory Loss Virus agent

  Scenario: Virologist creates Paralyzing Virus
    Given a ParalyzingVirusGene
    When the Virologist adds the ParalyzingVirusGene
    And the Virologist is provided with the necessary amino acid and nucleotide
    Then the Virologist creates the Paralyzing Virus agent

  Scenario: Virologist creates Vaccine
    Given a VaccineGene
    When the Virologist adds the VaccineGene
    And the Virologist is provided with the necessary amino acid and nucleotide
    Then the Virologist creates the Vaccine agent
