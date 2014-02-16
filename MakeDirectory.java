/*  2. Write a program that takes a name from the user at the command line and creates a directory with that name. Remember that the only argument of method main is an array of Strings, each of them an argument written after the name of the class. For example, if you write java myClass this That 0, the elements in args will be three strings of values “this”, “That”, and “0”.
*/
import java.io.File;

public class MakeDirectory {
    public static void main (String[] args){
        String dirName = args[0];
        MakeDirectory md = new MakeDirectory();
        md.launch(dirName);
    }
    private void launch(String newDirectory){
        String directoryPath = ("/Users/andrewho/Documents/Programming/Week16/"+newDirectory);
        System.out.println(directoryPath);
        File file = new File(directoryPath);
        try{
            if(file.mkdir()){
                System.out.println("New Directory Created");
            } else {
                System.out.println("New Directory was NOT Created");
            }
        } catch (SecurityException ex){
            ex.printStackTrace();
        }
    }
}