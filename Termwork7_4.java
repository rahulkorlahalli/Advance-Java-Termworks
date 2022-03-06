//TERMWORK 7
//7.4) Program to demonstrate transaction processing

import java.sql.*;
/**
 *
 * @author Rahul
 */
public class Termwork7_4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
        Savepoint sp1 = null;
        Connection con = null;
        try {
            // TODO code application logic here
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tw7","user","password");//"jdbc:oracle:thin:@localhost:1521/XE" --> url for Oracle Database
                 
            con.setAutoCommit(false); //default value is true
            String query = "create table if not exists registration(id int PRIMARY KEY,name varchar(10),age int)";
            PreparedStatement pd = con.prepareStatement(query);
            pd.executeUpdate();
            
            String query1 = "insert into registration values('1','Rahul','20')";
            PreparedStatement pd1 = con.prepareStatement(query1);
            pd1.executeUpdate();
            
            String query2 = "insert into registration values('2','Sanyukta','20')";
            PreparedStatement pd2 = con.prepareStatement(query2);
            pd2.executeUpdate();
            
            String query3 = "insert into registration values('3','Akhilesh','20')";
            PreparedStatement pd3 = con.prepareStatement(query3);
            pd3.executeUpdate();
            
            sp1 = con.setSavepoint("sp1"); //if rollback reverts to this savepoint first 3 records will be inserted
            
            String query4 = "insert into registration values('4','Suraj','20')";
            PreparedStatement pd4 = con.prepareStatement(query4);
            pd4.executeUpdate();
            
            String query5 = "insert in registration values('5','Aarya','20')";
            PreparedStatement pd5 = con.prepareStatement(query5);
            pd5.executeUpdate();
            
            con.commit();
        } catch (SQLException ex) {
            try{
                if(sp1 == null){//If no savepoint was specified then only table will be created
                    con.rollback();
                    System.out.println("No records inserted");
                }
                else{//rolling back to savepoint sp1
                    con.rollback(sp1);
                    con.commit();
                    System.out.println("Inserted Records before savepoint");
                }
            }
            catch(SQLException e){
                e.getStackTrace();
            }
        }
    }
    
}

