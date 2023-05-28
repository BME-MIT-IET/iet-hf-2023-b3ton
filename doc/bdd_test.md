# BDD tesztelés Cucumber segítségével
_(Mihályi Márk László)_

## BDD tesztek írása
Kezdetben utánajártam, hogy hogyan kell használni a Cucumber-t, hogyan kell a projektet felkészíteni a használatára. A példák alapos tanulmányozását követően hozzáláttam a feature fájlok elkészítésének, ahol a leírhatók a szcenáriók és lépések angol nyelven. Ezekhez el kellett készíteni a lépés definíciókat tartalmazó fájlokat, ami glue code-ként működve kódot köt a feature fájlokban található lépésekhez. Végül mindegyikhez Runner osztályt kellet készíteni. ami összeköti a feature fájlt a lépésdefiníciókkal.

## Tesztelt szcenáriók
- Felvett nukleotidmennyiség tesztelése zsákkal és zsák nélkül
- Különböző típusú vírusok készítése
- Felszerelés eldobása
- Mozgás másik mezőre
- Fertőzés Chorea vírussal védelem nélkül
- Fertőzés Chorea vírussal védelemmel

### Példa:

```gherkin
Feature: Use ChoreaVirus

  Scenario: Virologist applies ChoreaVirus to another Virologist
    Given there are two virologists
    And there is a ChoreaVirus
    And there is a SackEquipment
    And the SackEquipment is added to one of the virologists
    When the ChoreaVirus is used on the other virologist by the first virologist
    Then the other virologist should be infected with ChoreaVirus
```