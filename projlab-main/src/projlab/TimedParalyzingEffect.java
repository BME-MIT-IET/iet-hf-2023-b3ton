package projlab;

/**
 * A bénultság hatást megvalósító osztály.
 */
public class TimedParalyzingEffect extends TimedEffect {
    /**
     * Egyparaméteres konstruktor. Létrehoz egy példányt az adott lejárati idővel.
     * Meghívja a TimedEffect ős konstruktorát ( #TimedEffect(timeLeft: int) ), és létrehoz egy példányt az adott lejárati idővel.
     * @param timeLeft az Effect érvényességi ideje
     */
    public TimedParalyzingEffect(int timeLeft) {
        super(timeLeft);
        Skeleton.printMethodCall(toString(), "TimedParalyzingEffect(int timeLeft)", true, null);
        Skeleton.printMethodCall(toString(), "TimedParalyzingEffect(int timeLeft)", false, null);
    }

    /**
     * Mivel a hatás alatt a virológus végig bénult,
     * ezért mindig igazzal tér vissza.
     * 
     * @return true
     */
    @Override
    public boolean paralyzed() {
        Skeleton.printMethodCall(toString(), "paralyzed()", true, Boolean.toString(true));
        Skeleton.printMethodCall(toString(), "paralyzed()", false, Boolean.toString(true));
        return true;
    }

    /**
     * Az osztály nevének visszaadása.
     * @return "TimedParalyzingEffect"
     */
    @Override
    public String toString() {
        return "TimedParalyzingEffect(" + timeLeft + ")";
    }
}
