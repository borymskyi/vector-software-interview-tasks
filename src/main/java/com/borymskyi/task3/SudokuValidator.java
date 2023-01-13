package com.borymskyi.task3;

/**
 * TASK 3
 * <p>This class contains solutions to the third task "Validate Sudoku with size NxN"
 *
 * @author  Dmytrii Borymskyi
 */

public class SudokuValidator {

    /**
     * This method validates the passed sudoku according to the following rules:
     * <ul>
     * <li> Data structure dimension: NxN where N > 1 and √N == integer.
     * <li> ‘Small squares’, for example 3x3, should be √Nx√N.
     * <li> A number in multi-dimensional array may only appear once in a single row,
     *      column or in the ‘Small square’.
     * </ul>

     * @param preparedSudoku
     * @return true if validation was successful otherwise throw {@link com.borymskyi.task3.ValidationNumbersException}
     */
    public boolean validatePreparedSudoku(int[][] preparedSudoku){
        validateSizePassedSudoku(preparedSudoku);
        validateNumbers(preparedSudoku);
        printSudoku(preparedSudoku);
        return true;
    }

    private void printSudoku(int[][] sudoku) {
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku.length; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void validateSizePassedSudoku(int[][] passedSudoku) {
        int size = passedSudoku.length;
        if (size < 1 || Math.sqrt(size) % 1 != 0) {
            throw new IllegalArgumentException(
                    String.format("You entered wrong count: %d", passedSudoku.length));
        }
        for (int i = 0; i < size; i++) {
            if (passedSudoku[i].length > size) {
                throw new IllegalArgumentException(
                        String.format("You entered wrong count: %d", passedSudoku[i].length));
            }
        }
    }

    private void validateNumbers(int[][] sudoku) {
        for (int i = 0; i < sudoku.length; i++) {
            validateRow(sudoku, i);
            validColumn(sudoku, i);
        }
        validateSquares(sudoku);
    }

    private void validateRow(int[][] sudoku, int row) {
        for (int i = 0; i < sudoku.length; i++) {
            if (sudoku[row][i] < 1 || sudoku[row][i] > sudoku.length) {
                throw new ValidationNumbersException(
                        String.format("Invalid value in row: %d", sudoku[row][i]));
            }
            for (int j = i+1; j < sudoku.length; j++) {
                if (sudoku[row][i] == sudoku[row][j]){
                    throw new ValidationNumbersException(
                            String.format("Invalid value in row: %d", sudoku[row][j]));
                }
            }
        }
    }

    private void validColumn(int[][] sudoku, int column) {
        for (int i = 0; i < sudoku[0].length; i++) {
            if (sudoku[i][column] < 1 || sudoku[i][column] > sudoku.length) {
                throw new ValidationNumbersException(
                        String.format("Invalid value in column: %d", sudoku[i][column]));
            }
            for (int j = i+1; j < sudoku.length; j++) {
                if (sudoku[i][column] == sudoku[j][column]) {
                    throw new ValidationNumbersException(
                            String.format("Invalid value in colum: %d", sudoku[i][column]));
                }
            }
        }
    }

    private void validateSquares(int[][] sudoku) {
        int square = (int)Math.round(Math.sqrt(sudoku.length));
        int startRow = 0;
        int endRow = square;

        for (int i = 0; i < square; i++) {
            int startColumn = 0;
            int endColumn = square;
            for (int j = 0; j < square; j++) {
                runOverSquares(sudoku, startRow, endRow, startColumn, endColumn);
                startColumn = startColumn + square;
                endColumn = endColumn + square;
            }
            startRow = startRow + square;
            endRow = endRow + square;
        }
    }

    private void runOverSquares(int[][] sudoku, int startRow, int endRow, int startColumn, int endColumn) {
        int[] saveNumbers = new int[sudoku.length];
        int tempAddNumbers = 0;

        for (int row = startRow; row < endRow; row++) {
            for (int column = startColumn; column < endColumn; column++) {
                saveNumbers[tempAddNumbers] = sudoku[row][column];
                tempAddNumbers++;
            }
        }
        for (int i = 0; i < saveNumbers.length; i++) {
            for (int j = i+1; j < saveNumbers.length; j++) {
                if (saveNumbers[i] == saveNumbers[j]) {
                    throw new ValidationNumbersException(
                            String.format("Invalid value in colum: %d", saveNumbers[i]));
                }
            }
        }
    }
}
