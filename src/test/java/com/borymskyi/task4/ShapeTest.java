package com.borymskyi.task4;

import com.borymskyi.task4.impl.*;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShapeTest {

    @Test
    public void testGetArea() {
        List<Shape> expectedListShapesSortedByArea = List.of(
                new CustomShape(2.5), new Rectangle(2.5, 3.5), new Square(3.5),
                new CustomShape(15.5), new Triangle(4.5, 9.5), new Triangle(5.5, 10.5),
                new Rectangle(4.5, 10.5), new Circle(4.5), new Square(10.5),
                new Circle(18.5));
        List<Shape> shapes = List.of(
                new Circle(4.5), new Circle(18.5), new Square(10.5), new Square(3.5),
                new Rectangle(4.5, 10.5), new Rectangle(2.5, 3.5),
                new Triangle(5.5, 10.5), new Triangle(4.5, 9.5),
                new CustomShape(2.5), new CustomShape(15.5)
        );
        assertEquals(expectedListShapesSortedByArea, shapes.stream()
                .sorted(Comparator.comparing(Shape::getArea))
                .toList());
    }
}