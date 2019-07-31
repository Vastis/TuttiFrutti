package game;

public enum GameState {

    IDLE(0),
    SHUFFLING(1),
    DEALING(2),
    WAITING_FOR_PLAYER(3),
    EXECUTING_ACTION(4),
    STONE_CHECK(5),
    GAME_OVER(6);

    private int id;

    GameState(int id){
        this.id = id;
    }
}
