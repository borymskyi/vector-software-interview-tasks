package com.borymskyi.save;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class SaveSudokuValidator {

    public static boolean validRow(int[][] matrix, int row) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[row][i] < 1 || matrix[row][i] > 9) {
                System.out.println("Invalid value");
                return false;
            }
        }
        return true;
    }

    public static boolean validColumn(int[][] matrix, int col) {
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[i][col] < 1 || matrix[i][col] > 9) {
                System.out.println("Invalid value");
                return false;
            }
        }
        return true;
    }

    public static boolean validSubSquares(int[][] matrix) {
        for (int row = 0; row < matrix.length; row+=3) {
            for (int col = 0; col < matrix[0].length; col+=3) {
                if (matrix[row][col] < 1 || matrix[row][col] > 9) {
                    System.out.println("Invalid value");
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean validCount(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            if (!validRow(matrix, i) || !validColumn(matrix, i)) {
                return false;
            }
        }
        if (!validSubSquares(matrix)) {
            return false;
        }

        return true;
    }

    public static void randomFillMassive(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[row][col] = ThreadLocalRandom.current()
                        .nextInt(1, 9);
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] keyBoardFillMatrix(int n) {
        int[][] output = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = new String[n];

            System.out.println("Enter the row the sudoku: ");
            Scanner scan = new Scanner(System.in);
            input = scan.next().trim().split("");
            int getStringLength = input.length;
            if (getStringLength < n || getStringLength > n) {
                System.out.println("- Please enter the row again: ");
            } else {
                break;
            }
            for (int j = 0; j < n; j++) {
                output[i][j] = Integer.parseInt(input[j]);
            }
        }
        return output;
    }

    public static int sumOfRow(int[][] matrix, int rowNum) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[rowNum][i];
        }
        return sum;
    }

    public static int sumOfColumn(int[][] matrix, int columnNum) {
        int sum = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            sum += matrix[i][columnNum];
        }
        return sum;
    }

    public static int pivotSum(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += i;
            return sum;
        }
        return sum;
    }

    public static boolean isCorrectSudoku(int[][] matrix) {
        int pivotSum = pivotSum(matrix.length);

        for (int i = 0; i < matrix.length; i++) {
            int sumOfRow = sumOfRow(matrix, i);
            if (sumOfRow != pivotSum) {
                return false;
            }
        }
        return true;
    }

    public void display(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.println("\t" + matrix[i][j]);
            }
            System.out.println();
        }
    }

    private Scanner getInputWithMessageForUser(String messageForUser) {
        System.out.println(messageForUser);
        return new Scanner(System.in);
    }

    public static void main(String[] args) {
        System.out.println("Enter size sudoku: ");
        Scanner scan = new Scanner(System.in);
        int inputSize = scan.nextInt();

        if (inputSize < 1 || Math.sqrt(inputSize) % 1 != 0) {
            System.out.println("You entered wrong count!\n");
            return;
        }

        int[][] matrix = new int[inputSize][inputSize];

        System.out.println("Fill massive, enter 'true' (random) or 'false' (manual): ");

//        boolean input_statement = Boolean.getBoolean(new Scanner(System.in).next());
        Scanner scan2 = new Scanner(System.in);
        String str = scan2.next().trim();
        boolean input_statement = Boolean.parseBoolean(str);
        if (input_statement) {
            randomFillMassive(matrix);
        } else {
            matrix = keyBoardFillMatrix(inputSize);
        }

        //validation numbers
        if (!validCount(matrix, inputSize)) {
            System.out.println("Count is invalid");
            return;
        }

        //validation sudoku
        if (!isCorrectSudoku(matrix)) {
            System.out.println("Sudoku is not valid");
            return;
        } else {
            System.out.println("Sudoku is valid");
        }

        //Print array
        new SaveSudokuValidator().display(matrix);
    }
}
