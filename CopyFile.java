/*  4.a. Write a program that takes two names from the user at the command line. If a file with the first name exists, the program must copy it into a file with the second name.
    If the first file does not exist, the program must say so. If the second file does exists, the program must ask the user whether to overwrite it or not, and act accordingly.
*/

import java.io.File;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CopyFile {
    public static void main(String[] args){
        String filePath1 = args[0];
        String filePath2 = args[1];
        CopyFile cf = new CopyFile();
        cf.launch(filePath1,filePath2);
    }
    public void launch(String path1,String path2){
        copyFile(path1,path2);
    }
    public void copyFile(String copyFrom,String copyTo){
        File file1 = new File(copyFrom);
        File file2 = new File(copyTo);
        try {
            if(!file1.exists()){
                throw new SecurityException();
            }
            if(file2.exists()){
                System.out.println("The file you are trying to write to already exists - would you like to overwrite it (y/n)");
                String response = System.console().readLine();
                if(response.equals("y")){
                    duplicate(file1,file2);
                } else if(response.equals("n")){
                    System.out.println("Exiting progam - nothing done");
                } else {
                    System.out.println("Invalid selection - exiting program");
                }
            } else {
                duplicate(file1,file2);
            }
        } catch (SecurityException ex) {
            System.out.println("This file does not exist: " + file1);
            ex.printStackTrace();
        }
    }
    private void duplicate(File from,File to){
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            in = new BufferedReader(new FileReader(from));
            out = new PrintWriter(to);
            String line;
            while((line = in.readLine()) != null){
                out.write(line);
            }
        } catch (FileNotFoundException ex){
            System.out.println("File " + from + " or " + to + " does not exist.");
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            closeReader(in);
            out.close();
        }
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






































