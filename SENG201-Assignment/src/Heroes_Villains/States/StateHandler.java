package Heroes_Villains.States;

public class StateHandler {

    public static State state;
    public static State lastState;

    public void setState(State newState) {
        lastState = this.state;
        this.state = newState;
    }

    public static State getState() {
        return state;
    }

    public static State getLastState() {
        return lastState;
    }
}
