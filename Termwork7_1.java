//TERMWORK 7

/*7.1) Program to insert, update, delete & select records from a given table (can be any simple
table).*/

import java.sql.*;
import java.util.Scanner;

public class Termwork7_1 {

    public static void main(String[] args) throws Exception {
        int ch;
        String usn,name,branch;
        String sem1,sem2,sem3,sem4;
        Scanner sc = new Scanner(System.in);
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","c##rahul","rahul03");//Add the oracle database Username & Password
        while(true){
            System.out.println("\n-\t-\t- MENU -\t-\t-");
            System.out.println("1.Insert new student details with CGPA scored in 4 semesters");
            System.out.println("2.Display student details with CGPA between 7 & 9 in all semesters");
            System.out.println("3.Update 4th sem cgpa of a student");
            System.out.println("4.Display details of all students along with their CGPA");
            System.out.println("5.Exit");
            System.out.println("Enter your choice: ");
            ch = sc.nextInt();
            switch(ch){
                case 1: System.out.println("Enter USN:");
                        usn = sc.nextLine();
                        usn = sc.nextLine();
                        System.out.println("Enter Name:");
                        name = sc.nextLine();
                        System.out.println("Enter the branch:");
                        branch = sc.nextLine();
                        System.out.println("Enter CGPA of sem 1: ");
                        sem1 = sc.nextLine();
                        System.out.println("Enter CGPA of sem 2: ");
                        sem2 = sc.nextLine();
                        System.out.println("Enter CGPA of sem 3: ");
                        sem3 = sc.nextLine();
                        System.out.println("Enter CGPA of sem 4: ");
                        sem4 = sc.next();
                        String query1 = "insert into student values(?,?,?)";
                        PreparedStatement pd1 = con.prepareStatement(query1);
                        pd1.setString(1,usn);
                        pd1.setString(2,name);
                        pd1.setString(3,branch);
                        int n1 = pd1.executeUpdate();

                        String query2 = "insert into CGPA values(?,?,?,?,?)";
                        PreparedStatement pd2 = con.prepareStatement(query2);
                        pd2.setString(1,usn);
                        pd2.setString(2,sem1);
                        pd2.setString(3,sem2);
                        pd2.setString(4,sem3);
                        pd2.setString(5,sem4);
                        int n2 = pd2.executeUpdate();
                        if(n1>0 && n2>0){
                            System.out.println("-Data Inserted Successfully-");
                        }
                        break;

                case 2: String query = "select * from student where USN in (select USN from CGPA where (sem1>=7 AND sem1<=9) AND (sem2>=7 AND sem2<=9) AND (sem3>=7 AND sem4<=9) AND (sem4>=7 AND sem4<=9))";
                        PreparedStatement pd = con.prepareStatement(query);
                        ResultSet rs = pd.executeQuery();
                        while(rs.next()){
                            usn = rs.getString("USN");
                            name = rs.getString("name");
                            branch = rs.getString("dept");
                            System.out.println("USN: " + usn + " Name: "+ name+ " Branch: "+branch );
                        }
                        break;

                case 3: System.out.println("Enter the student USN to be updated:");
                        usn = sc.nextLine();
                        usn = sc.nextLine();
                        String query3 = "select sem4 from CGPA where USN='"+usn+"'";
                        PreparedStatement pd3 = con.prepareStatement(query3);
                        ResultSet rs3 = pd3.executeQuery();
                        rs3.next();
                        sem4 = rs3.getString("Sem4");//sem4 will have the current 4th Semester GGPA
                        System.out.println("Current 4th Sem CGPA: "+sem4);
                        System.out.println("Enter the CGPA to be updated: ");
                        sem4 = sc.nextLine();
                        String query4 = "update CGPA set sem4="+sem4+" where USN='"+usn+"'";
                        PreparedStatement pd4 = con.prepareStatement(query4);
                        int n3 = pd4.executeUpdate();
                        if(n3>0){
                            System.out.println("-CGPA updated successfully-");
                        }
                        break;
                case 4:String query5 = "select student.USN,name,dept,sem1,sem2,sem3,sem4 from student,CGPA where student.USN=CGPA.USN";
                       PreparedStatement pd5 = con.prepareStatement(query5);
                       ResultSet rs5 = pd5.executeQuery();
                       int slno=0;
                       while(rs5.next()){
                           usn = rs5.getString("USN");
                           name = rs5.getString("name");
                           branch = rs5.getString("dept");
                           sem1 = rs5.getString("sem1");
                           sem2 = rs5.getString("sem2");
                           sem3 = rs5.getString("sem3");
                           sem4 = rs5.getString("sem4");
                           System.out.println((++slno)+")"+" USN:"+usn+" Name:"+name+" Branch:"+branch);
                           System.out.println("First Semester CGPA: "+sem1);
                           System.out.println("Second Semester CGPA: "+sem2);
                           System.out.println("Third Semester CGPA: "+sem3);
                           System.out.println("Fourth Semester CGPA: "+sem4);
                           System.out.println();
                       }
                        break;
                case 5: System.exit(0);
            }
        }
    }
}
