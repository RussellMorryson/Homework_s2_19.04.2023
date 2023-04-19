import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {
        File file = new File("file.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String text = scanner.nextLine();
        ArrayList<String> Words = FormatTextToList(text);
        FormatResultString(Words);
    }

    static String FormatText(String text) {
        text = text.replace("[", "");
        text = text.replace("]", "");
        text = text.replace("{", "");
        text = text.replace("}", "");
        text = text.replace(" ", "");
        text = text.replace("\"", "");
        return text;
    }

    static ArrayList<String> FormatTextToList(String text) {
        text = FormatText(text);
        char[] arr = text.toCharArray();
        ArrayList<String> Words = new ArrayList<>();
        String word = "";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ':') {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] != ',') {
                        word += arr[j];
                    } else {
                        Words.add(word);
                        word = "";
                        break;
                    }
                    if (j == arr.length - 1) {
                        Words.add(word);
                        word = "";
                        break;
                    }
                }
            }
        }
        return Words;
    }

    static String FormatResultString(ArrayList<String> Words) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (String temp : Words) {
            if (count == 1) {
                sb.append("Студент ");
                sb.append(temp);                
                count++;
            }
            else if (count == 2) {
                sb.append(" получил "); 
                sb.append(temp);
                count++;
            }
            else if (count == 3) {
                sb.append(" по предмету ");
                sb.append(temp);
                sb.append(".");
                WriteToFile(sb.toString());  
                sb.delete(0,100);              
                count = 1;
            }
        }
        return null;
    }

    static String WriteToFile(String Resulttext) {
        String path = "result.txt";
        try (FileWriter fw = new FileWriter(path, true)) {
            fw.write(Resulttext);
            fw.write('\n');
            fw.flush();
        } catch (Exception e) {
            e.printStackTrace();            
        }
        return null;
    }
}