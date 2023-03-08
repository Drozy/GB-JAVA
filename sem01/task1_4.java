package sem01;

import java.util.Scanner;

/*
 * *+Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса, 
 * например 2? + ?5 = 69. Требуется восстановить выражение до верного равенства. 
 * Предложить хотя бы одно решение или сообщить, что его нет.
 */
public class task1_4 {

    /*
     * 2? + ?5 = 69 можно записать в виде уравнения 10*2 + x + 10*y + 5 + (-10)*6 + (-1)*9 = 0
     * Функция (solution) последовательно вызывается для каждого символа строки справа налево. 
     * Параметр (position) - это номер символа. Одновременно вычисляется левая часть уравнения от текущего символа до конца строки, 
     * записывается в парамер (value). Параметр (factor) - это множитель текущей цифры, изначально он равен -1, 
     * потом все время умножается на 10, как только встретится '=' или '+' сбрасывается до 1.
     * Если функция запущена для символа '?', то будет запущено 10 вариантов (solution) для следующего символа, с разными (value).
     * После того, как функция была запущена для последнего символа (первого в строке), проверяется условие value = 0 
     * (т.е. полная левая часть уравнения равна нулю). Если условие истино, то все функции (solution) завершаются и печатается ответ.
     */
    private static boolean solution(char[] s, int position, int value, int factor) {
        if (--position < 0)
            return value == 0;
        switch (s[position]) {
            case '=':
            case '+':
                return solution(s, position, value, 1);
            case '?':
                for (s[position] = '0'; s[position] <= '9'; s[position]++)
                    if (solution(s, position, value + factor * (s[position] - '0'), factor * 10))
                        return true;
                s[position] = '?';
                return false;
            default:
                return solution(s, position, value + factor * (s[position] - '0'), factor * 10);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Задайте выражение вида q + w = e, где q, w, e >= 0 (например 2? + ?5 = 69)");
        String input = scanner.nextLine();
        char[] str = input.replaceAll(" ", "").toCharArray();
        System.out.println(solution(str, str.length, 0, -1) ? new String(str) : "Нет решений");
        scanner.close();
    }
}
