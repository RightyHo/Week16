/*  1. ls - Write a program that shows on screen the names of the files in the current directory. (Hint: look at methods from class File).
*/

import java.io.File;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class FileNames{
	public static void main(String[] args){
		FileNames fn = new FileNames();
		fn.launch();
	}
	public void launch(){
		readFileNames();
	}
	public void readFileNames(){
		String fileName = "/Users/andrewho/Documents/Programming/Week16/";
		File file = new File(fileName);
        if(file.exists()){
            System.out.println("This file does exist according to this method call");
        }
        if(file.isDirectory()){
            System.out.println("This file is a directory");
        }
		try {
			String[] fileArray = file.list();
            for(int i=0;i<fileArray.length;i++){
                String str = fileArray[i];
                System.out.println(str);
			}
		} catch (SecurityException  ex) {
			System.out.println("Encountered problems listing files in directory: " + file);
		}
    }
}