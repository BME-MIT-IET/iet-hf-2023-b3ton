# Manuális tesztek

Először a tesztek terveit készítettem el, amihez megállapítottam a teszt célokat, a tesztelendő elemeket, majd ezek alapján elkészítettem a teszteseteket és tesztforgatókönyveket.

## Teszt céljai

A játék manuális tesztelésének célja, hogy biztosítsuk a játék minden funkciója megfelelően működik, és a játékélmény a tervezettnek megfelelő. A tesztek különféle céljai a következők:

1.  **Funkcionális tesztelés**: A játék alapvető funkcióinak tesztelése, mint a játékosok hozzáadása, az események sorrendje, az interfész megjelenítése stb.
2.  **Használhatósági tesztelés**: Megvizsgáljuk, hogy a játék használata intuitív-e a játékos számára, beleértve az interfész design-t és a visszajelzési mechanizmusokat.
3.  **Játék logika tesztelése**: A játékmechanizmusok, például a genetikai kódok, az ágensek, az alapanyagok, a virológusok és a védőfelszerelések működésének tesztelése.
4.  **Tesztelés az esetleges hibákra**: A játékot stresszteszteknek vetjük alá, hogy megbizonyosodjunk arról, hogy a játék hibák és hibakezelések esetén is helyesen működik, mint például amikor egyes funkciók határértékeit átlépjük.

A manuális tesztelés nem csupán a hibák és problémák feltárását szolgálja, hanem azt is, hogy megbizonyosodjunk arról, hogy a játék elemei összhangban vannak-e, és együtt jól működnek-e. Ez magában foglalja a játékmenet logikáját, a játékvezérlést, a felhasználói felületet és a játékban található bármilyen más elemet, ami befolyásolhatja a játék működését.

A tesztek forgatókönyveinek kidolgozásához felhasználtam a dokumentációt, valamint az abban megfogalmazott követelményeket és use-caseket.

## Tesztelendő elemek, forgatókönyvek

**Teszteset 1: Játékos hozzáadása**
- Cél: Ellenőrizni, hogy a játékos hozzáadása megfelelően működik-e.
- Lépések:
    1. Indítsa el a játékot.
    2. Adjon hozzá egy humán játékost.
    3. Ellenőrizze, hogy a játék megfelelően regisztrálta-e a játékost.

**Teszteset 2: Játékosok sorrendje**
- Cél: Ellenőrizni, hogy a játékosok eseményei a játékban megfelelő sorrendben történnek-e.
- Lépések:
    1. Adjon hozzá a játékhoz több játékost.
    2. Indítsa el a játékot.
    3. Ellenőrizze, hogy a játékosok egymás után kerülnek sorra a játék elején meghatározott sorrendben.

**Teszteset 3: Interface helyes megjelenítése**
- Cél: A játék felületének helyes megjelenítése.
- Lépések:
    1. Ügyelj arra, hogy a játékos minden információt láthasson a felületen, beleértve az eseményeket, pályát, virológusokat, aktív ágenseket, genetikai kódokat, alapanyagokat és ágenseket.

**Teszteset 4: Virológus mozgatása**
- Cél: Ellenőrizni, hogy a játékos virológusa helyesen léphet-e a szomszédos mezőkre.
- Lépések:
    1. Válassz ki egy virológust.
    2. Lépj egy szomszédos mezőre, és ügyelj arra, hogy az új mezőn a virológus jól jelenik-e meg.
    3. Ismételd meg a lépést 2-t a különböző mezőtípusokra: szabad terület, laboratórium, raktár és óvóhely.
    4. Ellenőrizd, hogy a virológus találkozik-e a többi virológussal, ha ugyanazon a mezőn vannak.

**Teszteset 5: Genetikai kód letapogatása**
- Cél: A virológus helyesen le tudja-e tapogatni a genetikai kódot, és megtanulja-e azt.
- Lépések:
    1. Válassz egy virológust, és lépj egy laboratóriumhoz.
    2. Használd a "Collect" opciót.
    3. Ellenőrizd, hogy a virológus megtanulta-e az adott genetikai kódot.
    4. Próbáld meg leolvasni ugyanazt a genetikai kódot még egyszer, és győződj meg róla, hogy semmi sem történik.
    5. Ismételd meg a lépéseket több kóddal.

**Teszteset 6: Alapanyagok összegyűjtése**
- Cél: A virológus képes legyen összegyűjteni a szükséges alapanyagokat.
- Lépések:
    1. Válassz egy virológust, és lépj egy raktárhoz.
    2. Használd a "Collect" opciót.
    3. Ellenőrizd, hogy a virológus összegyűjtötte-e a raktárban lévő összes alapanyagot.
    4. Próbáld újra összegyűjteni az alapanyagokat, amikor a virológus már túl sok alapanyagot tart.
    5. Győződj meg róla, hogy a virológus csak annyi alapanyagot vesz át, amennyi még elfér.

**Teszteset 7: Ágens létrehozása**
- Cél: Az ágens létrehozása a genetikai kód alapján.
- Lépések:
    1. Válassz egy virológust, és használd a "Create Agent" opciót.
    2. Ellenőrizd, hogy a rendelkezésre álló alapanyagok levonódtak-e.
    3. Győződj meg arról, hogy az ágens hatóideje beállt a kezdőértékre.
    4. Próbáld meg létrehozni egy ágenst úgy, hogy nem állnak rendelkezésre a szükséges alapanyagok.

**Teszteset 8: Ágens használata**
- Cél: Az ágens helyes felhasználása.
- Lépések:
    1. Válassz egy virológust, és használd az "Use Agent" opciót.
    2. Válassz ki egy másik virológust vagy magadat, akihez az ágenst fel akarod használni.
    3. Ellenőrizd, hogy az ágens kifejtette-e hatását a célpontra, és elhasználódott-e.

**Teszteset 9: Védőfelszerelés felvétele**
- Cél: A virológus felveszi a védőfelszerelést.
- Lépések:
    1. Válassz egy virológust, és lépj egy óvóhelyre.
    2. Használd a "Collect" opciót.
    3. Ellenőrizd, hogy a virológus eltávolította-e a felszerelést az óvóhelyről, és magával vitte-e a felszerelést.

**Teszteset 10: Védőfelszerelés ellopása**
- Cél: A virológus ellopja a másik virológus felszerelését.
- Lépések:
    1. Válassz ki egy virológust, és próbáld meg ellopni a felszerelést egy olyan virológustól, aki le van bénítva.
    2. Ellenőrizd, hogy a virológus megkapta-e a véletlenszerű védőfelszerelést és az alapanyagot.
    3. Próbáld meg ellopni a felszerelést egy nem lebénított virológustól, és győződj meg róla, hogy semmi sem történik.

**Teszteset 11: Ágensek hatóidejének működése**
- Cél: Ellenőrizni, hogy az idő múlásával az ágensek hatóideje helyesen csökken-e.
- Lépések:
    1. Kövesd egy virológus ágens készletét, amelynek hatóideje csökkenni fog.
    2. Játszd le egy kör végét, és ellenőrizd, hogy az ágensek hatóideje megfelelően csökkent-e (eggyel).
    3. Ismételd meg a lépést többször, és figyeld, hogy az ágensek megszűnnek-e, amikor a hatóidejük eléri a nullát.

**Teszteset 12: Védőfelszerelés hatásai**
- Cél: A védőfelszerelések hatásának ellenőrzése.
- Lépések:
	1. Miután a virológus felvett egy védőköpenyt, győződjünk meg, hogy annak a hatása valóban működik
	2. Miután a virológus felvett egy zsákot, győződjünk meg, hogy annak a hatása valóban működik
	3. Miután a virológus felvett egy kesztyűt, győződjünk meg, hogy annak a hatása valóban működik

**Teszteset 13: Játék megnyerése**
- Cél: A játék megnyerésének kritériumainak ellenőrzése.
- Lépések:
    1. Indítsa el a játékot és adja hozzá a játékosokat.
    2. Egy játékosnak a játékban szereplő összes ágens genetikai kódját meg kell tanulnia.
    3. Ellenőrizze, hogy a játék megnyerésének kritériumai teljesülnek-e, és az a játékos, aki megfelelt nekik, megnyerte-e a játékot."

## Tesztek eredményei

**TESZT 1: Játékos hozzáadása**
- **Eredmény:** Sikertelen
- **Megfigyelések:** A program elindításakor automatikusan vannak a játékhoz adva a virológusok. Nincs manuális módja a játékos hozzáadásának.

**TESZT 2: Játékosok sorrendje**
- **Eredmény:** Sikeres
- **Megfigyelések:** A virológusok a követelményeknek megfelelően egymás után, sorrendben következnek.

**TESZT 3: Interface helyes megjelenítése**
- **Eredmény:** Részben sikeres
- **Megfigyelések:** A felhasználói interfész rendesen megjelenik, és működik, viszont a megérthetősége nehézkés, és nem egyértelmű, hogy melyik gomb mit csinál.

**TESZT 4: Virológus mozgatása**
- **Eredmény:** Sikeres
- **Megfigyelések:** A virológus helyesen mozgott a szomszédos mezőkre (legyen az bármilyen fajta mező), valamint a mezőn lévő egyéb virológusok is helyesen jelennek meg.

**TESZT 5: Genetikai kód letapogatása**
- **Eredmény:** Sikeres
- **Megfigyelések:** A virológus sikeresen le tudja olvasni a kódokat a laboratóriumokból. 

**TESZT 6: Alapanyagok összegyűjtése**
- **Eredmény:** Sikeres
- **Megfigyelések:** A virológus sikeresen össze tudja gyűjteni az alapanyagokat. A program a határértékeknél is helyesen működik, a limitnél nem tud többet felvenni a virológus.

**TESZT 7: Ágens létrehozása**
- **Eredmény:** Sikeres
- **Megfigyelések:** A virológus sikeresen létrehozza az ágenseket. Amennyiben nincs elég alapanyag, nem lesz engedélyezve az ágens létrehozása.

**TESZT 8: Ágens használata**
- **Eredmény:** Sikeres
- **Megfigyelések:** Az ágens sikeresen kifejtette a hatását, és az ágens elhasználódott.

**TESZT 9: Védőfelszerelés felvétele**
- **Eredmény:** Sikeres
- **Megfigyelések:** A védőfelszerelés sikeresen el lett távolítva, és a virológus sikeresen megkapta a védőfelszerelést.

**TESZT 10: Védőfelszerelés ellopása**
- **Eredmény:** Sikeres
- **Megfigyelések:** A lopás sikeres volt lebénított virológussal, de sikertelen volt egy nem lebénított virológussal.

**TESZT 11: Ágensek hatóidejének működése**
- **Eredmény:** Sikeres
- **Megfigyelések:** A körök múlásával az ágensek hatóideje csökken, és amikor ez lejár, akkor eltűnik a virológustól.

**TESZT 12: Védőfelszerelés hatásai**
- **Eredmény:** Sikeres
- **Megfigyelések:** A köpeny, zsák és kesztyű mind helyesen fejtik ki a hatásukat.

**TESZT 13: Játék megnyerése**
- **Eredmény:** Sikeres
- **Megfigyelések:** Az összes kód összegyűjtése után a játék megnyeréséről kapunk egy üzenetet, és további akciókat nem tudunk végrehajtani.

## Exploratory tesztelés eredményei

Az exploratory tesztelés folyamán sok újdonság nem derült ki, az történések nagy részét lefedték a megtervezett tesztesetek. A néhány említésre méltó dolog ami kiderült az exploratory testing alatt az alábbi:
- A felhasználói felület nem intuitív, és a dokumentáció elolvasása nélkül nehéz kitalálni, hogy pontosan hogyan kell kezelni a játékot.
- Az egész program újraindításán kívül nincs mód a játékot elölről kezdeni.
- A saját magadtól lopást jól kezeli a program, vagyis ilyenkor nem történik semmi. Ezt nem fedték le a tesztesetek, de az exploratory tesztelés alatt ki lett próbálva.