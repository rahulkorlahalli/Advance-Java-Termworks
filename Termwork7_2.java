//TERMWORK 7
//7.2) Program to execute SQL query on a single table.

import java.sql.*;
import java.util.Scanner;
public class Termwork7_2 {
     public static void main(String[] args) throws ClassNotFoundException, SQLException {
         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tw7","user","password");//"jdbc:oracle:thin:@localhost:1521/XE" --> url for Oracle Database
         String name,usn,branch,sem;
         while(true){
             System.out.println("Enter your choice:");
             System.out.println("1.Insert new record");
             System.out.println("2.Delete existing record");
             System.out.println("3.Display details");
             System.out.println("4.Exit");
             Scanner sc = new Scanner(System.in);
             int ch = sc.nextInt();
             switch(ch){
                case 1: System.out.println("Enter USN of the student:");
                        usn = sc.nextLine();
                        usn = sc.nextLine();
                        System.out.println("Enter Name of the student:");
                        name = sc.nextLine();
                        System.out.println("Enter Branch of the student:");
                        branch = sc.nextLine();
                        System.out.println("Enter semester of the student:");
                        sem = sc.nextLine();
                        String query1 = "insert into student values(?,?,?,?)";
                        PreparedStatement p1 = con.prepareStatement(query1);
                        p1.setString(1, usn);  
                        p1.setString(2, name);  
                        p1.setString(3, branch);  
                        p1.setString(4, sem);
                        int n1 = p1.executeUpdate();
                        if(n1>0){
                            System.out.println("--Record Inserted Successfully--");
                        }  
                        break;
                case 2: System.out.println("Enter the USN of the student:");
                        usn =sc.nextLine();
                        usn =sc.nextLine();
                        String query2 = "delete from student where usn='"+usn+"'";
                        PreparedStatement p2 = con.prepareStatement(query2);
                        int n2 = p2.executeUpdate();
                        if(n2>0){
                            System.out.println("--Record deleted successfully--");
                        }
                        break;
                case 3: System.out.println("Records Available in the table:");
                        String query3 = "select * from student";
                        PreparedStatement p3 = con.prepareStatement(query3);
                        ResultSet rs = p3.executeQuery();
                        int count =0;
                        while(rs.next()){
                            count++;
                            System.out.println("USN --> "+ rs.getString(1));
                            System.out.println("Name --> "+ rs.getString(2));
                            System.out.println("Branch --> "+ rs.getString(3));
                            System.out.println("Semester --> "+ rs.getString(4));
                            System.out.println();
                        }
                        if(count==0){
                            System.out.println("--No records available--");
                        }
                        break;
                case 4: System.exit(0);
                        break;
                default: System.out.println("Invalid Choice");
             }
         }
     }
}
