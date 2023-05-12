package projlab;

/**
 * A játék állapotait tároló enum.
 */
public enum GameState {
    WAITING_FOR_MOVE, WAITING_FOR_ACTION, WAITING_FOR_NEXT_TURN, GAME_ENDED;
    /**
     * Állapotgépet valósít meg, megadja a következő statet
     * @return a következő state
     */
    public GameState nextState(){
        switch(this){
            case WAITING_FOR_MOVE:
            {
                return WAITING_FOR_ACTION;
            }
            case WAITING_FOR_ACTION:
            {
                return WAITING_FOR_NEXT_TURN;
            }
            case WAITING_FOR_NEXT_TURN:
            {
                return WAITING_FOR_MOVE;
            }
            case GAME_ENDED:
            {
                return GAME_ENDED;
            }
            default:
            {
                return WAITING_FOR_MOVE;
            }
        }
    }
}
