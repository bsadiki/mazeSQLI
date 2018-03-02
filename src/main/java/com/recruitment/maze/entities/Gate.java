package com.recruitment.maze.entities;

public abstract class Gate {
    private final String room1;
    private final String room2;
    protected boolean isClosed;
    public Gate(String room1, String room2) {
        this.room1 = room1;
        this.room2 = room2;
        isClosed = false;
    }

    public String getRoom1() {
        return room1;
    }

    public String getRoom2() {
        return room2;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }
}
