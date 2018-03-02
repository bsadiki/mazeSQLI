package com.recruitment.maze.factory;

import com.recruitment.maze.entities.Gate;
import com.recruitment.maze.entities.Room;
import com.recruitment.maze.entities.SensorGate;
import com.recruitment.maze.entities.SimpleGate;

import static com.recruitment.maze.config.Configuration.SIMPLE_GATE;
import static com.recruitment.maze.config.Configuration.SENSOR_GATE;

public class GateFactory {
    public Gate createGate(String gateTpe, String room1, String room2){
        if (gateTpe.equals(SIMPLE_GATE))
            return new SimpleGate(room1,room2);
        else if (gateTpe.equals(SENSOR_GATE))
        return new SensorGate(room1,room2);
        return null;
    }
}
