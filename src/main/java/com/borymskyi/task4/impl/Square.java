package com.borymskyi.task4.impl;

import com.borymskyi.task4.Shape;

import java.util.Objects;

public class Square implements Shape {
    private final double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return this.side * this.side;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return Double.compare(square.side, side) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(side);
    }

    @Override
    public String toString() {
        return "Square(" + side + ")";
    }
}
