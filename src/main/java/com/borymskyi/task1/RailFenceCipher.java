package com.borymskyi.task1;

/**
 * TASK 1
 * <p>This class implements two methods to encode and decode a string using the Rail Fence Cipher.
 *
 * @author  Dmytrii Borymskyi
 */

public class RailFenceCipher {

    public String encodingString(int rails, String text) {
        StringBuilder encryptedStr = new StringBuilder();
        int column = text.length();
        char[][] matrixRailSystem = new char[rails][column];

        fillTargetWithPassedArgument(matrixRailSystem, text, rails, column);

        //encrypting
        for (int i = 0; i < rails; i++) {
            for (int k = 0; k < column; k++) {
                if(matrixRailSystem[i][k] != 0) {
                    encryptedStr.append(matrixRailSystem[i][k]);
                }
            }
        }
        return encryptedStr.toString();
    }

    public String decodingString(int rails, String text) {
        StringBuilder decryptedStr = new StringBuilder();
        int column = text.length();
        char[][] matrixRailSystem = new char[rails][column];

        fillTargetWithPassedArgument(matrixRailSystem, 'x', rails, column);

        //decrypting
        for (int i = 0, i2 = 0; i < rails; i++) {
            for (int k = 0; k < column; k++) {
                if (matrixRailSystem[i][k] == 'x' && i2 < column) {
                    matrixRailSystem[i][k] = text.charAt(i2++);
                }
            }
        }

        fillTargetWithPassedArgument(decryptedStr, matrixRailSystem, rails, column);

        return decryptedStr.toString();
    }

    private void fillTargetWithPassedArgument(StringBuilder target, char[][] argument, int rails, int column) {
        boolean bottomCheck = false;
        int bottomCounter = 0;
        for (int i = 0; i < column; i++) {
            if (bottomCounter == 0 || bottomCounter == rails - 1) {
                bottomCheck = !bottomCheck;
            }
            target.append(argument[bottomCounter][i]);

            if (bottomCheck) {
                bottomCounter++;
            } else {
                bottomCounter--;
            }
        }
    }

    private void fillTargetWithPassedArgument(char[][] target, String argument, int rails, int column) {
        boolean bottomCheck = false;
        int bottomCounter = 0;

        for (int i = 0; i < column; i++) {
            if (bottomCounter == 0 || bottomCounter == rails - 1) {
                bottomCheck = !bottomCheck;
            }
            target[bottomCounter][i] = argument.charAt(i);

            if (bottomCheck) {
                bottomCounter++;
            } else {
                bottomCounter--;
            }
        }
    }

    private void fillTargetWithPassedArgument(char[][] target, char argument, int rails, int column) {
        boolean bottomCheck = false;
        int bottomCounter = 0;

        for (int i = 0; i < column; i++) {
            if (bottomCounter == 0 || bottomCounter == rails - 1) {
                bottomCheck =! bottomCheck;
            }
            target[bottomCounter][i] = argument;

            if (bottomCheck) {
                bottomCounter++;
            } else {
                bottomCounter--;
            }
        }
    }

}
