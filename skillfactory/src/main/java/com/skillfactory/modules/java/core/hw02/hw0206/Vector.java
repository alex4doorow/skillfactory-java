package com.skillfactory.modules.java.core.hw02.hw0206;

public abstract class Vector {
    int x1, y1, z1, x2, y2, z2;

    public Vector(int x1, int y1, int z1, int x2, int y2, int z2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.z1 = z1;
        this.z2 = z2;
    }

    public abstract double getLength();
    public abstract String getVectorCords();
}
