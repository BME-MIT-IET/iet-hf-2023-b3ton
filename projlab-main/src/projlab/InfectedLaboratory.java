package projlab;

/**
 *  A fertőzött laboratóriumot reprezentáló osztály. Aki belép a területére, azt megpróbálja 
 * fertőzni a BearDanceVirus-szal.
 */
public class InfectedLaboratory extends Laboratory {
    /**
     * Az InfectedLaboratoryban található BearDanceVirus, amivel megfertőzi a belépő Virologistokat.
     */
    private BearDanceVirus virus;

    /**
     * Belépteti a ‘v’ Virologist objektumot a mezőre, azaz beteszi a virologists tömbbe, majd meghívja a tárolt 
     * BearDanceVirus useOnBy(on: Virologist, by: Virologist) függvényét az ‘on’ és ‘by’ paraméterként is a ‘v’ Virologist-ot megadva.
     */
    @Override
    public void stepIn(Virologist v) {
        Skeleton.printMethodCall(toString(), "stepIn(Virologist v)", true, null);
        virologists.add(v);
        virus.useOnBy(v, v);
        Skeleton.printMethodCall(toString(), "stepIn(Virologist v)", false, null);
    }

    /**
     * Paraméter nélüli konstruktor
     */
    public InfectedLaboratory() {
        super();
        virus = new BearDanceVirus();
    }

    /**
     * Paraméteres konstuktor, ami beállítja az InfectedLaboratoryban található GeneticCode-ot
     * @param gc  az InfectedLaboratoryban található GeneticCode
     */
    public InfectedLaboratory(GeneticCode gc) {
        super(gc);
        virus = new BearDanceVirus();
    }

    /**
     * Az osztály nevének visszaadása.
     * 
     * @return "InfectedLaboratory"
     */
    @Override
    public String toString() {
        return "InfectedLaboratory:" + id;
    }
}
