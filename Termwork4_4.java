//TERMWORK 4
//4.4 ) Write a Java program to get the attributes of a specified file.

import java.io.File;
import java.util.Scanner;

public class Termwork4_4 {
    public static void main(String[] args) {
        String fname;
        String path = new String();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the file:");
        fname = sc.nextLine(); 
        path = "C:\\Users\\Rahul\\Desktop\\Advance Java\\" + fname; 
        File f = new File(path);
        System.out.println("Name of the File:" + f.getName());
        System.out.println("Path of File: "+f.getPath());
        System.out.println("Is it a directory?: " + f.isDirectory());
        System.out.println("Length of File in bytes: "+f.length());
        System.out.println("Last Modified time: " +  f.lastModified());
        System.out.println("Is Hidden?: " + f.isHidden());
        sc.close();
    }
}
