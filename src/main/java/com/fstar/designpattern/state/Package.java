package com.fstar.designpattern.state;

public class Package {
    private State state = new OrderedState();

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void previousState() {
        state.prev(this);
    }

    public void nextState() {
        state.next(this);
    }

    public void printStatus() {
        state.printStatus();
    }
}
