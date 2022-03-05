package Series;

public class Descending extends Thread {
    private int[] arr = new int[25];

    public Descending(int[] arr) {
        this.arr = arr;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < (arr.length - 1); i++) {
            for (int j = (i+1); j < arr.length; j++) {
                if(arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
