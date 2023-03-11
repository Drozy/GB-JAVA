package sem02;

/*
 * Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, 
 * используя StringBuilder. Данные для фильтрации приведены ниже в виде json строки. 
 * Если значение null, то параметр не должен попадать в запрос. 
 * Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
 */
public class task2_1 {
    private static String formRequest(String str) {
        StringBuilder request = new StringBuilder("select * from students where ");
        String[] options = str.split("\"");
        // {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
        // [0  1  2   3    4     5    6   7    8   9   10  11   12 13  14 15  16]
        for (int i = 1; i < options.length; i += 4)
            if (!options[i + 2].equals("null")) {
                if (i > 1)
                    request.append(" and ");
                request.append(options[i]).append(" = \"").append(options[i + 2]).append("\"");
            }
        return request.toString();
    }

    public static void main(String[] args) {
        String jsonstring = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        System.out.println(formRequest(jsonstring));

        String jsonstring2 = "{\"name\":\"Petrov\", \"country\":\"null\", \"city\":\"Tver\", \"age\":\"30\"}";
        System.out.println(formRequest(jsonstring2));
    }
}
