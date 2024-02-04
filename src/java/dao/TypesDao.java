/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Types;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.dbconnection;

/**
 *
 * @author Afiq
 */
public class TypesDao {
    public ArrayList getAll()
    {
        ArrayList<Types> alltypes = new <Types>ArrayList();
        
       try(Connection con = dbconnection.createConnection(); 
<<<<<<< HEAD
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM Types"))
=======
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM types"))
<<<<<<< HEAD
>>>>>>> f9df239 (second commit)
=======
>>>>>>> 2f5efda (first commit)
>>>>>>> 255ebd47c260d310a0f1bfbb91f9146df2945530
       {
           ResultSet rs = stmt.executeQuery();
           
           while(rs.next())
           {
               String typeid = rs.getString("typeID");
               String typedetails = rs.getString("typeDetails");
               
               Types type = new Types (typeid, typedetails);
               
               alltypes.add(type);
           }
       }
       catch(SQLException ex)
       {
           
       }
        
        
        return alltypes;
    }
}
