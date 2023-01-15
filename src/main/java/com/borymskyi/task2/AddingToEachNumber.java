package com.borymskyi.task2;

import java.util.Scanner;

/**
 * TASK 2
 * <p>This class contains solutions to the second task "Print a new number by adding one to each of its digit"
 *
 * @author  Dmytrii Borymskyi
 */

public class AddingToEachNumber {
    
    //Make sure you don’t transfer a number greater than 2147483647 because you are overwhelmed with int.
    public void scanInputNumberAndPrintingNumberByAddingOneToEach() {
        int number = 0;
        int sizeNumber = 0;

        number = getInputNumber();
        sizeNumber = getSizeNumber(number, sizeNumber);

        int[] result = new int[sizeNumber];
        splitNumberByDigitsInArray(number, sizeNumber, result);

        System.out.println("Your number by adding one to each: ");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + 1);
        }
    }

    private int getInputNumber() {
        int userInputInteger = 0;
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter any number: \n");
            userInputInteger = sc.nextInt();
        } catch (RuntimeException e) {
            System.err.println("You entered incorrect data!");
        }
        return userInputInteger;
    }

    private int getSizeNumber(int number, int sizeNumber) {
        int temp = number;
        while(temp > 0) {
            temp = temp / 10;
            sizeNumber++;
        }
        return sizeNumber;
    }

    private void splitNumberByDigitsInArray(int number, int sizeNumber, int[] result) {
        int temp2 = sizeNumber -1;
        for (int i = 0; i < sizeNumber; i++) {
            result[i] = (number / (int)(Math.pow(10, temp2)) % 10);
            temp2--;
        }
    }
}
