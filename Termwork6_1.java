//TERMWORK 6.1

/*6.1) Write a Java program to demonstrate how the standard operations on a "Stack" can be
synchronized.*/

class Stack{
    protected int arr[];
    protected int top;

    Stack(int size){
        arr = new int[size];
        top = -1;
        System.out.println("Stack of size " + arr.length +" has been created");
    }

    synchronized void push(String name, int ele){
        if(top == arr.length -1)
            System.out.println("Stack is full - Overflow");
        else{
            arr[++top]=ele;
            System.out.println(name+ " Pushed --> " + ele);
        }          
        try{ Thread.sleep(1000);}
        catch(Exception e){ System.out.println(e);} 
    }

    synchronized void pop(String name){
        if(top == -1)
            System.out.println("Stack is empty - Underflow");
        else{
            System.out.println(name +" Popped --> "+ arr[top--]);
        }
        try{ Thread.sleep(1000);}
        catch(Exception e){ System.out.println(e);}
    }
}

class pushTh extends Thread{
    Stack s;
    String name;
    int ele;
    pushTh(Stack s, String name, int ele){
        this.s=s;
        this.name=name;
        this.ele=ele;
    }
    
    public void run(){
        s.push(name,ele);
    }
}

class popTh extends Thread{
    Stack s;
    String name;
    popTh(Stack s, String name){
        this.s=s;
        this.name=name;
    }
    
    public void run(){
        s.pop(name);
    }
}

public class Termwork6_1 {
    public static void main(String[] args) {
        Stack s= new Stack(10);
        pushTh pu1 = new pushTh(s,"PushThread1",10);
        pushTh pu2 = new pushTh(s,"PushThread2",15);
        pushTh pu3 = new pushTh(s,"PushThread3",20);
        pushTh pu4 = new pushTh(s,"PushThread4",25);

        popTh po1 = new popTh(s,"PopThread1");
        popTh po2 = new popTh(s,"PopThread2");
        popTh po3 = new popTh(s,"PopThread3");
        popTh po4 = new popTh(s,"PopThread4");

        pu1.start();
        pu2.start();
        pu3.start();
        pu4.start();

        po1.start();
        po2.start();
        po3.start();
        po4.start();
    }
}
