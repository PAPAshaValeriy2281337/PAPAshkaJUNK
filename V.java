public class V {
    public static void main(String[] a) {
        String[] wordsTest = {"СЛОВО", "ДУМАЙ", "МОЗГ"};
        print(fill(wordsTest, 3, 4)); // Изменил размеры массива на 3x4
    }

    static char[][] fill(String[] words, int m, int n) {
        String allWords = String.join("", words);
        int total = m * n;
        int c = 0;
        char[][] field = new char[m][n];
        for (int i = 0; i < m; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < n; j++) {
                    if (c < allWords.length()) {
                        field[i][j] = allWords.charAt(c);
                        c++;
                    } else {
                        field[i][j] = ' '; // Если символы закончились, заполняем пробелом
                    }
                }
            } else {
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
        for (char[] objects : arr) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(objects[j] + "");
            }
            System.out.println();
        }
    }
}