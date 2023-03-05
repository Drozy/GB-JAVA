package sem02;

import java.util.Scanner;

/*
 * Напишите метод, который сжимает строку
 */
public class Program2 {

    private static String encodeRLE(String message) {
        StringBuilder encode = new StringBuilder();
        int count = 1;
        for (int i=1; i < message.length(); i++) {
            if (message.charAt(i) == message.charAt(i-1)) {
                count++;
            }
            else {
                encode.append(message.charAt(i-1));
                if (count != 1) encode.append(count);
                count = 1;
            }
        }
        encode.append(message.charAt(message.length()-1));
        if (count != 1) encode.append(count);
        return encode.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите последовательность символов: ");
        String message = scanner.nextLine();
        System.out.println(encodeRLE(message));
        scanner.close(); 
    }
}
