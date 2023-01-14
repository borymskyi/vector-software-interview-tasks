package com.borymskyi.task4.impl;

import com.borymskyi.task4.Shape;

import java.util.Objects;

public class CustomShape implements Shape {
    private final double area;

    public CustomShape(double area) {
        this.area = area;
    }

    @Override
    public double getArea() {
        return this.area;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomShape that = (CustomShape) o;
        return Double.compare(that.area, area) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(area);
    }

    @Override
    public String toString() {
        return "CustomShape(" + this.area + ")";
    }
}
