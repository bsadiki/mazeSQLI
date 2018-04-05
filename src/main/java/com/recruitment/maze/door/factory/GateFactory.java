package com.recruitment.maze.door.factory;

import com.recruitment.maze.door.Gate;
import com.recruitment.maze.door.SensorGate;
import com.recruitment.maze.door.SimpleGate;

import static com.recruitment.maze.config.Configuration.SENSOR_GATE;
import static com.recruitment.maze.config.Configuration.SIMPLE_GATE;

public class GateFactory {
    public Gate createGate(String gateType, String room1, String room2) {
        if (gateType.equals(SIMPLE_GATE))
            return new SimpleGate(room1, room2, Gate.OPENED);
        else if (gateType.equals(SENSOR_GATE))
            return new SensorGate(room1, room2, Gate.OPENED);
        return null;
    }
}
