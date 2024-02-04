/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
<<<<<<< HEAD
import java.sql.ResultSet;
import java.sql.Statement;
=======
<<<<<<< HEAD
>>>>>>> f9df239 (second commit)
=======
>>>>>>> 2f5efda (first commit)
>>>>>>> 255ebd47c260d310a0f1bfbb91f9146df2945530

/**
 *
 * @author Afiq
 */
public class dbconnection {
    public static Connection createConnection()
<<<<<<< HEAD
    {   
        //String driver = "org.apache.derby.jdbc.ClientDriver";
        String driver = "com.mysql.cj.jdbc.Driver";
        String connectionString = "jdbc:mysql://sql12.freesqldatabase.com/sql12678595";
=======
    {   String driver = "org.apache.derby.jdbc.ClientDriver";
        String connectionString = "jdbc:oracle:thin:@DESKTOP-CI7HVFT:1521:XE";
<<<<<<< HEAD
>>>>>>> f9df239 (second commit)
=======
>>>>>>> 2f5efda (first commit)
>>>>>>> 255ebd47c260d310a0f1bfbb91f9146df2945530
        try
        {
            Class.forName(driver);
            System.out.println("Connected");
<<<<<<< HEAD
            return DriverManager.getConnection(connectionString,"sql12678595","f7XaxC5S4z");
=======
            return DriverManager.getConnection(connectionString,"ITAM_FYP","123");
<<<<<<< HEAD
>>>>>>> f9df239 (second commit)
=======
>>>>>>> 2f5efda (first commit)
>>>>>>> 255ebd47c260d310a0f1bfbb91f9146df2945530
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
<<<<<<< HEAD
        
        
       
=======
<<<<<<< HEAD
>>>>>>> f9df239 (second commit)
=======
>>>>>>> 2f5efda (first commit)
>>>>>>> 255ebd47c260d310a0f1bfbb91f9146df2945530
    } 
}
