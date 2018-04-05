package com.recruitment.maze.door;

public abstract class Gate {
    public static final boolean OPENED = false;
    public static final boolean CLOSED = true;
    private final String room1;
    private final String room2;
    private boolean isClosed;

    public Gate(String room1, String room2, boolean isClosed) {
        this.room1 = room1;
        this.room2 = room2;
        this.isClosed = isClosed;
    }

    public abstract boolean isSensor();

    public boolean isClosed() {
        return isClosed;
    }

    public void close() {
        isClosed = CLOSED;
    }

    public boolean betweenRooms(String room1, String room2) {
        return (this.room1.equals(room1) && this.room2.equals(room2)) || (this.room1.equals(room2) && this.room2.equals(room1));
    }
}
