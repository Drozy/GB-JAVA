package sem01;

import java.util.Scanner;

/*
 * Реализовать простой калькулятор
 */
public class task1_3 {

    private static Scanner scanner = new Scanner(System.in);

    private static double getNum(String message) {
        double num;
        System.out.println(message);
        if (scanner.hasNextDouble()) {
            num = scanner.nextDouble();
        } else {
            System.out.println("Ошибка ввода. Попробуйте еще раз.");
            scanner.next();
            num = getNum(message);
        }
        return num;
    }

    private static char getOperation() {
        System.out.println("Введите оператор (+, -, *, /): ");
        char operation;
        if (scanner.hasNext()) {
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Ошибка ввода. Попробуйте еще раз.");
            scanner.next();
            operation = getOperation();
        }
        return operation;
    }

    private static double calc(Double a, Double b, char operation) {
        double result;
        switch (operation) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                if (b == 0) {
                    System.out.println("На 0 делить нельзя.");
                    result = calc(a, b, getOperation());
                    break;
                } else {
                    result = a / b;
                    break;
                }
            default:
                System.out.println("Операция не распознана.");
                result = calc(a, b, getOperation());
        }
        return result;
    }

    public static void main(String[] args) {
        double a = getNum("Введите первое число: ");
        double b = getNum("Введите второе число: ");
        char op = getOperation();
        System.out.println(calc(a, b, op));
    }
}
