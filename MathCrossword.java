import java.util.Random;

public class MathCrossword {
    private static final Random random = new Random();
    private static final char[] OPERATIONS = {'+', '-', '*', '/'};

    public static void main(String[] args) {
        int N = 5; // Количество строк
        int M = 5; // Количество колонок
        String[][] crossword = new String[N][M];
        initializeCrossword(crossword, N, M);
        generateCrossword(crossword, N, M);
        printCrossword(crossword, N, M);
    }

    private static void initializeCrossword(String[][] crossword, int N, int M) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                crossword[i][j] = " ";
            }
        }
    }

    private static void generateCrossword(String[][] crossword, int N, int M) {
        // Генерация горизонтальных выражений
        for (int i = 0; i < N; i += 2) {
            for (int j = 0; j < M - 4; j += 2) {
                generateHorizontalExpression(crossword, i, j);
            }
        }

        // Генерация вертикальных выражений с использованием чисел из горизонтальных выражений
        for (int j = 0; j < M; j += 2) {
            for (int i = 0; i < N - 4; i += 2) {
                generateVerticalExpression(crossword, i, j);
            }
        }
    }

    private static void generateHorizontalExpression(String[][] crossword, int row, int col) {
        int num1 = random.nextInt(10);
        int num2 = random.nextInt(10);
        char operation = OPERATIONS[random.nextInt(OPERATIONS.length)];

        if (operation == '/' && num2 == 0) {
            num2 = 1; // Избегаем деления на ноль
        }

        crossword[row][col] = String.valueOf(num1);
        crossword[row][col + 1] = String.valueOf(operation);
        crossword[row][col + 2] = String.valueOf(num2);
        crossword[row][col + 3] = "=";
        crossword[row][col + 4] = String.valueOf(calculate(num1, num2, operation));
    }

    private static void generateVerticalExpression(String[][] crossword, int row, int col) {
        // Используем число из горизонтального выражения для пересечения
        if (!crossword[row][col].equals(" ")) {
            int num1 = Integer.parseInt(crossword[row][col]);
            int num2 = random.nextInt(10);
            char operation = OPERATIONS[random.nextInt(OPERATIONS.length)];

            if (operation == '/' && num2 == 0) {
                num2 = 1; // Избегаем деления на ноль
            }

            crossword[row + 1][col] = String.valueOf(operation);
            crossword[row + 2][col] = String.valueOf(num2);
            crossword[row + 3][col] = "=";
            crossword[row + 4][col] = String.valueOf(calculate(num1, num2, operation));
        } else {
            // Если нет пересечения, генерируем новое вертикальное выражение
            int num1 = random.nextInt(10);
            int num2 = random.nextInt(10);
            char operation = OPERATIONS[random.nextInt(OPERATIONS.length)];

            if (operation == '/' && num2 == 0) {
                num2 = 1; // Избегаем деления на ноль
            }

            crossword[row][col] = String.valueOf(num1);
            crossword[row + 1][col] = String.valueOf(operation);
            crossword[row + 2][col] = String.valueOf(num2);
            crossword[row + 3][col] = "=";
            crossword[row + 4][col] = String.valueOf(calculate(num1, num2, operation));
        }
    }

    private static int calculate(int num1, int num2, char operation) {
        switch (operation) {
            case '+': return num1 + num2;
            case '-': return num1 - num2;
            case '*': return num1 * num2;
            case '/': return num1 / num2;
            default: return 0;
        }
    }

    private static void printCrossword(String[][] crossword, int N, int M) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(crossword[i][j] + " ");
            }
            System.out.println();
        }
    }
}