package com.recruitment.maze.entities;

import com.recruitment.maze.exceptions.ClosedDoorException;
import com.recruitment.maze.exceptions.DoorAlreadyClosedException;
import com.recruitment.maze.exceptions.IllegalMoveException;
import com.recruitment.maze.factory.GateFactory;


import java.util.HashMap;
import java.util.List;

import static com.recruitment.maze.config.Configuration.SEPARATOR;

public class Maze {
    HashMap<String,Room> rooms;
    Walker walker;
    GateFactory gateFactory = new GateFactory();
    public Maze(String... doors) {
        rooms = new HashMap<>();
        for (String s : doors) {
            buildRoomsAndDoor(s);
        }
    }

    private void buildRoomsAndDoor(String s) {
        String gateType = String.valueOf(s.charAt(1));

        String roomName1 = String.valueOf(s.charAt(0));
        String roomName2 = String.valueOf(s.charAt(2));
        Room[] buildedRooms = addRooms(roomName1, roomName2 );
        Gate gate = gateFactory.createGate(gateType,buildedRooms[0].getName(),buildedRooms[1].getName());
        addGateToRooms(buildedRooms, gate);
    }

    private void addGateToRooms(Room[] buildedRooms, Gate gate) {
        buildedRooms[0].addGate(gate);
        buildedRooms[1].addGate(gate);
    }

    private Room[] addRooms(String roomName1, String roomName2) {
        Room room1 = addRoom(roomName1);
        Room room2 = addRoom(roomName2);
        Room[] buildedRooms = new Room[2];
        buildedRooms[0] = room1;
        buildedRooms[1] = room2;
        return buildedRooms;
    }

    private Room addRoom(String roomName) {
        if (!rooms.containsKey(roomName))
            rooms.put(roomName,new Room(roomName));
        return rooms.get(roomName);
    }

    public void popIn(String doorName) {
        walker = new Walker(rooms.get(doorName));
    }

    public void walkTo(String roomName) throws IllegalMoveException, ClosedDoorException {
        Room room = rooms.get(roomName);
        if (room==null)
            throw new IllegalMoveException();
        walker.goToRoom(room);
    }

    public void closeLastDoor()  throws DoorAlreadyClosedException {
        walker.closeLastDoor();
    }

    public String readSensors() {
        List<Gate> sensorGates = walker.getSensorGates();
        StringBuilder stringBuilder = new StringBuilder();
        sensorGates.forEach(gate -> {
            stringBuilder.append(gate.getRoom1());
            stringBuilder.append(gate.getRoom2());
            stringBuilder.append(SEPARATOR);
        });
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();
    }
}
