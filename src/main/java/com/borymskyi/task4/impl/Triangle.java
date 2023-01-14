package com.borymskyi.task4.impl;

import com.borymskyi.task4.Shape;

import java.util.Objects;

public class Triangle implements Shape {
    private final double base;
    private final double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double getArea() {
        return this.base * this.height / 2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.base, base) == 0 && Double.compare(triangle.height, height) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(base, height);
    }

    @Override
    public String toString() {
        return "Triangle(" + this.base + " " + this.height + ")";
    }
}
