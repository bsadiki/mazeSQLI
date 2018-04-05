package com.recruitment.maze.rooms;

import com.recruitment.maze.door.Gate;
import com.recruitment.maze.door.factory.GateFactory;

import java.util.ArrayList;
import java.util.HashMap;

public class RoomsBuilder {
    private final GateFactory gateFactory;
    private final HashMap<String, Room> rooms;

    public RoomsBuilder() {
        this.gateFactory = new GateFactory();
        rooms = new HashMap<>();
    }

    public Rooms build(String... doors) {
        for (String door : doors) {
            buildRoomsAndDoor(door);
        }
        return new Rooms(rooms);
    }

    private void buildRoomsAndDoor(String rooms) {
        String gateType = String.valueOf(rooms.charAt(1));
        String roomName1 = String.valueOf(rooms.charAt(0));
        String roomName2 = String.valueOf(rooms.charAt(2));
        Gate gate = gateFactory.createGate(gateType, roomName1, roomName2);
        addGateToRoom(roomName1, gate);
        addGateToRoom(roomName2, gate);
    }

    private Room addGateToRoom(String roomName, Gate gate) {
        Room room = getRoom(roomName);
        room.addGate(gate);
        return room;
    }

    private Room getRoom(String roomName) {
        if (!rooms.containsKey(roomName))
            rooms.put(roomName, new Room(roomName, new ArrayList<>()));
        return rooms.get(roomName);
    }
}
