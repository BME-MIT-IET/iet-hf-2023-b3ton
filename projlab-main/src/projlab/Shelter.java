package projlab;

/**
 * Az óvóhelyet reprezentáló osztály. A Field-ből származik le. A Field
 * felelősségei mellett képes átadni a benne lévő Equipment-et.
 */
public class Shelter extends Field {
    /**
     *  A Shelteren találató Equipment, amit a Virologist fel tud szedni.
     */
    Equipment equipment;

    /**
     * Paraméter nélküli konstruktor. Meghívja a Field konstruktorát.
     */
    public Shelter() {
        super();
        Skeleton.printMethodCall(toString(), "Shelter()", true, null);
        Skeleton.printMethodCall(toString(), "Shelter()", false, null);
    }

    /**
     * Konstruktor egy eltárolandó Equipment-el.
     * Meghívja a Field konstruktorát, és eltárolja a kapott Eqipmentet.
     * @param e az eltárolandó Equipment
     */
    public Shelter(Equipment e) {
        super();
        Skeleton.printMethodCall(toString(), "Shelter(Equipment e)", true, null);
        addEquipment(e);
        Skeleton.printMethodCall(toString(), "Shelter(Equipment e)", false, null);
    }

    /**
     * A kapott Equipment eltárolása.
     * Eltárolja a kapott Equipmentet, amennyiben eddig nem volt a Shelterben
     * Equipment.
     * False-al tér vissza, és bennehagyja az Equipmentet, ha null-t kap, vagy már
     * volt benne Equipment.
     * 
     * @param e kapott Equipment
     * @return hogy az eltárolás sikeres volt-e
     */
    public boolean addEquipment(Equipment e) {
        Skeleton.printMethodCall(toString(), "addEquipment(Equipment e)", true, null);

        Boolean added;
        if (e == null || equipment != null) {
            added = false;
        } else {
            equipment = e;
            added = true;
        }
        Skeleton.printMethodCall(toString(), "addEquipment(Equipment e)", false, added.toString());
        return true;
    }

    /**
     * A tárolt Equipment törlése.
     * Eldobja a tárolt Equipment-et, amennyiben volt benne.
     */
    public void removeEquipment() {
        Skeleton.printMethodCall(toString(), "removeEquipment()", true, null);
        equipment = null;
        Skeleton.printMethodCall(toString(), "removeEquipment()", false, null);
    }

    /**
     * Meghívja a ‘v’ Virologist objektum addEquipment(e: Equipment) függvényét a Shelter mezőn található egyik 
     * Equipment-tel paraméterezve. Amennyiben a függvény igazzal tér vissza, törli az Equipment-et a mezőről.
     * @param v a begyűjtő Virologist
     * @return hogy sikeres volt-e az átadás
     */
    @Override
    public boolean collectBy(Virologist v) {
        Skeleton.printMethodCall(toString(), "collectBy(Virologist v)", true, null);

        boolean added = v.addEquipment(equipment);
        if (added) {
            removeEquipment();
        }
        Skeleton.printMethodCall(toString(), "collectBy(Virologist v)", false, Boolean.toString(added));
        return added;
    }

    /**
     * Visszaadja a Sheleren található equipmentet
     * @return a Shelteren található equipment
     */
    @Override
    public Equipment getEquipment(){
        return equipment;
    }

    /**
     * Az osztály nevének visszaadása.
     * 
     * @return "Shelter"
     */
    @Override
    public String toString() {
        return "Shelter:" + id;
    }
}
