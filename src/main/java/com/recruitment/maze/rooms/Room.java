package com.recruitment.maze.rooms;

import com.recruitment.maze.door.Gate;

import java.util.List;

public class Room {
    private final String name;
    private final List<Gate> gates;


    Room(String name, List<Gate> gates) {
        this.gates = gates;
        this.name = name;
    }

    void addGate(Gate gate) {
        gates.add(gate);
    }

    public Gate gateBetween(Room room) {
        for (Gate gate : gates) {
            if (gate.betweenRooms(this.name, room.name))
                return gate;
        }
        return null;
    }

    public String getName() {
        return name;
    }

}
