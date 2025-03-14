import java.util.Random;

public class MathCrossword {
    private static final Random random = new Random();
    private static final char[] OPERATIONS = {'+', '-', '*', '/'};

    public static void main(String[] args) {
        int N = 5; // Количество строк
        int M = 5; // Количество колонок
        char[][] crossword = new char[N][M];
        generateCrossword(crossword, N, M);
        printCrossword(crossword, N, M);
    }

    private static void generateCrossword(char[][] crossword, int N, int M) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (crossword[i][j] == '\0') {
                    if (random.nextBoolean() && j + 4 < M) {
                        generateHorizontalExpression(crossword, i, j, M);
                    } else if (i + 4 < N) {
                        generateVerticalExpression(crossword, i, j, N);
                    }
                }
            }
        }
    }

    private static void generateHorizontalExpression(char[][] crossword, int row, int col, int M) {
        int num1 = random.nextInt(10);
        int num2 = random.nextInt(10);
        char operation = OPERATIONS[random.nextInt(OPERATIONS.length)];

        if (operation == '/' && num2 == 0) {
            num2 = 1; // Избегаем деления на ноль
        }

        crossword[row][col] = (char) ('0' + num1);
        crossword[row][col + 1] = operation;
        crossword[row][col + 2] = (char) ('0' + num2);
        crossword[row][col + 3] = '=';
        crossword[row][col + 4] = (char) ('0' + calculate(num1, num2, operation));
    }

    private static void generateVerticalExpression(char[][] crossword, int row, int col, int N) {
        int num1 = random.nextInt(10);
        int num2 = random.nextInt(10);
        char operation = OPERATIONS[random.nextInt(OPERATIONS.length)];

        if (operation == '/' && num2 == 0) {
            num2 = 1; // Избегаем деления на ноль
        }

        crossword[row][col] = (char) ('0' + num1);
        crossword[row + 1][col] = operation;
        crossword[row + 2][col] = (char) ('0' + num2);
        crossword[row + 3][col] = '=';
        crossword[row + 4][col] = (char) ('0' + calculate(num1, num2, operation));
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

    private static void printCrossword(char[][] crossword, int N, int M) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(crossword[i][j] + " ");
            }
            System.out.println();
        }
    }
}