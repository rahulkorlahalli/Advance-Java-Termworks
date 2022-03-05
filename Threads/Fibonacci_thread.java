package Threads;

public class Fibonacci_thread extends Thread{
    
    private int n;

    public Fibonacci_thread(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        int f1 = 0, f2 = 1, fnext;
        
        System.out.print(f1 + " " + f2+" ");
        for(int i = 0; i < n-2; i++) {
            fnext = f1 + f2;
            System.out.print(fnext+" ");
            f1 = f2;
            f2 = fnext;
        }
        System.out.println();
        // System.out.println("Fib series child thread exiting!");
    }
}