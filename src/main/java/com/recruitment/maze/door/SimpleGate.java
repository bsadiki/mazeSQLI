package com.recruitment.maze.door;

public class SimpleGate extends Gate {
    public SimpleGate(String room1, String room2, boolean isClosed) {
        super(room1, room2, isClosed);
    }

    @Override
    public boolean isSensor() {
        return false;
    }
}
