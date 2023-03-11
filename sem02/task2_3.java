package sem02;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Дана json строка (можно сохранить в файл и читать из файла)
 * [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
 *  {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
 *  {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
 * Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
 */
public class task2_3 {

    private static String readFile(String filename) {
        StringBuilder fromfile = new StringBuilder();
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null) {
                fromfile.append(line);
                line = br.readLine();
            }
            fr.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return fromfile.toString();
    }

    private static int getLinesCount(String str) {
        return (int) str.chars().filter(ch -> ch == '}').count();
    }

    private static String[] parseData(String str) {
        String[] grades = new String[getLinesCount(str)];
        StringBuilder sb = new StringBuilder();
        String[] words = str.split("\"");
        int j = 0;
        for (int i = 3; i < words.length; i += 12) {
            sb.append("Студент ")
                .append(words[i])
                .append(" получил ")
                .append(words[i + 4])
                .append(" по предмету ")
                .append(words[i + 8]);
            grades[j] = sb.toString();
            sb.setLength(0);
            j++;
        }
        return grades;
    }

    public static void main(String[] args) {
        String str = readFile("sem02/task2_3_data.json");
        String[] res = parseData(str);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
