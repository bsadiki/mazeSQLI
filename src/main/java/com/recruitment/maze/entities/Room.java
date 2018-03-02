package com.recruitment.maze.entities;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private List<Gate> gates;
    private String name;

    public Room(String name) {
        this.name = name;
        gates=new ArrayList<>();
    }

    @Override
    public boolean equals(Object obj) {
        return (this.name.equals(((Room) obj).getName()));
    }

    public String getName() {
        return name;
    }
    public void addGate(Gate gate){
        gates.add(gate);
    }
    public Gate gateBetweenOtherRoom(Room room){
        for (Gate gate : gates){
            if (isTheFirstRoom(this, gate)){
                if (isTheSecondRoom(room, gate))
                    return gate;
            }
            else
                if (isTheFirstRoom(room, gate))
                    return gate;
        }
        return null;
    }

    private boolean isTheFirstRoom(Room room, Gate gate) {
        return gate.getRoom1().equals(room.getName());
    }

    private boolean isTheSecondRoom(Room room, Gate gate) {
        return gate.getRoom2().equals(room.getName());
    }
}
