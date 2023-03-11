package sem02;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/*
 * К калькулятору из предыдущего ДЗ добавить логирование.
 */
public class task2_4 {

    private static Scanner scanner = new Scanner(System.in);
    
    private static Logger logger = Logger.getLogger(task2_2.class.getName());
    static {
        FileHandler fh = null;
        try {
            fh = new FileHandler("sem02/log_task2_4.txt");
        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }
        fh.setFormatter(new SimpleFormatter());
        logger.addHandler(fh);
    }

    private static double getNum(String message) {
        double num;
        System.out.println(message);
        if (scanner.hasNextDouble()) {
            num = scanner.nextDouble();
        } else {
            System.out.println("Ошибка ввода. Попробуйте еще раз.");
            logger.warning("Ошибка ввода.");
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
            logger.info("Введена операция " + operation);
        } else {
            System.out.println("Ошибка ввода. Попробуйте еще раз.");
            logger.warning("Ошибка ввода.");
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
                    logger.warning("На 0 делить нельзя.");
                    result = calc(a, b, getOperation());
                    break;
                } else {
                    result = a / b;
                    break;
                }
            default:
                System.out.println("Операция не распознана.");
                logger.warning("Операция не распознана.");
                result = calc(a, b, getOperation());
        }
        logger.info("Результат операции: " + String.valueOf(result));
        return result;
    }

    public static void main(String[] args) {
        logger.info("Начало программы.");
        double a = getNum("Введите первое число: ");
        logger.info("Первое число " + String.valueOf(a));
        double b = getNum("Введите второе число: ");
        logger.info("Первое число " + String.valueOf(b));
        char op = getOperation();
        System.out.println(calc(a, b, op));
        logger.info("Завершение программы.");
    }
}
