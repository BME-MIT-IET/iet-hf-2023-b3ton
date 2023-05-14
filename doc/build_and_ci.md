# Build keretrendszer és CI beüzemelése
_(Szarvas Dániel)_

## Gradle beüzemelése

A **build keretrendszerek** közül a `Gradle`-t választottuk ki, 
mivel ez volt a legfrissebb azok közül, amiket mi is ismerünk. 
A feladatot a `build.gradle` fájl megírásával kezdtem, ami magáért a build koordinálásáért felelős.
Elkezdtem utánajárni, hogy mit szükséges beleírnom a helyes működéshez, 
és [ezen a linken](https://www.jetbrains.com/help/idea/gradle.html#convert_project_to_gradle)
kezdtem el megérteni, hogy mire is lesz szükségem.

Első lépésként beállítottam az alapvető kötelező paramétereket:
- `java` plugin linkelése
- group és version beállítása
- `mavenCentral()` linkelése a repositories-ba
- `JUnit` hozzáadása a dependencies-hez

Ezt követően be kellett állítanom a _main class_-t valamilyen módon, hogy a `Gradle` tudja, 
hol keresse meg a `Main()`-t. Ekkor megismertem az [application plugin](https://docs.gradle.org/current/userguide/application_plugin.html)-t,
aminek segítségével be tudtam állítani ezt is, az alábbi módon:

```groovy
plugins {
    id 'application'
}

application {
    mainClass = 'projlab.GUI'
}
```

Ekkor már fordult és futott is a projekt, viszont a helytelen encoding miatt az ékezetes kommenteket nem tudta rendesen lefordítani.
A compiler-nek az alábbi módon tudtam megadni a helyes encoding-ot:

```groovy
tasks.withType(JavaCompile) {
    options.encoding = "UTF-8"
}
```

Ezt követően sikeresen futott már a projekt a `.\gradlew`, majd pedig a `.\gradlew run` parancsok kiadását követően.