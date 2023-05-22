package projlab;

/**
 * A vitustánc ideiglenes  hatást megvalósító osztály.
 */
public class TimedChoreaEffect extends TimedEffect {
    /**
     * Egyparaméteres konstruktor. Létrehoz egy példányt az adott lejárati idővel.
     * Meghívja a TimedEffect ős konstruktorát ( #TimedEffect(timeLeft: int) ), és létrehoz egy példányt az adott lejárati idővel.
     * @param timeLeft az Effect érvényességi ideje
     */
    public TimedChoreaEffect(int timeLeft) {
        super(timeLeft);
        Skeleton.printMethodCall(toString(), "TimedChoreaEffect(int timeLeft)", true, null);
        Skeleton.printMethodCall(toString(), "TimedChoreaEffect(int timeLeft)", false, null);
    }

    /**
     * Mivel a hatás alatt a virológus végig vítustáncot jár,
     * ezért mindig igazzal tér vissza.
     * 
     * @return true
     */
    @Override
    public boolean hasChorea() {
        Skeleton.printMethodCall(toString(), "hasChorea()", true, Boolean.toString(true));
        Skeleton.printMethodCall(toString(), "hasChorea()", false, Boolean.toString(true));
        return true;
    }

    /**
     * Az osztály nevének visszaadása.
     * 
     * @return "TimedChoreaEffect"
     */
    @Override
    public String toString() {
        return "TimedChoreaEffect(" + timeLeft + ")";
    }
}
