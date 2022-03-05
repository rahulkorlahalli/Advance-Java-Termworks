/*Write a Java Program to demonstrate the implementation of stream classes in Java. Assume that
an input file named "input.txt" already exists with few lines of random text. Accept a filename
from the user, this will be the destination file.

Write a menu driven program to do the following:
1) Tranfer the contents of the input file to the destination file – one byte at a time using
FileInputStream /FileOutputStream class
2) Tranfer the contents of the input file to the destination file using the ByteArrayInputStream
/ByteArrayInputStream class
3) Display the contents of the destination file.*/

import java.io.*;
import java.util.Scanner;

public class Termwork1{
    public static void main(String[] args) {
        int ch;
        while(true)
        {
            System.out.println();
            System.out.println("Enter your choice:");
            System.out.println("1.Input file to output file char by char");
            System.out.println("2.Input file to output file using ByteArray");
            System.out.println("3.Display contents of output file");
            System.out.println("4.Exit");
            Scanner sc = new Scanner(System.in);
            ch = sc.nextInt();
            File f1 = new File("C:\\Users\\Rahul\\Desktop\\Advance Java\\in.txt");//Add path to input file
            File f2 = new File("C:\\Users\\Rahul\\Desktop\\Advance Java\\out.txt");//Add path to output file
            try {
                switch (ch) {
                    case 1: FileInputStream fin = new FileInputStream(f1);
                            FileOutputStream fout = new FileOutputStream(f2);
                            while(fin.available()!=0){
                                int data = fin.read();
                                fout.write(data);
                            }
                            System.out.println("Done");
                            break;
                    case 2: byte cbuf[] = new byte[(int)f1.length()];
                            FileInputStream fin1 = new FileInputStream(f1);
                            FileOutputStream fout2 = new FileOutputStream(f2);
                            fin1.read(cbuf);
                            ByteArrayInputStream b1 = new ByteArrayInputStream(cbuf);
                            ByteArrayOutputStream b2 = new ByteArrayOutputStream();
                            int i = b1.read();
                            while(i!=-1)
                            {
                                b2.write(i);
                                i = b1.read();
                            }
                            b2.writeTo(fout2);
                            System.out.println("Done");
                            break;

                    case 3: FileInputStream fin2 = new FileInputStream(f2);//Opening output file
                            while(fin2.available()!=0)
                            {
                                System.out.print((char)fin2.read());
                            }
                            break;
                    case 4: System.exit(0);
                            break;
                    default:System.out.println("Invalid Choice");
                            break;
                            }
            } 
            catch (Exception e) {
                System.out.println(e.getStackTrace());
            }
        }
    }
}