package projlab;

/**
 *  A lejárati idővel rendelkező hatásokat összegyűjtő absztrakt osztály. 
 * Van egy lejárati ideje (timeLeft). Lehet rajta jelezni az idő múlását, és visszajelez, 
 * ha az ideje lejárt (timePasses(): boolean).
 */
public abstract class TimedEffect extends Effect {
    protected int timeLeft;

    /**
     * Idő telése.
     * Minden hívásra csökkenti a timeLeft-et.
     * @return true, ha a hatódiő lejárt, egyébként false.
     */
    @Override
    public boolean timePasses() {
        --timeLeft;
        return timeLeft <= 0;
    }

    /**
     * Egyparaméteres konstruktor.
     *  ‘protected’ konstruktor, létrehozza a TimedEffect-et az kapott lejárati idővel
     * @param timeLeft az Effect érvényességi ideje
     */
    protected TimedEffect(int timeLeft) {
        this.timeLeft = timeLeft;
    }

}
