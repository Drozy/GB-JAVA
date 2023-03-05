package sem02;

import java.util.Scanner;

/*
 * Дано четное число N (>0) и символы c1 и c2. Написать метод, который вернет
 * строку длины N, которая состоит из чередующихся символов c1 и c2, начиная с c1.
 */
public class Program1 {

    private static char getChar(Scanner scanner, String message) {
        System.out.println(message);
        char symbol = scanner.nextLine().charAt(0);
        return symbol;
    }

    private static String generateString(int length, char symbol1, char symbol2) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length / 2; i++) {
            sb.append(new char[] { symbol1, symbol2 });
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите длину строки: ");
        int length = scanner.nextInt();
        scanner.nextLine();
        char symbol1 = getChar(scanner, "Введите первый символ: ");
        char symbol2 = getChar(scanner, "Введите последний символ: ");
        System.out.printf("Получили строку: %s\n", generateString(length, symbol1, symbol2));
        scanner.close();
    }
}
