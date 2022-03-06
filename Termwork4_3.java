import java.util.Scanner;
import java.io.*;


public class Termwork4_3 {
    public static void main(String args[]){
        String in = new String();
        String out = new String();
        String src = new String();
        String dest = new String();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the  name of the input file");
        in = sc.nextLine();
        System.out.println("Enter the name of the output file");
        out = sc.nextLine();
        src = "C:\\Users\\Rahul\\Desktop\\Advance Java\\" + in;
        dest = "C:\\Users\\Rahul\\Desktop\\Advance Java\\" + out;
        File f1 = new File(src);
        File f2 = new File(dest);
        try {
        FileInputStream input = new FileInputStream(src);
        FileOutputStream output = new FileOutputStream(dest);
        int ch1 = input.read();
        while( ch1 != -1){
            output.write((char)ch1);
            ch1 = input.read();
        }

        System.out.println("Contents of source file written to dest file successfully\n");
        }
            
        catch(Exception e){
            System.out.println(e.getStackTrace());
        }

        System.out.println("Comparing the properities of Source File and Destination File");
        System.out.println("----------Source File----------");
        System.out.println("Name: " + f1.getName());
        System.out.println("Path: " + f1.getPath());
        System.out.println("Size: " + f1.length());
        
        System.out.println("----------Destination File----------");
        System.out.println("Name: " + f2.getName());
        System.out.println("Path: " + f2.getPath());
        System.out.println("Size: " + f2.length());
        sc.close();
    }
}
