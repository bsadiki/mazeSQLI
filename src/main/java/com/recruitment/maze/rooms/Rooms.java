package com.recruitment.maze.rooms;

import com.recruitment.maze.door.exceptions.IllegalMoveException;

import java.util.HashMap;

public class Rooms {
    private final HashMap<String, Room> rooms;

    Rooms(HashMap<String, Room> rooms) {
        this.rooms = rooms;
    }

    public Room get(String roomName) throws IllegalMoveException {
        Room room = rooms.get(roomName);
        checkValidRoom(room);
        return rooms.get(roomName);
    }

    private void checkValidRoom(Room room) throws IllegalMoveException {
        if (room == null)
            throw new IllegalMoveException();
    }
}
