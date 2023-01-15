package com.borymskyi.task3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SudokuValidatorTest {
    private final SudokuValidator sudokuValidator = new SudokuValidator();

    @Test
    void testValidateSudokuBySize() {
        boolean resultValidation = this.sudokuValidator
                .validatePreparedSudoku(getSudokuByType(Sudoku.WRONG_BY_SIZE));
        assertFalse(resultValidation);
    }

    @Test
    void testValidateSudokuByRow() {
        boolean resultValidation = this.sudokuValidator
                .validatePreparedSudoku(getSudokuByType(Sudoku.WRONG_BY_ROW));
        assertFalse(resultValidation);
    }

    @Test
    void testValidateSudokuByColumn() {
        boolean resultValidation = this.sudokuValidator
                .validatePreparedSudoku(getSudokuByType(Sudoku.WRONG_BY_COLUMN));
        assertFalse(resultValidation);
    }

    @Test
    void testValidateSudokuBySquare() {
        boolean resultValidation = this.sudokuValidator
                .validatePreparedSudoku(getSudokuByType(Sudoku.WRONG_BY_SQUARE));
        assertFalse(resultValidation);
    }

    @Test
    void testValidateSudokuWith16Size() {
        boolean resultValidation = this.sudokuValidator
                .validatePreparedSudoku(getSudokuByType(Sudoku.WRONG_16));
        assertFalse(resultValidation);
    }

    @Test
    void testValidateCorrectSudokuWith9Size() {
        boolean resultValidation = this.sudokuValidator
                .validatePreparedSudoku(getSudokuByType(Sudoku.CORRECT_9));
        assertTrue(resultValidation);
    }

    @Test
    void testValidateCorrectSudokuWith16Size() {
        boolean resultValidation = this.sudokuValidator
                .validatePreparedSudoku(getSudokuByType(Sudoku.CORRECT_16));
        assertTrue(resultValidation);
    }

    public List<List<Integer>> getSudokuByType(Sudoku type) {
        List<List<Integer>> wrongSudokuBySizeWith9Size = List.of(
                List.of(4, 6, 2, 3, 8, 9, 7, 1, 5),
                List.of(5, 7, 1, 4, 6, 2, 3, 8, 9),
                List.of(9, 3, 8, 5, 7, 1, 4, 6, 2),
                //
                List.of(2, 4, 6, 9, 3, 8, 5, 7, 1, 1),
                List.of(1, 5, 7, 2, 4 ,6, 9, 3, 8),
                List.of(8, 9, 3, 1, 5, 7, 2, 4, 6),
                //
                List.of(6, 2, 4, 8, 9, 3, 1, 5, 7),
                List.of(7, 1, 5, 6, 2, 4, 8, 9, 3),
                List.of(4, 8, 9, 7, 1, 5, 6, 2, 4)
        );
        List<List<Integer>> wrongSudokuByRowWith9Size = List.of(
                List.of(4, 6, 2, 3, 8, 9, 7, 1, 5),
                List.of(5, 7, 1, 4, 6, 2, 3, 8, 9),
                List.of(9, 3, 8, 5, 7, 1, 4, 6, 2),
                //
                List.of(2, 4, 6, 9, 3, 8, 5, 7, 1),
                List.of(1, 5, 7, 2, 4 ,6, 9, 3, 8),
                List.of(8, 9, 3, 1, 5, 7, 2, 4, 6),
                //
                List.of(6, 2, 4, 8, 9, 3, 1, 5, 7),
                List.of(7, 1, 5, 6, 2, 4, 8, 9, 3),
                List.of(4, 8, 9, 7, 1, 5, 6, 2, 4)
        );
        List<List<Integer>> wrongSudokuByColumnWith9Size = List.of(
                List.of(4, 6, 2, 3, 8, 9, 7, 1, 4),
                List.of(5, 7, 1, 4, 6, 2, 3, 8, 9),
                List.of(9, 3, 8, 5, 7, 1, 4, 6, 2),
                //
                List.of(2, 4, 6, 9, 3, 8, 5, 7, 1),
                List.of(1, 5, 7, 2, 4 ,6, 9, 3, 8),
                List.of(8, 9, 3, 1, 5, 7, 2, 4, 6),
                //
                List.of(6, 2, 4, 8, 9, 3, 1, 5, 7),
                List.of(7, 1, 5, 6, 2, 4, 8, 9, 3),
                List.of(3, 8, 9, 7, 1, 5, 6, 2, 4)
        );
        List<List<Integer>> wrongSudokuBySquareWith9Size = List.of(
                List.of(4, 6, 2, 3, 8, 9, 7, 1, 5),
                List.of(5, 4, 1, 4, 6, 2, 3, 8, 9),
                List.of(9, 3, 8, 5, 7, 1, 4, 6, 2),
                //
                List.of(2, 4, 6, 9, 3, 8, 5, 7, 1),
                List.of(1, 5, 7, 2, 4 ,6, 9, 3, 8),
                List.of(8, 9, 3, 1, 5, 7, 2, 4, 6),
                //
                List.of(6, 2, 4, 8, 9, 3, 1, 5, 7),
                List.of(7, 1, 5, 6, 2, 4, 8, 9, 3),
                List.of(3, 8, 9, 7, 1, 5, 6, 2, 4)
        );
        List<List<Integer>> wrongSudoku16size = List.of(
                List.of(1,  1,  3,  4,/**/5,  6,  7,  8,/**/9, 10, 11, 12,/**/13, 14, 15, 16),
                List.of(1, 10, 11, 12,/**/1,  2,  3,  4,/**/13, 14, 15, 16,/**/5,  6,  7,  8),
                List.of(5,  6,  7,  8,/**/13, 14, 15, 16,/**/1,  2,  3,  4,/**/9, 10, 11, 12),
                List.of(13, 14, 15, 16,/**/9, 10, 11, 12,/**/5,  6,  7,  8,/**/1,  2,  3,  4),
                //
                List.of(3,  1,  4,  2,/**/7,  5,  8,  6,/**/11,  9, 14, 10,/**/15, 12, 16, 13),
                List.of(11,  9, 14, 10,/**/3,  1,  4,  2,/**/15, 12, 16, 13,/**/7,  5,  8,  6),
                List.of(7,  5,  8,  6,/**/15, 12, 16, 13,/**/3,  1,  4,  2,/**/11,  9, 14, 10),
                List.of(15, 12, 16, 13,/**/11,  9, 14, 10,/**/7,  5,  8,  6,/**/3,  1,  4,  2),
                //
                List.of(2,  4,  1,  3,/**/6,  8,  5,  7,/**/10, 15,  9, 11,/**/12, 16, 13, 14),
                List.of(10, 15,  9, 11,/**/2,  4,  1,  3,/**/12, 16, 13, 14,/**/6,  8,  5,  7),
                List.of(6,  8,  5,  7,/**/12, 16, 13, 14,/**/2,  4,  1,  3,/**/10, 15,  9, 11),
                List.of(12, 16, 13, 14,/**/10, 15,  9, 11,/**/6,  8,  5,  7,/**/2,  4,  1,  3),
                //
                List.of(4,  3,  2,  1,/**/8,  7,  6,  5,/**/14, 11, 10,  9,/**/16, 13, 12, 15),
                List.of(14, 11, 10, 9,/**/4,  3,  2,  1,/**/16, 13, 12, 15,/**/8,  7,  6,  5),
                List.of(8,  7,  6,  5,/**/16, 13, 12, 15,/**/4,  3,  2,  1,/**/14, 11, 10,  9),
                List.of(16, 13, 12, 15,/**/14, 11, 10,  9,/**/8,  7,  6,  5,/**/4,  3,  2,  1)
        );
        List<List<Integer>> correctSudoku9Size = List.of(
                List.of(4, 6, 2, 3, 8, 9, 7, 1, 5),
                List.of(5, 7, 1, 4, 6, 2, 3, 8, 9),
                List.of(9, 3, 8, 5, 7, 1, 4, 6, 2),
                //
                List.of(2, 4, 6, 9, 3, 8, 5, 7, 1),
                List.of(1, 5, 7, 2, 4 ,6, 9, 3, 8),
                List.of(8, 9, 3, 1, 5, 7, 2, 4, 6),
                //
                List.of(6, 2, 4, 8, 9, 3, 1, 5, 7),
                List.of(7, 1, 5, 6, 2, 4, 8, 9, 3),
                List.of(3, 8, 9, 7, 1, 5, 6, 2, 4)
        );
        List<List<Integer>> correctSudoku16Size = List.of(
                List.of(1,  2,  3,  4,/**/5,  6,  7,  8,/**/9, 10, 11, 12,/**/13, 14, 15, 16),
                List.of(9, 10, 11, 12,/**/1,  2,  3,  4,/**/13, 14, 15, 16,/**/5,  6,  7,  8),
                List.of(5,  6,  7,  8,/**/13, 14, 15, 16,/**/1,  2,  3,  4,/**/9, 10, 11, 12),
                List.of(13, 14, 15, 16,/**/9, 10, 11, 12,/**/5,  6,  7,  8,/**/1,  2,  3,  4),
                //
                List.of(3,  1,  4,  2,/**/7,  5,  8,  6,/**/11,  9, 14, 10,/**/15, 12, 16, 13),
                List.of(11,  9, 14, 10,/**/3,  1,  4,  2,/**/15, 12, 16, 13,/**/7,  5,  8,  6),
                List.of(7,  5,  8,  6,/**/15, 12, 16, 13,/**/3,  1,  4,  2,/**/11,  9, 14, 10),
                List.of(15, 12, 16, 13,/**/11,  9, 14, 10,/**/7,  5,  8,  6,/**/3,  1,  4,  2),
                //
                List.of(2,  4,  1,  3,/**/6,  8,  5,  7,/**/10, 15,  9, 11,/**/12, 16, 13, 14),
                List.of(10, 15,  9, 11,/**/2,  4,  1,  3,/**/12, 16, 13, 14,/**/6,  8,  5,  7),
                List.of(6,  8,  5,  7,/**/12, 16, 13, 14,/**/2,  4,  1,  3,/**/10, 15,  9, 11),
                List.of(12, 16, 13, 14,/**/10, 15,  9, 11,/**/6,  8,  5,  7,/**/2,  4,  1,  3),
                //
                List.of(4,  3,  2,  1,/**/8,  7,  6,  5,/**/14, 11, 10,  9,/**/16, 13, 12, 15),
                List.of(14, 11, 10, 9,/**/4,  3,  2,  1,/**/16, 13, 12, 15,/**/8,  7,  6,  5),
                List.of(8,  7,  6,  5,/**/16, 13, 12, 15,/**/4,  3,  2,  1,/**/14, 11, 10,  9),
                List.of(16, 13, 12, 15,/**/14, 11, 10,  9,/**/8,  7,  6,  5,/**/4,  3,  2,  1)
        );
        switch (type) {
            case WRONG_BY_SIZE:
                return wrongSudokuBySizeWith9Size;
            case WRONG_BY_ROW:
                return wrongSudokuByRowWith9Size;
            case WRONG_BY_COLUMN:
                return wrongSudokuByColumnWith9Size;
            case WRONG_BY_SQUARE:
                return wrongSudokuBySquareWith9Size;
            case WRONG_16:
                return wrongSudoku16size;
            case CORRECT_9:
                return correctSudoku9Size;
            case CORRECT_16:
                return correctSudoku16Size;
            default:
                return wrongSudokuBySizeWith9Size;
        }
    }
}