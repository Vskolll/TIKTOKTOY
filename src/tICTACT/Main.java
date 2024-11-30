package tICTACT;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicTacToe game = new TicTacToe();

        System.out.println("Ласкаво просимо до гри Хрестики-Нулики!");
        int gameMode = chooseGameMode(scanner);

        while (true) {
            game.printBoard();

            if (gameMode == 1) { // Гравець проти комп'ютера
                if (game.isPlayerTurn()) {
                    System.out.println("Ваш хід:");
                    game.playerMove(scanner);
                } else {
                    System.out.println("Хід комп'ютера:");
                    game.computerMove();
                }
            } else if (gameMode == 2) { // Гравець проти гравця
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
        scanner.close();
    }

    private static int chooseGameMode(Scanner scanner) {
        int mode;
        while (true) {
            try {
                System.out.println("Оберіть режим гри:");
                System.out.println("1. Гравець проти комп'ютера");
                System.out.println("2. Гравець проти гравця");
                mode = scanner.nextInt();
                if (mode == 1 || mode == 2) break;
                else System.out.println("Будь ласка, оберіть 1 або 2.");
            } catch (Exception e) {
                System.out.println("Помилка вводу! Введіть число 1 або 2.");
                scanner.nextLine(); // Очищення буфера вводу
            }
        }
        return mode;
    }
}
