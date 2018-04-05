package com.recruitment.maze.room;

import com.recruitment.maze.door.Gate;

import java.util.List;

public class Room {
    private final String name;
    private final List<Gate> gates;


    public Room(String name, List<Gate> gates) {
        this.gates = gates;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        return (this.name.equals(((Room) obj).name));
    }

    public String getName() {
        return name;
    }

    public void addGate(Gate gate) {
        gates.add(gate);
    }

    public Gate gateBetweenOtherRoom(Room room) {
        for (Gate gate : gates) {
            if (gate.betweenRooms(this.name, room.name))
                return gate;
        }
        return null;
    }
}
