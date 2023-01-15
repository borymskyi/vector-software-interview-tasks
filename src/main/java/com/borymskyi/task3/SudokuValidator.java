package com.borymskyi.task3;

import java.util.List;

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
     * @return true if validation was successful otherwise false.
     */
    public boolean validatePreparedSudoku(List<List<Integer>> preparedSudoku){
        try {
            validateSizePassedSudoku(preparedSudoku);
            validateNumbers(preparedSudoku);
        } catch (ValidationNumbersException e) {
            System.err.println(". . . ." + e.getMessage() + ". . . .");
            return false;
        }
        return true;
    }

    private void validateSizePassedSudoku(List<List<Integer>> preparedSudoku) {
        int size = preparedSudoku.size();
        if (size < 1 || Math.sqrt(size) % 1 != 0) {
            throw new ValidationNumbersException(
                    String.format("You entered wrong count: %d", preparedSudoku.size()));
        }
        for (int i = 0; i < size; i++) {
            if (preparedSudoku.get(i).size() > size) {
                throw new ValidationNumbersException(
                        String.format("You entered wrong count: %d", preparedSudoku.get(i).size()));
            }
        }
    }

    private void validateNumbers(List<List<Integer>> preparedSudoku) {
        for (int i = 0; i < preparedSudoku.size(); i++) {
            validateRow(preparedSudoku, i);
            validColumn(preparedSudoku, i);
        }
        validateSquares(preparedSudoku);
    }

    private void validateRow(List<List<Integer>> preparedSudoku, int row) {
        for (int i = 0; i < preparedSudoku.size(); i++) {
            if (preparedSudoku.get(row).get(i) < 1 || preparedSudoku.get(row).get(i) > preparedSudoku.size()) {
                throw new ValidationNumbersException(
                        String.format("Invalid value in row: %d", preparedSudoku.get(row).get(i)));
            }
            for (int j = i+1; j < preparedSudoku.size(); j++) {
                if (preparedSudoku.get(row).get(i).equals(preparedSudoku.get(row).get(j))){
                    throw new ValidationNumbersException(
                            String.format("Invalid value in row: %d", preparedSudoku.get(row).get(i)));
                }
            }
        }
    }

    private void validColumn(List<List<Integer>> preparedSudoku, int column) {
        for (int i = 0; i < preparedSudoku.get(0).size(); i++) {
            if (preparedSudoku.get(i).get(column) < 1 || preparedSudoku.get(i).get(column) > preparedSudoku.size()) {
                throw new ValidationNumbersException(
                        String.format("Invalid value in column: %d", preparedSudoku.get(i).get(column)));
            }
            for (int j = i+1; j < preparedSudoku.size(); j++) {
                if (preparedSudoku.get(i).get(column).equals(preparedSudoku.get(j).get(column))) {
                    throw new ValidationNumbersException(
                            String.format("Invalid value in colum: %d", preparedSudoku.get(i).get(column)));
                }
            }
        }
    }

    private void validateSquares(List<List<Integer>> preparedSudoku) {
        int square = (int)Math.round(Math.sqrt(preparedSudoku.size()));
        int startRow = 0;
        int endRow = square;

        for (int i = 0; i < square; i++) {
            int startColumn = 0;
            int endColumn = square;
            for (int j = 0; j < square; j++) {
                runOverSquares(preparedSudoku, startRow, endRow, startColumn, endColumn);
                startColumn = startColumn + square;
                endColumn = endColumn + square;
            }
            startRow = startRow + square;
            endRow = endRow + square;
        }
    }

    private void runOverSquares(List<List<Integer>> preparedSudoku, int startRow, int endRow, int startColumn, int endColumn) {
        int[] saveNumbers = new int[preparedSudoku.size()];
        int tempAddNumbers = 0;

        for (int row = startRow; row < endRow; row++) {
            for (int column = startColumn; column < endColumn; column++) {
                saveNumbers[tempAddNumbers] = preparedSudoku.get(row).get(column);
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
