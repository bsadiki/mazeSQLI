package com.recruitment.maze;

import com.recruitment.maze.door.RoomsBuilder;
import com.recruitment.maze.walker.Walker;
import com.recruitment.maze.walker.WalkerBuilder;
import com.recruitment.maze.door.exceptions.ClosedDoorException;
import com.recruitment.maze.door.exceptions.DoorAlreadyClosedException;
import com.recruitment.maze.door.exceptions.IllegalMoveException;
import com.recruitment.maze.room.Room;

import java.util.HashMap;

public class Maze {
    private final HashMap<String, Room> rooms;
    private Walker walker;

    public Maze(String... doors) {
        this(new RoomsBuilder().build(doors), new WalkerBuilder().build());
    }

    public Maze(HashMap<String, Room> rooms, Walker walker) {
        this.rooms = rooms;
        this.walker = walker;
    }

    public void popIn(String doorName) {
        walker.addRoom(rooms.get(doorName));
    }

    public void walkTo(String roomName) throws IllegalMoveException, ClosedDoorException {
        Room room = rooms.get(roomName);
        checkValidRoom(room);
        walker.goToRoom(room);
    }

    private void checkValidRoom(Room room) throws IllegalMoveException {
        if (room == null)
            throw new IllegalMoveException();
    }

    public void closeLastDoor() throws DoorAlreadyClosedException {
        walker.closeLastDoor();
    }

    public String readSensors() {
        return walker.drawPath();
    }
}
