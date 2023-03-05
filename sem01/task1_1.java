package sem01;

import java.util.Scanner;

/*
 * Вычислить n-ое треугольноe число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
 */
public class task1_1 {
    private static int triangularNumber(int num) {
        int res = 0;
        for (int i = 1; i <= num; i++) {
            res += i;
        }
        return res;
    }

    private static int factorial(int num) {
        int res = 1;
        for (int i = 1; i <= num; i++) {
            res *= i;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Задайте число n: ");
        int number = scanner.nextInt();
        int tr = triangularNumber(number);
        System.out.printf("%d-ое треугольное число равно %d\n", number, tr);
        int fac = factorial(number);
        System.out.printf("%d! = %d\n", number, fac);
        scanner.close();
    }
}
