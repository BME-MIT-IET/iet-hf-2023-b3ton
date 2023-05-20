# Statikus analízis végzése a projekten
(Györfi Bence)

## A kód áttekintése manuálisan

Az első probléma ami rögtön szembe jött, hogy a file-ok nincsenek package-ekbe rendezve, ami jelentősen megnehezíti az áttekinthetőséget.
Így a felelősségek nincsenek szépen elosztva. Maximum a fileok neveire hagyatkozhatunk.

A kommentezést sem tartom megfelőnek. Például az Agent osztály esszé szerűen van kommentezve, ami nem követi a @javadoc konvenciókat.

Apróbb hibák:
    -   Skeleton osztályban exit == false helyett exit! vagy starts == true helyett starts
    -

## Statikus Analízis implementálása

