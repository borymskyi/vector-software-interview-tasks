package com.borymskyi.task2;

import java.util.Scanner;

/**
 * TASK 2
 * <p>This class contains solutions to the second problem "Print a new number by adding one to each of its digit"
 *
 * @author  Dmytrii Borymskyi
 */

public class AddingToEachNumber {

    public static void main(String[] args) {
        System.out.println(new AddingToEachNumber().scanInputNumberAndPrintingNumberByAddingOneToEach());
    }

    /**
     * The method that accepts the number from the user and then adds 1 to each digit
     * without using the possibility of {@link java.lang.String}. For example, 998 transforms in 10109
     *
     * @return int as a result of adding 1 to each digit of the user number.
     */
    public int scanInputNumberAndPrintingNumberByAddingOneToEach() {
        var adding = -1;
        int initialNumber = scanInputIntWithMessageForUser("Enter initial number: ");
        return addOneToEachNumber(adding, initialNumber);
    }

    private int scanInputIntWithMessageForUser(String messageForTheUser) {
        Scanner scan = new Scanner(System.in);
        System.out.print(messageForTheUser);
        return scan.nextInt();
    }

    private int addOneToEachNumber(int adding, int initialNumber) {
        int result = 0;
        var digits = (int) (Math.log(initialNumber) / Math.log(10));
        for (int i = 0; i <= digits; i++ ) {
            var digit = (int) ((initialNumber / (int) Math.pow(10, i))) % 10;
            digit++;
            adding++;
            result += Math.pow(10, adding) * digit;
            if (digit == 10) adding++;
        }
        return result;
    }
}
