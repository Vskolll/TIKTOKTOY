package tICTACT;

import java.util.Scanner;

public class TicTacToe {
    private final Board board;
    private final char PLAYER1 = 'X';
    private final char PLAYER2 = 'O';
    private final int winCondition;
    private boolean isPlayerTurn = true;

    public TicTacToe(int size) {
        this.board = new Board(size);
        this.winCondition = size == 15 ? 5 : 3;
    }

    public void printBoard() {
        board.print();
    }

    public boolean isBoardFull() {
        return board.isFull();
    }

    public void playerMove(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Введіть рядок (1-" + board.getSize() + "): ");
                int row = scanner.nextInt() - 1;
                System.out.print("Введіть стовпець (1-" + board.getSize() + "): ");
                int col = scanner.nextInt() - 1;

                if (board.setCell(row, col, getCurrentPlayer())) break;
                else System.out.println("Некоректний хід, спробуйте ще раз.");
            } catch (Exception e) {
                System.out.println("Помилка вводу! Спробуйте ще раз.");
                scanner.nextLine();
            }
        }
    }

    public void computerMove() {
        int[] bestMove = Minimax.findBestMove(board.getBoard(), PLAYER2, PLAYER1);
        board.setCell(bestMove[0], bestMove[1], PLAYER2);
    }

    public boolean checkWin() {
        return board.checkWin(getCurrentPlayer(), winCondition);
    }

    public String getWinnerMessage() {
        return isPlayerTurn ? "Перший гравець (X) переміг!" : "Другий гравець (O) переміг!";
    }

    public boolean isPlayerTurn() {
        return isPlayerTurn;
    }

    public void switchTurn() {
        isPlayerTurn = !isPlayerTurn;
    }

    private char getCurrentPlayer() {
        return isPlayerTurn ? PLAYER1 : PLAYER2;
    }
}
