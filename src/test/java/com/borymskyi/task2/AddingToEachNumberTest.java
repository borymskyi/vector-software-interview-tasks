package com.borymskyi.task2;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

class AddingToEachNumberTest {

    @Test
    void scanInputNumberAndPrintingNumberByAddingOneToEach() {
        System.setIn(new ByteArrayInputStream("998".getBytes()));
        new AddingToEachNumber().scanInputNumberAndPrintingNumberByAddingOneToEach();

        System.setIn(new ByteArrayInputStream("9555559".getBytes()));
        new AddingToEachNumber().scanInputNumberAndPrintingNumberByAddingOneToEach();

        System.setIn(new ByteArrayInputStream("2147483647".getBytes()));
        new AddingToEachNumber().scanInputNumberAndPrintingNumberByAddingOneToEach();
    }
}