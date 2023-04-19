import java.io.FileWriter;

public class Task_2_ScanNumbers {
    public static void main(String[] args) {
        int [] array = {4,8,6,5,2,3,7,1,9,4};
        int [] SortArray = SortAndWriteLog(array);
        
        String result = "";
        for (int i = 0; i < SortArray.length; i++) {
            result +=SortArray[i];
        }    
        System.out.println("Массив отсортирован: " + result);
    }

    static int [] SortAndWriteLog (int [] array) {
        int temp = 0;
        String log = "";
        int count = 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                log += count + ". i= " + i + ", j= " + j + ", temp: " + temp + ", array[i]: " + array[i] + ", array[j]: " + array[j];                
                WriteToFile(log);
                log = "";  
                if (array[i] <= array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;                    
                } 
                log += "Result: temp= " + temp + ", array[i]= " + array[i] + ", array[j]= " + array[j];  
                WriteToFile(log);
                log = "";
                count++;
            }
        }
        return array;
    }       
    
    static String WriteToFile(String Resulttext) {
        String path = "log.txt";
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
