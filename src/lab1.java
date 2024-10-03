import java.util.Scanner;
public class lab1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите число для вычисления факториала: ");
        int number = input.nextInt();
        int originalNumber = number;  // Храним первоначальное число
        int factorial = 1;
        while (number > 0) {
            factorial *= number;
            number--;
        }
        System.out.println("Факториал числа " + originalNumber + " равен " + factorial);
    }
}
