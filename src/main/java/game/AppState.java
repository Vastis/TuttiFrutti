package game;

public enum AppState {
    IDLE(0),
    INIT(1),
    RUNNING(2),
    /*PAUSED(3),
    RESUMED(4),*/
    STOPPED(5),
    RESTARTED(6);

    private int id;

    AppState(int id){
        this.id = id;
    }
}
