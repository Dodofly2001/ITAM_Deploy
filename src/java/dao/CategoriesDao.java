/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Categories;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import util.dbconnection;
/**
 *
 * @author Afiq
 */
public class CategoriesDao {
    
    private PreparedStatement pstmt;
    public String test()
    {
        String result = null;
        Connection conn = null;
        Statement statement = null; 
        ResultSet rs = null;
        try
        {
            conn = dbconnection.createConnection();
            statement = conn.createStatement(); 
<<<<<<< HEAD
            rs = statement.executeQuery("select * from Categories");
=======
            rs = statement.executeQuery("select * from categories");
<<<<<<< HEAD
>>>>>>> f9df239 (second commit)
=======
>>>>>>> 2f5efda (first commit)
>>>>>>> 255ebd47c260d310a0f1bfbb91f9146df2945530
            if(rs.next())
            {
                result="connected";
                result = rs.getString(1);
            }
            else
            {
                result="no database";
            }
            
        }
        catch(SQLException e){
            e.printStackTrace();
        } 
        
       return result ;
    }

    public ArrayList getAll() 
    {
       System.out.println("in dao");
       ArrayList <Categories> allcat = new ArrayList();
       Categories cat = new Categories();
       try(Connection con = dbconnection.createConnection(); 
<<<<<<< HEAD
       PreparedStatement stmt = con.prepareStatement("SELECT * FROM Categories"))
=======
       PreparedStatement stmt = con.prepareStatement("SELECT * FROM categories"))
<<<<<<< HEAD
>>>>>>> f9df239 (second commit)
=======
>>>>>>> 2f5efda (first commit)
>>>>>>> 255ebd47c260d310a0f1bfbb91f9146df2945530
       {
           ResultSet rs = stmt.executeQuery();
           while(rs.next())
           {
                String catid = rs.getString("usercategoriesid");
                String catdetail = rs.getString("usercategoriesdetail");
                
                cat = new Categories(catid,catdetail);
                allcat.add(cat);
           }
      
       }
       catch(SQLException ex)
       {
            ex.getMessage();
       }
       return allcat;
    }
    
}
