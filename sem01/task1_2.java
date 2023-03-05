package sem01;

/*
 * Вывести все простые числа от 1 до 1000
 */
public class task1_2 {
    public static void main(String[] args) {
        StringBuilder output = new StringBuilder();
        output.append("1 ");
        for (int i = 2; i < 1000; i++) {
            int count = 0;
            for (int j = 2; j <= i && count < 2; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            if (count < 2)
                output.append(i + " ");
        }
        System.out.println(output);
    }
}
