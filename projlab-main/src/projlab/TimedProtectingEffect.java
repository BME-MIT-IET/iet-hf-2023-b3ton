package projlab;

/**
 * A védelem hatást megvalósító osztály.
 */
public class TimedProtectingEffect extends TimedEffect {
    /**
     * Egyparaméteres konstruktor. Létrehoz egy példányt az adott lejárati idővel.
     * Meghívja a TimedEffect ős konstruktorát ( #TimedEffect(timeLeft: int) ), és létrehoz egy példányt az adott lejárati idővel.
     * @param timeLeft az Effect érvényességi ideje
     */
    public TimedProtectingEffect(int timeLeft) {
        super(timeLeft);
        Skeleton.printMethodCall(toString(), "TimedProtectingEffect(int timeLeft)", true, null);
        Skeleton.printMethodCall(toString(), "TimedProtectingEffect(int timeLeft)", false, null);
    }

    /**
     * Mivel a hatás alatt a virológus végig védett,
     * ezért mindig igazzal tér vissza.
     * 
     * @return true
     */
    public boolean resist() {
        Skeleton.printMethodCall(toString(), "resist()", true, Boolean.toString(true));
        Skeleton.printMethodCall(toString(), "resist()", false, Boolean.toString(true));
        return true;
    }

    /**
     * Az osztály nevének visszaadása.
     * @return "TimedProtectingEffect"
     */
    @Override
    public String toString() {
        return "TimedProtectingEffect(" + timeLeft + ")";
    }
}
