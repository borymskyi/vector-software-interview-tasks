package com.borymskyi.task3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SudokuValidatorTest {
    private final SudokuValidator sudokuValidator = new SudokuValidator();

    @Test
    void testValidateCorrectPreparedSudoku() {
        boolean resultValidation = this.sudokuValidator
                .validatePreparedSudoku(getCorrectSudokuBySize(9));
        assertTrue(resultValidation);
    }

    @Test
    void testValidateWrongPreparedSudoku() {
        ValidationNumbersException thrown = Assertions.assertThrows(ValidationNumbersException.class, () -> {
            this.sudokuValidator.validatePreparedSudoku(getWrongSudokuBySize(9));
        });
        Assertions.assertEquals(ValidationNumbersException.class, thrown.getClass());
    }

    public int[][] getWrongSudokuBySize(int sizeSudoku) {
        int[][] sudoku9size = new int[][]{
                {4, 4, 2, 3, 8, 9, 7, 1, 5},
                {5, 7, 1, 4, 6, 2, 3, 8, 9},
                {9, 3, 8, 5, 7, 1, 4, 6, 2},
                //
                {2, 4, 6, 9, 3, 8, 5, 7, 1},
                {1, 5, 7, 2, 4 ,6, 9, 3, 8},
                {8, 9, 3, 1, 5, 7, 2, 4, 6},
                //
                {6, 2, 4, 8, 9, 3, 1, 5, 7},
                {7, 1, 5, 6, 2, 4, 8, 9, 3},
                {3, 8, 9, 7, 1, 5, 6, 2, 4}
        };

        int[][] sudoku16size = new int[][]{
                {2,  2,  3,  4,/**/5,  6,  7,  8,/**/9, 10, 11, 12,/**/13, 14, 15, 16},
                {9, 10, 11, 12,/**/1,  2,  3,  4,/**/13, 14, 15, 16,/**/5,  6,  7,  8},
                {5,  6,  7,  8,/**/13, 14, 15, 16,/**/1,  2,  3,  4,/**/9, 10, 11, 12},
                {13, 14, 15, 16,/**/9, 10, 11, 12,/**/5,  6,  7,  8,/**/1,  2,  3,  4},
                //
                {3,  1,  4,  2,/**/7,  5,  8,  6,/**/11,  9, 14, 10,/**/15, 12, 16, 13},
                {11,  9, 14, 10,/**/3,  1,  4,  2,/**/15, 12, 16, 13,/**/7,  5,  8,  6},
                {7,  5,  8,  6,/**/15, 12, 16, 13,/**/3,  1,  4,  2,/**/11,  9, 14, 10},
                {15, 12, 16, 13,/**/11,  9, 14, 10,/**/7,  5,  8,  6,/**/3,  1,  4,  2},
                //
                {2,  4,  1,  3,/**/6,  8,  5,  7,/**/10, 15,  9, 11,/**/12, 16, 13, 14},
                {10, 15,  9, 11,/**/2,  4,  1,  3,/**/12, 16, 13, 14,/**/6,  8,  5,  7},
                {6,  8,  5,  7,/**/12, 16, 13, 14,/**/2,  4,  1,  3,/**/10, 15,  9, 11},
                {12, 16, 13, 14,/**/10, 15,  9, 11,/**/6,  8,  5,  7,/**/2,  4,  1,  3},
                //
                {4,  3,  2,  1,/**/8,  7,  6,  5,/**/14, 11, 10,  9,/**/16, 13, 12, 15},
                {14, 11, 10, 9,/**/4,  3,  2,  1,/**/16, 13, 12, 15,/**/8,  7,  6,  5},
                {8,  7,  6,  5,/**/16, 13, 12, 15,/**/4,  3,  2,  1,/**/14, 11, 10,  9},
                {16, 13, 12, 15,/**/14, 11, 10,  9,/**/8,  7,  6,  5,/**/4,  3,  2,  1}
        };
        switch (sizeSudoku) {
            case 16:
                return sudoku16size;
            default:
                return sudoku9size;
        }
    }

    public int[][] getCorrectSudokuBySize(int sizeSudoku) {
        int[][] sudoku9size = new int[][]{
                {4, 6, 2, 3, 8, 9, 7, 1, 5},
                {5, 7, 1, 4, 6, 2, 3, 8, 9},
                {9, 3, 8, 5, 7, 1, 4, 6, 2},
                //
                {2, 4, 6, 9, 3, 8, 5, 7, 1},
                {1, 5, 7, 2, 4 ,6, 9, 3, 8},
                {8, 9, 3, 1, 5, 7, 2, 4, 6},
                //
                {6, 2, 4, 8, 9, 3, 1, 5, 7},
                {7, 1, 5, 6, 2, 4, 8, 9, 3},
                {3, 8, 9, 7, 1, 5, 6, 2, 4}
        };
        int[][] sudoku16size = new int[][]{
                {1,  2,  3,  4,/**/5,  6,  7,  8,/**/9, 10, 11, 12,/**/13, 14, 15, 16},
                {9, 10, 11, 12,/**/1,  2,  3,  4,/**/13, 14, 15, 16,/**/5,  6,  7,  8},
                {5,  6,  7,  8,/**/13, 14, 15, 16,/**/1,  2,  3,  4,/**/9, 10, 11, 12},
                {13, 14, 15, 16,/**/9, 10, 11, 12,/**/5,  6,  7,  8,/**/1,  2,  3,  4},
                //
                {3,  1,  4,  2,/**/7,  5,  8,  6,/**/11,  9, 14, 10,/**/15, 12, 16, 13},
                {11,  9, 14, 10,/**/3,  1,  4,  2,/**/15, 12, 16, 13,/**/7,  5,  8,  6},
                {7,  5,  8,  6,/**/15, 12, 16, 13,/**/3,  1,  4,  2,/**/11,  9, 14, 10},
                {15, 12, 16, 13,/**/11,  9, 14, 10,/**/7,  5,  8,  6,/**/3,  1,  4,  2},
                //
                {2,  4,  1,  3,/**/6,  8,  5,  7,/**/10, 15,  9, 11,/**/12, 16, 13, 14},
                {10, 15,  9, 11,/**/2,  4,  1,  3,/**/12, 16, 13, 14,/**/6,  8,  5,  7},
                {6,  8,  5,  7,/**/12, 16, 13, 14,/**/2,  4,  1,  3,/**/10, 15,  9, 11},
                {12, 16, 13, 14,/**/10, 15,  9, 11,/**/6,  8,  5,  7,/**/2,  4,  1,  3},
                //
                {4,  3,  2,  1,/**/8,  7,  6,  5,/**/14, 11, 10,  9,/**/16, 13, 12, 15},
                {14, 11, 10, 9,/**/4,  3,  2,  1,/**/16, 13, 12, 15,/**/8,  7,  6,  5},
                {8,  7,  6,  5,/**/16, 13, 12, 15,/**/4,  3,  2,  1,/**/14, 11, 10,  9},
                {16, 13, 12, 15,/**/14, 11, 10,  9,/**/8,  7,  6,  5,/**/4,  3,  2,  1}
        };
        switch (sizeSudoku) {
            case 16:
                return sudoku16size;
            default:
                return sudoku9size;
        }
    }
}