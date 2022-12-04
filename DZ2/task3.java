package DZ2;

import java.io.FileReader;
import java.io.FileWriter;

public class task3 {
    public static void main(String[] args) throws Exception {
        String str = sReader();
        String[] sParse = sParse(str);
        String[] sReplace = sReplace(sParse);
        sWriter(sReplace);
    }
    // метод считывания с файла
    public static String sReader () throws Exception {
        StringBuilder str = new StringBuilder();
        FileReader fr = new FileReader("data.json");
        while (fr.ready()) {
            int data = fr.read();
            char ch = (char)data;
            if (!Character.toString(ch).equals("[") && !Character.toString(ch).equals("]") && !Character.toString(ch).equals("{") && !Character.toString(ch).equals("}"))
            str.append(Character.toString(ch));
        }
        fr.close();
        String json = str.toString().strip();
        return json;
    }
    // метод парсинга строки
    public static String[] sParse (String str) {
        String[] strParse = str.split(",");
        return strParse;
    }
    // метод перестановки 
    public static String[] sReplace (String[] str) {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            String[] s = str[i].split(":");
            for (int j = 0; j < s.length; j++) {
                s[j] = s[j].replace("фамилия", "Студент");
                s[j] = s[j].replace("оценка", "получил");
                s[j] = s[j].replace("предмет", "по предмету");
                s[j] = s[j].replaceAll("\"", ""); // наконец-то я нашла как избавиться от ковычек!
                temp.append(s[j]);
                temp.append(" ");
            }
            str[i] = temp.toString();
            temp.setLength(0);
        }
        return str;
    }
    // метод записи в файл
    public static void sWriter (String[] str) throws Exception {
        FileWriter fw = new FileWriter("data.txt", true);
        for (int i = 1; i < str.length + 1; i++) {
            fw.write(str[i - 1]);
            if (i % 3 == 0){
                fw.append("\n");
            }
        }
        fw.close();
    }
}