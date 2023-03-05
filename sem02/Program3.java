package sem02;

import java.util.Scanner;

/*
 * Напишите метод, который принимает на вход строку (String) и определяет является ли строка палиндромом (возвращает boolean значение).
 */
public class Program3 {

    public static boolean isPolyndrom(String message) {
        int len = message.length();
        for (int i = 0; i < len; i++)
            if (message.charAt(i) != message.charAt(len - 1 - i))
                return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String message = scanner.nextLine();
        System.out.println(isPolyndrom(message));
        scanner.close();
    }
}
