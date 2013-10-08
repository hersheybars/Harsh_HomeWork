/*
 * Check if a player is a winner of the bingo game.
 */

public class Bingo {

    // Check if a player win a bingo game or not.
    // input: + The board that the player has (a 2D array)
    // _ + the numbers that have been read. (the array drawn)
    public static boolean bingo(int[][] board, int[] drawn) {
        // the size of the board.
        int size = board.length;

        // This array keeps track of filled array.
        boolean filled[][] = new boolean[size][size];

        // Mark the center of the board as filled.
        if (size % 2 != 0) {
            // note that only boards of odd size have center cells.
            // so we have to check the size of the board first.
            filled[size / 2][size / 2] = true;
        }

        // For each number, find the position of that number on the board.
        // If the number is found on the board, mark the cell containing the
        // number
        // as filled.
        for (int i = 0; i < drawn.length; i++) {
            // Find the number on the board.
            // mark its position on the array 'filled'
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    if (drawn[i] == board[row][col]) {
                        // Hooray! The number is on our board.
                        // mark this new cell as filled.
                        filled[row][col] = true;
                    }
                }
            }
        }

        //+2 credits
        // Check for completed row/ column/diagonal: 
        if (checkRow(filled) || checkCol(filled) || checkDiagonal1(filled)
                || checkDiagonal2(filled)) {
            return true;
        } else {
            return false;
        }

    }

    // Check for completed row.
    // Return true if there is some row of the board that is completed.
    // return false otherwise.
    public static boolean checkRow(boolean filled[][]) {
        for (int row = 0; row < filled.length; row++) {
            boolean isFilled = true;
            for (int col = 0; col < filled.length; col++) {
                if (!filled[row][col]) {
                    // This cell is not filled, hence, the row is not complete.
                    isFilled = false;
                }
            }
            if (isFilled) {
                return true;
            }
        }

        // if this point is reached, there is no completed row.
        return false;
    }

    // Check for completed column.
    // return true if the is some column of the board that is completed.
    // return false otherwise.
    public static boolean checkCol(boolean filled[][]) {
        for (int col = 0; col < filled.length; col++) {
            boolean isFilled = true;
            for (int row = 0; row < filled.length; row++) {
                if (!filled[row][col]) {
                    // This cell is not filled, so this column is not complete.
                    isFilled = false;
                }
            }
            if (isFilled) {
                return true;
            }
        }

        // if this point is reached, there is no completed column.
        return false;
    }

    // Check for completed diagonal - top-left to bottom-right
    // Return true if the diagonal from top-left to bottom-right corners of
    // the board is completed.
    public static boolean checkDiagonal1(boolean filled[][]) {
        int x = 0, y = 0; // Coodiates of a point on the diagonal.
        while (x < filled.length) {
            if (!filled[x][y]) {
                // This cell is not filled, so the diagonal is not complete
                return false;
            }
            // Check the next cell on the diagonal.
            x++;
            y++;
        }
        // All cells on the diagonal is filled.
        return true;
    }

    // Check for completed diagonal - top-right to bottom-left
    // Return true if the diagonal from top-right to bottom-left corners of
    // the board is completed.
    public static boolean checkDiagonal2(boolean filled[][]) {
        int x = 0, y = filled.length - 1; // Coodiates of a point on the
        // diagonal.
        while (x < filled.length) {
            if (!filled[x][y]) {
                // This cell is not filled, so the diagonal is not complete
                return false;
            }
            // Check the next cell on the diagonal.
            x++;
            y--;
        }
        // All cells on the diagonal is filled.
        return true;
    }

}
