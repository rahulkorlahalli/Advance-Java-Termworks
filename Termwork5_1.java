//TERMWORK 5.1

/*5.1) Write a multithreaded Java program to create a list of numbers and then sort the contents
in ascending (thread 1) and descending (thread 2).
*/
import java.lang.Thread;
import java.util.Scanner;
import Series.Ascending;
import Series.Descending;

public class Termwork5_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        System.out.print("Enter the size of the array: ");
        n = in.nextInt();
        int []arr = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println("In Ascending Order:");
        Ascending asc = new Ascending(arr);
        asc.start();

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("In Descending Order:");
        Descending dsc = new Descending(arr);
        dsc.start();

        in.close();
    }
}
