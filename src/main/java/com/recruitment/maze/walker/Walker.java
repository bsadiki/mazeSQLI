package com.recruitment.maze.walker;

import com.recruitment.maze.door.Gate;
import com.recruitment.maze.door.exceptions.ClosedDoorException;
import com.recruitment.maze.door.exceptions.DoorAlreadyClosedException;
import com.recruitment.maze.door.exceptions.IllegalMoveException;
import com.recruitment.maze.rooms.Room;

import java.util.List;

import static com.recruitment.maze.config.Configuration.SEPARATOR;

public class Walker {
    private final List<Room> crossedRooms;
    private final List<String> crossedSensorGates;

    Walker(List<Room> crossedRooms, List<String> crossedSensorGates) {
        this.crossedRooms = crossedRooms;
        this.crossedSensorGates = crossedSensorGates;
    }

    public void addRoom(Room room) {
        crossedRooms.add(room);
    }

    public void goToRoom(Room destinationRoom) throws IllegalMoveException, ClosedDoorException {
        Room actualRoom = getActualRoom();
        Gate gate = actualRoom.gateBetween(destinationRoom);
        checkValidGate(gate);
        checkOpenedGate(gate);
        crossedRooms.add(destinationRoom);
        if (gate.isSensor())
            addToSensorGate(actualRoom,destinationRoom);
    }

    private void checkValidGate(Gate gate) throws IllegalMoveException {
        if (gate == null)
            throw new IllegalMoveException();
    }

    private void checkOpenedGate(Gate gate) throws ClosedDoorException {
        if (gate.isClosed())
            throw new ClosedDoorException();
    }


    public void closeLastDoor() throws DoorAlreadyClosedException {
        Gate gate = getActualRoom().gateBetween(getPreviousRoom());
        if (gate.isClosed())
            throw new DoorAlreadyClosedException();
        gate.close();
    }

    private Room getActualRoom() {
        return crossedRooms.get(crossedRooms.size() - 1);
    }

    private Room getPreviousRoom() {
        return crossedRooms.get(crossedRooms.size() - 2);
    }

    private void addToSensorGate(Room actualRoom, Room destinationRoom) {
        crossedSensorGates.add(actualRoom.getName().concat(destinationRoom.getName()));
    }

    public String drawPath() {
        StringBuilder stringBuilder = new StringBuilder();
        crossedSensorGates.forEach(gate -> {
            stringBuilder.append(gate);
            stringBuilder.append(SEPARATOR);
        });
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }
}