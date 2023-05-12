package projlab;

/**
 * A felejtés hatást megvalósító osztály.
 */
public class TimedMemoryLossEffect extends TimedEffect {
    /**
     * Egy paraméteres konstruktor.
     *  Meghívja a TimedEffect ős konstruktorát ( #TimedEffect(timeLeft: int) ),
     *  és létrehoz egy példányt az adott lejárati idővel.
     * 
     * @param timeLeft az Effect érvényességi ideje
     */
    public TimedMemoryLossEffect(int timeLeft) {
        super(timeLeft);
        Skeleton.printMethodCall(toString(), "TimedMemoryLossEffect(int timeLeft)", true, null);
        Skeleton.printMethodCall(toString(), "TimedMemoryLossEffect(int timeLeft)", false, null);
    }

    /**
     * Az osztály nevének visszaadása.
     * @return "TimedMemoryLossEffect"
     */
    @Override
    public String toString() {
        return "TimedMemoryLossEffect(" + timeLeft + ")";
    }
}
