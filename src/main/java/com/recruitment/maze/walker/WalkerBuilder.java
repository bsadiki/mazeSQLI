package com.recruitment.maze.walker;

import java.util.ArrayList;

public class WalkerBuilder {
    public Walker build(){
        return new Walker(new ArrayList<>(), new ArrayList<>());
    }
}
