package sem01;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Program {
    private static String readString(Scanner scanner, String message) {
        System.out.println(message);
        String value = scanner.nextLine();
        return value;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, World");
        System.out.println(LocalDateTime.now());
        String name = readString(scanner, "Enter your name: ");
        System.out.printf("Hello, %s.", name);

        // Дан массив двоичных чисел, например [1,1,0,1,1,1], вывести максимальное
        // количество подряд идущих 1.
        int max_count = 0;
        int arr[] = { 1, 1, 0, 1, 1, 1 };
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                temp++;
            }
            else {
                if (temp > max_count) {
                    max_count = temp;
                }
                temp = 0;
            }
        }
        if (temp > max_count) {
            max_count = temp;
        }
        System.out.println(max_count);
        scanner.close();
    }
}
