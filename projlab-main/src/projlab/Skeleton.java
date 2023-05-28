package projlab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import projlab.tests.*;

public class Skeleton {

    private static boolean isPrinting = false;

    protected static void setPrinting(boolean val)
    {
        isPrinting = val;
    }

    public static void main(String[] args) {

        Test[] tesztesetek = {
                new CollectMaterialWithoutSackTest(),
                new CollectMaterialWithSackTest(),
                new CreateChoreaVirusTest(),
                new CreateMemoryLossVirusTest(),
                new CreateParalyzingVirusTest(),
                new CreateVaccineTest(),
                new DropEquipmentTest(),
                new MoveToAnotherFieldTest(),
                new PickUpEquipmentWhenFullTest(),
                new PickUpEquipmentWhenNotFullTest(),
                new ScanAlreadyKnownGeneticCodeTest(),
                new ScanNewGeneticCodeTest(),
                new StealEquipmentFromNonParalyzedVirologistTest(),
                new StealEquipmentFromParalyzedVirologistTest(),
                new UseChoreaVirusTest(),
                new UseChoreaVirusWhenProtectedByVaccineTest(),
                new UseChoreaVirusWhenProtectedByWhiteCoatTest(),
                new UseChoreaVirusWhenReflectedByGlovesTest(),
                new UseMemoryLossVirusTest(),
                new VirologistMovesWithChoreaVirusInfectionTest()
        };

        isPrinting = true;
        boolean exit = false;
        while (!exit) {
            System.out.println("Válassz egy lehetőséget:");
            System.out.println("0: Kilépés");

            for (int i = 0; i < tesztesetek.length; i++) {
                System.out.println((i + 1) + ": " + tesztesetek[i].getName());
            }

            int num = 0;
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                num = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException ne) {
                System.out.println("Nem jó formátumú szám!");
            } catch (IOException ie) {
                System.out.println("Fatális hiba, nem lehet olvasni az inputról. A program terminál.");
                System.exit(0);
            }

            if (num > 0 && num <= tesztesetek.length) {
                tesztesetek[num - 1].execute();
            } else if (num == 0) {
                exit = true;
            } else {
                System.out.println("Nincs ilyen számú lehetőség!");
            }
        }
    }

    private static int numberOfTabs = 0;

    private static void printTabs() {
        for (int i = 0; i < numberOfTabs; i++) {
            System.out.print("\t");
        }
    }

    /**
     * A metódushívás kiírása a szabányos kimenetre, indentálva.
     * Példa: Paraméterek (sorban): "Field", "collectBy(v)", false, "false".
     * Kimenet: "Field: collectBy(v): false END.
     * 
     * @param classType   az meghívott objektum osztálya
     * @param methodName  a meghívott metódus paraméterekkel együtt
     * @param starts      true, ha a hívás kezdődik, false, ha a hívás befejeződik
     * @param returnValue a visszatérési érték. Csak akkor kell megadni, ha a hívott
     *                    függvény befejeződik és nem void a visszatérési értéke,
     *                    egyébként lehet null.
     */
    public static void printMethodCall(String classType, String methodName, boolean starts, String returnValue) {
        if (isPrinting) {
            if (starts) {
                printTabs();
                System.out.println(classType + ": " + methodName + " START");
                numberOfTabs++;
            } else {
                if (returnValue == null) {
                    returnValue = "void";
                }
                numberOfTabs--;
                printTabs();
                System.out.println(classType + ": " + methodName + ": " + returnValue + " END");
            }
        }
    }
}
