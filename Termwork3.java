//TERMWORK 3

/*Write a Java Program to demonstrate the implementation of reading and writing binary data in
Java.
1) Read the source and destination file names.
2) Read user defined text to be written to the source file.
3) Write every alternate byte from the source to the destination file.
4) Compare the properties of the file.*/

import java.io.*;
import java.util.Scanner;

public class Termwork3 {
    public static void main(String[] args) {
        int ch;
        Scanner sc = new Scanner(System.in);
        String src = new String();
        String des = new String();
        while(true)
        {   
            System.out.println();
            System.out.println("Enter your choice:");
            System.out.println("1.Enter the source and destination file name");
            System.out.println("2.Enter the text to be written in the src file");
            System.out.println("3.Copy Alternate byte from src file to des file");
            System.out.println("4.Compare the properties of the files");
            System.out.println("5.Exit");
            
            File f1,f2;
            ch = sc.nextInt();
            try {
                switch (ch) {
                    case 1: String in = new String();
                            String out = new String();
                            System.out.println("Enter the source file name:");
                            in = sc.nextLine();
                            in = sc.nextLine();
                            src = "C:\\Users\\Rahul\\Desktop\\Advance Java\\" + in;//Add path to where the file must be created
                            f1 = new File(src);
                            if(f1.createNewFile())
                                System.out.println("New File created");
                            else
                                System.out.println("File Already exists");
                            System.out.println("File Path: "+src);

                            System.out.println("Enter the destination file name:");
                            out = sc.nextLine();
                            des = "C:\\Users\\Rahul\\Desktop\\Advance Java\\" + out;//Add path to where the file must be created
                            f2 = new File(des);
                            if(f2.createNewFile())
                                System.out.println("New File created");
                            else
                                System.out.println("File Already exists");
                            System.out.println("File Path: "+ des);
                            break;
                    
                    case 2: String data = new String();
                            System.out.println("Enter the text to be written in src file:");
                            data = sc.nextLine();
                            data = sc.nextLine();
                            byte array[] = data.getBytes();
                            FileOutputStream fo = new FileOutputStream(src);//Output stream to write contents into source file
                            fo.write(array);
                            fo.close();
                            System.out.println("Data written into source file!");
                            break;

                    case 3: FileInputStream fi1 = new FileInputStream(src);
                            FileOutputStream fo1 = new FileOutputStream(des);
                            
                            int data1 = fi1.read();
                            while(data1!=-1)
                            {
                                fo1.write((char)data1);
                                data1 = fi1.read();
                                data1 = fi1.read();

                            }
                            System.out.println("Alternate bytes copied from source to destination file");
                            break;
                    
                    case 4: File a = new File(src);
                            File b = new File(des);
                            System.out.println("Properties of Soruce File:");
                            System.out.println("Length:" + a.length());
                            System.out.println("File Name:" + a.getName());
                            System.out.println("Is writeable?:" + a.canWrite());
                            System.out.println();
                            System.out.println("Properties of Destination File:");
                            System.out.println("Length:" + b.length());
                            System.out.println("File Name:" + b.getName());
                            System.out.println("Is writeable?:" + b.canWrite());
                            break;

                    case 5: System.exit(0);
                            break;
                
                    default: System.out.println("Invalid choice");
                        break;
                }
                
            } catch (Exception e) {
                System.out.println(e.getStackTrace());
            }
        }
    }    
}
