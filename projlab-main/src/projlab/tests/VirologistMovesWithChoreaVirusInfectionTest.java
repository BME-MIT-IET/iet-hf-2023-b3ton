package projlab.tests;

import projlab.*;

/**
 * TESZT: A Virologist ChoreaVirus hatása alatt áll,
 * miközben az ő köre következik, ezért random mezőre lép,
 * a játékos nem tudja irányítani.
 * Létrehoz két szomszédos Field-et, ráteszi a Virologist-et az egyikre,
 * beállít a Virologist-ra egy TimedChoreaEffect-et, végül
 * meghívja a kör végrehajtásának függvényét a Virologist-on.
 */
public class VirologistMovesWithChoreaVirusInfectionTest extends Test {

    public VirologistMovesWithChoreaVirusInfectionTest() {
        super("VirologistMovesWithChoreaVirusInfection");
    }

    @Override
    public void execute() {
        /**
         * Ezt írja le a use case-hez tartozó kommunkációs diagram
         */
        TimedChoreaEffect tce = new TimedChoreaEffect(10);
        Virologist v = new Virologist();
        Field f1 = new Field();
        Field f2 = new Field();
        f1.setNeighbor(f2);
        f2.setNeighbor(f1);
        v.moveTo(f1);
        v.addEffectBy(tce, null);

        /**
         * Ezt írja le a use case-hez tartozó szekvenciadiagram
         */
        v.startTurn();
    }
}
