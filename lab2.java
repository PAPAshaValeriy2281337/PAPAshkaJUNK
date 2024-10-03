import java.util.Scanner; // Импортируем класс Scanner для считывания ввода с клавиатуры

public class lab2 { // Объявляем публичный класс с именем lab2
    public static void main(String[] args) { // Главный метод, с которого начинается выполнение программы
        Scanner input = new Scanner(System.in); // Создаем объект Scanner для считывания пользовательского ввода
        System.out.print("Введите число для вычисления факториала: "); // Выводим сообщение для пользователя
        int number = input.nextInt(); // Считываем целое число, введенное пользователем
        int originalNumber = number;  // Сохраняем первоначальное число для дальнейшего использования в выводе
        int factorial = 1; // Инициализируем переменную factorial значением 1 (факториал 0!)

        while (number > 0) { // Запускаем цикл, пока number больше 0
            factorial *= number; // Умножаем текущий факториал на значение number
            number--; // Уменьшаем значение number на 1
        }

        System.out.println("Факториал числа " + originalNumber + " равен " + factorial); // Выводим результат
    }
}
