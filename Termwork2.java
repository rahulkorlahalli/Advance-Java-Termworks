//TERM WORK 2

/*Write a menu-driven Java Program to create an ArrayList of (1) integers and (2) floats of user
specified length. Write a set of overloaded methods to "add" and/or "remove" elements from the
arrays and another set of overloaded methods to perform linear search on the arrays, given the key
element. Create object(s) to demonstrate the above functionalities.*/

import java.io.*;
import java.util.*;

public class Termwork2 {
    
    static void createArray(ArrayList ai, int n){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the element to be added:");
        int ele = s.nextInt();
        ai.add(ele);
        System.out.println("ArrayList<Integer> contains: " + ai);
    }

    static void removeArray(ArrayList<Integer> ai, int idx) {
        if(!ai.isEmpty()){
            if(idx>=0 && idx<ai.size()){
                ai.remove(idx);
                System.out.println("ArrayList<Integer> contains: " + ai);
            }
            else
                System.out.println("Invalid Index");
            }
        else
            System.out.println("ArrayList<Integer> is empty");
    } 

    static void linearSearch(ArrayList ai, int ele){
        int i;
        for(i=0;i<ai.size();i++){
            if((int)ai.get(i) == ele){
                System.out.println("Element found at index:" + i);
                break;
            }
        }
        if(i==ai.size()){
            System.out.println("Search Unsuccessful");
        }

    }
    static void createArray(int n,ArrayList fi){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the element to be added:");
        double ele = s.nextDouble();
        fi.add(ele);

        System.out.println("ArrayList<FLoat> contains: " + fi);
    }

    static void removeArray(int idx,ArrayList fi) {
        if(!fi.isEmpty()){
            if(idx>=0 && idx<fi.size()){
                fi.remove(idx);
                System.out.println("ArrayList<FLoat> contains: " + fi);
            }
            else
                System.out.println("Invalid Index");
            }
        else
            System.out.println("ArrayList<Float> is empty");
    } 

    static void linearSearch(double ele, ArrayList fi){
        int i;
        for(i=0;i<fi.size();i++){
            if((double)fi.get(i) == ele){
                System.out.println("Element found at index:" + i);
                break;
            }
        }
        if(i==fi.size()){
            System.out.println("Search Unsuccessful");
        }

    }

    public static void main(String[] args) {
        int choice,n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter initial size of the ArrayList:");
        n = sc.nextInt();
        ArrayList<Integer> ai = new ArrayList<>();
        ArrayList<Integer> fi = new ArrayList<>();
        
        while(true){
            System.out.println();
            System.out.println("||----------- MENU -----------||");
            System.out.println("1.Create an Interger ArrayList\t2.Remove an element from Integer Array List\t3.Search in Integer ArrayList");
            System.out.println("4.Create an Float ArrayList\t5.Remove an element from Float Array List\t6.Search in Float ArrayList\n7.Exit");
            System.out.println("Enter your choice:");
            choice = sc.nextInt();
            switch(choice)
            {
                case 1: createArray(ai,n);
                        break;
                case 2: System.out.println("Enter the Index of the element to be deleted:");
                        int idx = sc.nextInt();
                        removeArray(ai, idx);
                        break;
                case 3: System.out.println("Enter the element to be searched:");
                        int ele = sc.nextInt();
                        linearSearch(ai,ele);
                        break;
                case 4: createArray(n,fi);
                        break;
                case 5: System.out.println("Enter the Index of the element to be deleted:");
                        int idxf = sc.nextInt();
                        removeArray(idxf,fi);
                        break;
                case 6: System.out.println("Enter the element to be searched:");
                        double elef = sc.nextDouble();
                        linearSearch(elef,fi);
                        break;
                case 7: System.exit(0);
                        break;
                default:System.out.println("Invalid Choice");
            }
        }
    } 
}
