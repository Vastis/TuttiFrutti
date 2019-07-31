package game;

public enum AppState {
    IDLE(0),
    INIT(1),
    RUNNING(2),
    STOPPED(3),
    RESTARTED(4);

    private int id;

    AppState(int id){
        this.id = id;
    }
}
