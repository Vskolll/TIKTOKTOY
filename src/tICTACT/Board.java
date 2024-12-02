package tICTACT;

public class Board {
    private final char[][] board;

    public Board(int size) {
        this.board = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void print() {
        System.out.print("  ");
        for (int i = 0; i < board.length; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            System.out.print((i + 1) + " ");
            for (char cell : board[i]) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public boolean isFull() {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == ' ') return false;
            }
        }
        return true;
    }

    public boolean setCell(int row, int col, char symbol) {
        if (row >= 0 && row < board.length && col >= 0 && col < board.length && board[row][col] == ' ') {
            board[row][col] = symbol;
            return true;
        }
        return false;
    }

    public boolean checkWin(char symbol, int winCondition) {
        int size = board.length;

        // Check rows, columns, and diagonals
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= size - winCondition; j++) {
                if (checkLine(symbol, i, j, 0, 1, winCondition) || // Rows
                        checkLine(symbol, j, i, 1, 0, winCondition)) { // Columns
                    return true;
                }
            }
        }

        // Check diagonals
        for (int i = 0; i <= size - winCondition; i++) {
            for (int j = 0; j <= size - winCondition; j++) {
                if (checkLine(symbol, i, j, 1, 1, winCondition) || // Main diagonal
                        checkLine(symbol, i, j + winCondition - 1, 1, -1, winCondition)) { // Anti-diagonal
                    return true;
                }
            }
        }

        return false;
    }

    private boolean checkLine(char symbol, int row, int col, int dRow, int dCol, int winCondition) {
        for (int i = 0; i < winCondition; i++) {
            if (board[row + i * dRow][col + i * dCol] != symbol) return false;
        }
        return true;
    }

    public int getSize() {
        return board.length;
    }

    public char[][] getBoard() {
        return board;
    }
}
