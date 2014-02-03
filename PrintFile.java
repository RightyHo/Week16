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
		String fileName = "./Programming in Java/Week16";
		File file = new File(fileName);
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(file));
			String line;
			while((line = in.readLine()) != null){
				System.out.println(line);
			}
		} catch (FileNotFoundException ex) {
			System.out.println("File " + file + " does not exist.");
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			closeReader(in);
		}
	}
	private void closeReader(Reader reader) {
		try {
			if (reader != null) {
				reader.close();
			}
		} catch (IOException ex){
			ex.printStackTrace();
		}
	}
}