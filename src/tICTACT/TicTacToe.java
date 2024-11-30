package tICTACT;

import java.util.Scanner;

public class TicTacToe {
    private final char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };
    private final char PLAYER1 = 'X';
    private final char PLAYER2 = 'O';
    private boolean isPlayerTurn = true;

    public void printBoard() {
        System.out.println("  1 2 3");
        for (int i = 0; i < board.length; i++) {
            System.out.print((i + 1) + " ");
            for (char cell : board[i]) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public boolean isBoardFull() {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == ' ') return false;
            }
        }
        return true;
    }

    public void playerMove(Scanner scanner) {
        int row, col;
        while (true) {
            try {
                System.out.print("Введіть рядок (1-3): ");
                row = scanner.nextInt() - 1;
                System.out.print("Введіть стовпець (1-3): ");
                col = scanner.nextInt() - 1;

                char currentPlayer = isPlayerTurn ? PLAYER1 : PLAYER2;
                if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                    board[row][col] = currentPlayer;
                    break;
                } else {
                    System.out.println("Некоректний хід, спробуйте ще раз.");
                }
            } catch (Exception e) {
                System.out.println("Помилка вводу! Спробуйте ще раз.");
                scanner.nextLine();
            }
        }
    }

    public void computerMove() {
        int[] bestMove = Minimax.findBestMove(board, PLAYER2, PLAYER1);
        board[bestMove[0]][bestMove[1]] = PLAYER2;
    }

    public boolean checkWin() {
        return checkWinFor(PLAYER1) || checkWinFor(PLAYER2);
    }

    public String getWinnerMessage() {
        if (checkWinFor(PLAYER1)) return "Перший гравець (X) переміг!";
        if (checkWinFor(PLAYER2)) return isPlayerTurn ? "Комп'ютер (O) переміг!" : "Другий гравець (O) переміг!";
        return "Нічия!";
    }

    private boolean checkWinFor(char symbol) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) return true;
            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol) return true;
        }
        return board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol
                || board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol;
    }

    public boolean isPlayerTurn() {
        return isPlayerTurn;
    }

    public void switchTurn() {
        isPlayerTurn = !isPlayerTurn;
    }
}
