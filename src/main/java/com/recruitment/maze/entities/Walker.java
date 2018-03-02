package com.recruitment.maze.entities;

import com.recruitment.maze.exceptions.ClosedDoorException;
import com.recruitment.maze.exceptions.DoorAlreadyClosedException;
import com.recruitment.maze.exceptions.IllegalMoveException;

import java.util.ArrayList;
import java.util.List;

public class Walker {
    private List<Room> crossedRooms;
    private List<Gate> sensorGates;
    public Walker(Room room) {
        crossedRooms = new ArrayList<>();
        sensorGates = new ArrayList<>();
        crossedRooms.add(room);
    }

    public void goToRoom(Room room) throws IllegalMoveException, ClosedDoorException{
        Room actualRoom = crossedRooms.get(crossedRooms.size() - 1);
        Gate gate = actualRoom.gateBetweenOtherRoom(room);
        if (gate == null)
            throw new IllegalMoveException();
        if (gate.isClosed())
            throw new ClosedDoorException();
        crossedRooms.add(room);
        if (gate instanceof SensorGate)
            addToSensorGate();
    }

    public void closeLastDoor() throws DoorAlreadyClosedException {
        Room actualRoom = crossedRooms.get(crossedRooms.size() - 1);
        Gate gate = actualRoom.gateBetweenOtherRoom(crossedRooms.get(crossedRooms.size() - 2));
        if (gate.isClosed())
            throw new DoorAlreadyClosedException();
        gate.setClosed(true);
    }
    void addToSensorGate(){
        Room room1 = crossedRooms.get(crossedRooms.size() - 2);
        Room room2 = crossedRooms.get(crossedRooms.size() - 1);
        Gate sensorGate = new SensorGate(room1.getName(),room2.getName());
        sensorGates.add(sensorGate);
    }

    public List<Gate> getSensorGates() {
        return sensorGates;
    }
}
