public class rofl {
    public static void main(String[] a) {
        String[] wordsTest = {"СЛОВО", "ДУМАЙ", "МОЗГ"};
        print(fill(wordsTest, 4, 4)); // Изменил размер массива на 4x4
    }

    static char[][] fill(String[] words, int m, int n) {
        String allWords = String.join("", words); // Объединяем все слова в одну строку
        int c = 0; // Индекс для перебора символов в allWords
        char[][] field = new char[m][n]; // Создаем массив m x n

        for (int i = 0; i < m; i++) {
            if (i % 2 == 0) {
                // Заполняем слева направо для четных строк
                for (int j = 0; j < n; j++) {
                    if (c < allWords.length()) {
                        field[i][j] = allWords.charAt(c);
                        c++;
                    } else {
                        field[i][j] = ' '; // Если символы закончились, заполняем пробелом
                    }
                }
            } else {
                // Заполняем справа налево для нечетных строк
                for (int j = n - 1; j >= 0; j--) {
                    if (c < allWords.length()) {
                        field[i][j] = allWords.charAt(c);
                        c++;
                    } else {
                        field[i][j] = ' '; // Если символы закончились, заполняем пробелом
                    }
                }
            }
        }
        return field;
    }

    static void print(char[][] arr) {
        for (char[] row : arr) {
            for (char ch : row) {
                System.out.print(ch);
            }
            System.out.println();
        }
    }
}