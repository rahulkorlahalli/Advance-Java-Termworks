//TERMWORK 4.2

/*4.2 ) Write a menu driven Java program to read contents of a file and :
a) print characters on the console – one character at a time
b) print the entire file
c) print contents to another file*/

import java.io.*;
import java.util.Scanner;

public class Termwork4_2{
    public static void main(String[] args) {
        int ch;
        Scanner sc = new Scanner(System.in);
        File f1 = new File("C:\\Users\\Rahul\\Desktop\\Advance Java\\input.txt");//Path to input file
        while(true){
            System.out.println();
            System.out.println("PROGRAM ON FILE");
            System.out.println("1) Print characters on the console");
            System.out.println("2) Print the entire file on the console");
            System.out.println("3) Print contents to another file");
            System.out.println("4) Exit");
            System.out.print("Enter your choice:");
            ch = sc.nextInt();
            try{
                switch (ch) {
                case 1: Reader r = new FileReader(f1);
                        int data = r.read();
                        while(data !=-1){
                            System.out.print((char)data);
                            data = r.read();
                        }
                        System.out.println();
                        break;

                case 2: Reader r1 = new FileReader(f1);
                        char arr[] = new char[100];
                        r1.read(arr);//Entire content of inut file is read into array
                        System.out.println(arr);
                        break;

                case 3: Reader r2 = new FileReader(f1);
                        char arr1[] = new char[100];
                        r2.read(arr1);
                        Writer w1 = new FileWriter("C:\\Users\\Rahul\\Desktop\\Advance Java\\output.txt");//Path to destination file 
                        w1.write(arr1,0,(int)f1.length());
                        w1.close();
                        System.out.println("Characters successfully written to another file"); 
                        break;
                
                case 4: System.exit(0);
                        break;
                default: System.out.println("Invalid choice"); 
                        break;
                }
            }
            catch(Exception e){
             e.getStackTrace();
            }
        }
    }
}