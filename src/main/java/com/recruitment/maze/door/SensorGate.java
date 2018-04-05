package com.recruitment.maze.door;

public class SensorGate extends Gate {
    public SensorGate(String room1, String room2, boolean isClosed) {
        super(room1, room2, isClosed);
    }

    @Override
    public boolean isSensor() {
        return true;
    }
}
