package sem02;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/*
 * Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
 */
public class task2_2 {
    private static Logger logger = Logger.getLogger(task2_2.class.getName());
    static {
        FileHandler fh = null;
        try {
            fh = new FileHandler("sem02/log_task2_2.txt");
        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }
        fh.setFormatter(new SimpleFormatter());
        logger.addHandler(fh);
    }

    private static int[] fillArray(int size) {
        logger.info("Создаю массив.");
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = new Random().nextInt(100);
        }
        logger.info(Arrays.toString(arr));
        return arr;
    }

    private static void bubbleSort(int[] arr) {
        logger.warning("Начало сортировки.");
        int swap;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    swap = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = swap;
                    logger.info(Arrays.toString(arr));
                }
            }
        }
        logger.warning("Сортировка завершена.");
    }

    public static void main(String[] args) {
        logger.info("Сортировка массива пузырьком.");
        int[] array = fillArray(10);
        System.out.println("\nИсходный массив:");
        System.out.println(Arrays.toString(array));
        bubbleSort(array);
        System.out.println("\nОтсортированный массив:");
        System.out.println(Arrays.toString(array));
        logger.info("Выполнено");
    }
}
