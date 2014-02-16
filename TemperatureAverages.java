/*  8. Write a program that reads a file from disk in comma-separated format (CSV). Every line must contain a list of number separated by commas.
    The program must output the average for every line plus the average for the whole file.
*/
import java.io.File;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class TemperatureAverages {
    private int totalCount = 0;
    public static void main(String[] args){
        TemperatureAverages ta = new TemperatureAverages();
        ta.launch();
    }
    public void launch(){
        double totalSum = calcTotal();
        System.out.println("The overall average temperature was: " + String.valueOf(totalSum/totalCount));
    }
    public double calcTotal(){
        double result = 0.0;
        double lineTotal = 0.0;
        int lineCount = 0;
        String filePath = "/Users/andrewho/Documents/Programming/Week16/Temperatures.csv";
        File file = new File(filePath);
        BufferedReader in = null;
        try {
            if(!file.exists()){
                throw new SecurityException();
            }
            in = new BufferedReader(new FileReader(file));
            String line;
            while((line = in.readLine()) != null){
                System.out.print(line);
                String[] temps = line.split(",");
                for(int i=0;i<temps.length;i++){
                    lineTotal = Integer.parseInt(temps[i]);
                    lineCount++;
                    totalCount++;
                }
                System.out.println("The average temperature for this line was: " + String.valueOf(lineTotal/lineCount));
                result = result + lineTotal;
                lineTotal = 0.0;
                lineCount = 0;
            }
            return result;
        } catch (SecurityException ex) {
            System.out.println("This file does not exist: " + file);
        } catch (FileNotFoundException ex){
            System.out.println("File " + file + " does not exist.");
        } catch (IOException ex) { ex.printStackTrace();
        } finally {
            closeReader(in);
        }
        return result;
    }
    private void closeReader(Reader reader) {
        try {
            if (reader != null) {
                reader.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}