/*  3.  Write a program that takes a name from the user at the command line. If a file with that name exists, the program must show its contents on screen. If it does not, the program must say so.
 */

import java.io.File;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class PrintFile {
	public static void main(String[] args){
        String filePath = args[0];
		PrintFile pf = new PrintFile();
		pf.launch(filePath);
	}
	public void launch(String path){
		readFileAndPrint(path);
	}
	public void readFileAndPrint(String filePath){
		File file = new File(filePath);
        BufferedReader in = null;
        try {
            if(!file.exists()){
                throw new SecurityException();
            }
            in = new BufferedReader(new FileReader(file));
			String line;
            while((line = in.readLine()) != null){
                System.out.println(line);
            }
		} catch (SecurityException ex) {
			System.out.println("This file does not exist: " + file);
		} catch (FileNotFoundException ex){
            System.out.println("File " + file + " does not exist.");
        } catch (IOException ex) { ex.printStackTrace();
        } finally {
            closeReader(in);
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