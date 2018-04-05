package com.recruitment.maze;

import com.recruitment.maze.door.exceptions.ClosedDoorException;
import com.recruitment.maze.door.exceptions.DoorAlreadyClosedException;
import com.recruitment.maze.door.exceptions.IllegalMoveException;
import com.recruitment.maze.rooms.Room;
import com.recruitment.maze.rooms.Rooms;
import com.recruitment.maze.rooms.RoomsBuilder;
import com.recruitment.maze.walker.Walker;
import com.recruitment.maze.walker.WalkerBuilder;

public class Maze {
    private final Rooms rooms;
    private final Walker walker;

    public Maze(String... doors) {
        this(new RoomsBuilder().build(doors), new WalkerBuilder().build());
    }

    public Maze(Rooms rooms, Walker walker) {
        this.rooms = rooms;
        this.walker = walker;
    }

    public void popIn(String roomName) throws IllegalMoveException {
        walker.addRoom(rooms.get(roomName));
    }

    public void walkTo(String roomName) throws IllegalMoveException, ClosedDoorException {
        Room room = rooms.get(roomName);
        walker.goToRoom(room);
    }


    public void closeLastDoor() throws DoorAlreadyClosedException {
        walker.closeLastDoor();
    }

    public String readSensors() {
        return walker.drawPath();
    }
}
