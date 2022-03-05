//TERMWORK 5.2

/*5.2) Write a multithreaded Java program print Fibonacci & Reverse series with thread
 Class/Runnable interface.*/


import java.util.Scanner;
import Threads.Fibonacci_thread;
import Threads.Reverse_thread;

public class Termwork5_2 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("How many number in fibonacci series & reverse series: ");
        int n = in.nextInt();

        System.out.println("Printing Fibonacci!");
        Fibonacci_thread fbn = new Fibonacci_thread(n);
        fbn.start();

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("Printing Reverse!");
        Reverse_thread rev = new Reverse_thread(n);
        rev.start();
        in.close();
    }
}
