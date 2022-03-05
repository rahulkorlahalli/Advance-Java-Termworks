package Threads;

public class Reverse_thread extends Thread{

    private int n;

    public Reverse_thread(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        for(int i = n; i > 0; i--) {
            System.out.print(i+" ");
        }
        //System.out.println("Rev series child thread exiting!");
    }
    
}
