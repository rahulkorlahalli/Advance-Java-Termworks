import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Termwork4_1 {
    public static void main(String[] args) throws IOException {
        String fname;
        String path = new String();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the file:");
        fname = sc.nextLine(); 
        path = "C:\\Users\\Rahul\\Desktop\\Advance Java\\" + fname;// file should be present in this specified path
        File f = new File(path);
        System.out.println("Name of the File:" + f.getName());
        System.out.println("Does file exist: "+ f.exists());
        System.out.println("Is Readable?: "+f.canRead());
        System.out.println("Is Writeable?: " + f.canWrite());
        System.out.println("Is Hidden?: " + f.isHidden());
        System.out.println("Size in bytes: " + f.length());
        if(f.isDirectory()){ //If the input given is a directory then it will list the files in the directory
            System.out.println("Files in this directory are:"); 
            String filesPresent[] = f.list();
            for(String i : filesPresent){
                System.out.println(i);
            }
        }
        else{// 
            System.out.println("Select Choice:");
            System.out.println("1.Append contents to the file:");
            System.out.println("2.Rewrite contents in the file:");
            int c = sc.nextInt();
            switch(c){
                case 1: FileOutputStream fout = new FileOutputStream(path,true);
                        System.out.println("Enter the content to be appended to: ");
                        String input;
                        input = sc.nextLine();
                        input = sc.nextLine();
                        fout.write(input.getBytes());
                        break;
                case 2: FileOutputStream fout1 = new FileOutputStream(path,false);
                        System.out.println("Enter the new content: ");
                        String input1;
                        input1 = sc.nextLine();
                        input1 = sc.nextLine();
                        fout1.write(input1.getBytes());
                        break;
                }
            }
        sc.close();
    }
}