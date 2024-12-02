package tICTACT;

import java.util.Scanner;

public class GameController {
    private final TicTacToe game;
    private final int gameMode;

    public GameController(int size, int gameMode) {
        this.game = new TicTacToe(size);
        this.gameMode = gameMode;
    }

    public void startGame(Scanner scanner) {
        while (true) {
            game.printBoard();

            if (gameMode == 1) { // Игрок против компьютера
                if (game.isPlayerTurn()) {
                    System.out.println("Ваш хід:");
                    game.playerMove(scanner);
                } else {
                    System.out.println("Хід комп'ютера:");
                    game.computerMove();
                }
            } else { // Игрок против игрока
                System.out.println(game.isPlayerTurn() ? "Хід першого гравця (X):" : "Хід другого гравця (O):");
                game.playerMove(scanner);
            }

            if (game.checkWin()) {
                game.printBoard();
                System.out.println(game.getWinnerMessage());
                break;
            }

            if (game.isBoardFull()) {
                game.printBoard();
                System.out.println("Нічия!");
                break;
            }

            game.switchTurn();
        }
    }
}
