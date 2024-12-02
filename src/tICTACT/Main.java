package tICTACT;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ласкаво просимо до гри Хрестики-Нулики!");

        int size = chooseBoardSize(scanner);
        int gameMode = chooseGameMode(scanner);

        GameController controller = new GameController(size, gameMode);
        controller.startGame(scanner);

        scanner.close();
    }

    private static int chooseBoardSize(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Оберіть розмір поля:");
                System.out.println("1. Стандартне поле 3x3");
                System.out.println("2. Велике поле 15x15");
                int choice = scanner.nextInt();
                if (choice == 1) return 3;
                if (choice == 2) return 15;
                System.out.println("Будь ласка, оберіть 1 або 2.");
            } catch (Exception e) {
                System.out.println("Помилка вводу! Спробуйте ще раз.");
                scanner.nextLine();
            }
        }
    }

    private static int chooseGameMode(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Оберіть режим гри:");
                System.out.println("1. Гравець проти комп'ютера");
                System.out.println("2. Гравець проти гравця");
                int mode = scanner.nextInt();
                if (mode == 1 || mode == 2) return mode;
                System.out.println("Будь ласка, оберіть 1 або 2.");
            } catch (Exception e) {
                System.out.println("Помилка вводу! Введіть число 1 або 2.");
                scanner.nextLine();
            }
        }
    }
}
