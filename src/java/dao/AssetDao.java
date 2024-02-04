/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Assets;
import bean.Types;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import util.dbconnection;

/**
 *
 * @author Afiq
 */
public class AssetDao {
    public String addNewAsset(Assets asset)
    {
        String assetname = asset.getAssetName();
        String assetremarks = asset.getAssetRemarks();
        int assetoriginqty = asset.getAssetOriginQty();
        String assettype = asset.getTypeID();
        
        Connection con = null;
        
<<<<<<< HEAD
        String sql = "INSERT INTO Assets (assetid, assetname,assetoriginqty,assetremarks,typeid) VALUES ('AST'|| ASSETID.NEXTVAL,'"+assetname+"','"+assetoriginqty+"','"+assetremarks+"','"+assettype+"')";
=======
        String sql = "INSERT INTO ASSETS (assetid, assetname,assetoriginqty,assetremarks,typeid) VALUES ('AST'|| ASSETID.NEXTVAL,'"+assetname+"','"+assetoriginqty+"','"+assetremarks+"','"+assettype+"')";
<<<<<<< HEAD
>>>>>>> f9df239 (second commit)
=======
>>>>>>> 2f5efda (first commit)
>>>>>>> 255ebd47c260d310a0f1bfbb91f9146df2945530
        
        try
        {
             con = dbconnection.createConnection();
             PreparedStatement pstmt = con.prepareStatement(sql);
             pstmt.executeUpdate();
             String selectSql = "SELECT 'AST' || ASSETID.CURRVAL FROM DUAL";
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(selectSql);
             if (rs.next()) 
             {
                String assetid = rs.getString(1);
                return assetid;
            }

        }
        catch(SQLException ex)
        {
            ex.getMessage();
            System.out.println(ex.getMessage());
        }
        
        return "FAILED";
    }
    
    public String addCurrentAsset(Assets asset)
    {
        String assetid = asset.getAssetID();
        int assetoriginqty = asset.getAssetOriginQty();
        Connection con = null;
        
<<<<<<< HEAD
        String sql = "UPDATE Assets SET ASSETORIGINQTY = ASSETORIGINQTY + "+assetoriginqty+" WHERE ASSETID = '"+assetid+"'";
=======
        String sql = "UPDATE ASSETS SET ASSETORIGINQTY = ASSETORIGINQTY + "+assetoriginqty+" WHERE ASSETID = '"+assetid+"'";
<<<<<<< HEAD
>>>>>>> f9df239 (second commit)
=======
>>>>>>> 2f5efda (first commit)
>>>>>>> 255ebd47c260d310a0f1bfbb91f9146df2945530
        
        try
        {
             con = dbconnection.createConnection();
             PreparedStatement pstmt = con.prepareStatement(sql);
             pstmt.executeUpdate();
             return assetid;

        }
        catch(SQLException ex)
        {
            ex.getMessage();
            System.out.println(ex.getMessage());
        }
        
        return "FAILED";
    }
    
    
    public ArrayList getAll()
    {
        ArrayList<Assets> allasset = new <Assets>ArrayList();
        
       try(Connection con = dbconnection.createConnection(); 
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM Assets order by assetID asc"))
       {
           ResultSet rs = stmt.executeQuery();
           
           while(rs.next())
           {
               String assetid = rs.getString("assetID");
               String assetname = rs.getString("assetname");
               int assetqty = Integer.parseInt(rs.getString("assetoriginqty"));
               String assetremarks = rs.getString("assetremarks");
               String typeid = rs.getString("typeid");
               
               Assets asset = new Assets (assetid, assetname,assetremarks,assetqty,typeid);
               
               allasset.add(asset);
           }
       }
       catch(SQLException ex)
       {
           ex.getMessage();
           System.out.println(ex.getMessage());
       }

        return allasset;
    }

    public String getTypeID(String assetID) {
        String typeid = "";
        try(Connection con = dbconnection.createConnection(); 
        PreparedStatement stmt = con.prepareStatement("SELECT typeid FROM Assets where assetID = '"+assetID+"'"))
        {
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                typeid = rs.getString("typeid");
            }
        }
        catch(SQLException ex)
        {
           ex.getMessage();
           System.out.println(ex.getMessage());
        }
        return typeid;
    }

    public Assets getAsset(String assetID) 
    {
        Assets asset = new Assets();
        try(Connection con = dbconnection.createConnection(); 
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM Assets where assetID = '"+assetID+"'"))
        {
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
           {
               String assetid = rs.getString("assetID");
               String assetname = rs.getString("assetname");
               int assetqty = Integer.parseInt(rs.getString("assetoriginqty"));
               String assetremarks = rs.getString("assetremarks");
               String typeid = rs.getString("typeid");
               
              asset = new Assets (assetid, assetname,assetremarks,assetqty,typeid);
           }
            
        }
        catch(SQLException ex)
        {
            ex.getMessage();
            System.out.println(ex.getMessage());
        }
        
        return asset;
    }

    public String updateAssetQty(String oldasset, int oldqty, int newqty) {
        try(Connection con = dbconnection.createConnection(); 
<<<<<<< HEAD
        PreparedStatement stmt = con.prepareStatement("UPDATE Assets SET assetoriginqty = assetoriginqty - "+oldqty+" + "+newqty+" where assetid = '"+oldasset+"' "))
=======
        PreparedStatement stmt = con.prepareStatement("UPDATE assets SET assetoriginqty = assetoriginqty - "+oldqty+" + "+newqty+" where assetid = '"+oldasset+"' "))
<<<<<<< HEAD
>>>>>>> f9df239 (second commit)
=======
>>>>>>> 2f5efda (first commit)
>>>>>>> 255ebd47c260d310a0f1bfbb91f9146df2945530
        {
            ResultSet rs = stmt.executeQuery();
           
            return "SUCCESS";
            
        }
        catch(SQLException ex)
        {
            ex.getMessage();
            System.out.println(ex.getMessage());
        }
        
        return "FAILED at AssetDao";
    }

    public String updateAssetQty2(String newasset,String oldasset, int oldqty, int newqty) {
        //change at the oldasset
        try(Connection con = dbconnection.createConnection(); 
<<<<<<< HEAD
        PreparedStatement stmt = con.prepareStatement("UPDATE Assets SET assetoriginqty = assetoriginqty - "+oldqty+" where assetid = '"+oldasset+"' "))
        {
            stmt.executeQuery();
            String sqlupdate = "UPDATE Assets SET assetoriginqty = assetoriginqty + "+newqty+" where assetid = '"+newasset+"'";
=======
        PreparedStatement stmt = con.prepareStatement("UPDATE assets SET assetoriginqty = assetoriginqty - "+oldqty+" where assetid = '"+oldasset+"' "))
        {
            stmt.executeQuery();
            String sqlupdate = "UPDATE assets SET assetoriginqty = assetoriginqty + "+newqty+" where assetid = '"+newasset+"'";
<<<<<<< HEAD
>>>>>>> f9df239 (second commit)
=======
>>>>>>> 2f5efda (first commit)
>>>>>>> 255ebd47c260d310a0f1bfbb91f9146df2945530
            Statement stmt1 = con.createStatement();
          
            ResultSet rs = stmt1.executeQuery(sqlupdate);
            return "SUCCESS";

        }
        catch(SQLException ex)
        {
            ex.getMessage();
            System.out.println(ex.getMessage());
        }
        
        return "FAILED at AssetDao";
    }

    public String updateAssetQty3(String oldassetid, int oldqty) {
       try(Connection con = dbconnection.createConnection(); 
<<<<<<< HEAD
        PreparedStatement stmt = con.prepareStatement("UPDATE Assets SET assetoriginqty = assetoriginqty - "+oldqty+" where assetid = '"+oldassetid+"' "))
=======
        PreparedStatement stmt = con.prepareStatement("UPDATE assets SET assetoriginqty = assetoriginqty - "+oldqty+" where assetid = '"+oldassetid+"' "))
<<<<<<< HEAD
>>>>>>> f9df239 (second commit)
=======
>>>>>>> 2f5efda (first commit)
>>>>>>> 255ebd47c260d310a0f1bfbb91f9146df2945530
        {
            ResultSet rs = stmt.executeQuery();
            return "SUCCESS";
            
        }
        catch(SQLException ex)
        {
            ex.getMessage();
            System.out.println(ex.getMessage());
        }
        
        return "FAILED at AssetDao";
    }

    public String updateAssetDetail(Assets asset) 
    {
        String assetname = asset.getAssetName();
        int assetqty = asset.getAssetOriginQty();
        String assetremarks = asset.getAssetRemarks();
        String assettype = asset.getTypeID();
        String assetid = asset.getAssetID();
        
        try(Connection con = dbconnection.createConnection(); 
<<<<<<< HEAD
        PreparedStatement stmt = con.prepareStatement("UPDATE Assets SET assetname='"+assetname+"',assetoriginqty='"+assetqty+"',assetremarks='"+assetremarks+"',typeid='"+assettype+"' where assetid = '"+assetid+"' "))
=======
        PreparedStatement stmt = con.prepareStatement("UPDATE assets SET assetname='"+assetname+"',assetoriginqty='"+assetqty+"',assetremarks='"+assetremarks+"',typeid='"+assettype+"' where assetid = '"+assetid+"' "))
<<<<<<< HEAD
>>>>>>> f9df239 (second commit)
=======
>>>>>>> 2f5efda (first commit)
>>>>>>> 255ebd47c260d310a0f1bfbb91f9146df2945530
        {
            ResultSet rs = stmt.executeQuery();
            return "SUCCESS";
        }
        catch(SQLException ex)
        {
            ex.getMessage();
            System.out.println(ex.getMessage());
        }
        
        return "FAILED at AssetDao";
    }
    
    public int findMax(){
        int quantity=0;
        try(Connection con = dbconnection.createConnection(); 
<<<<<<< HEAD
        PreparedStatement stmt = con.prepareStatement("SELECT max(assetoriginqty) as \"max\" FROM Assets"))
=======
        PreparedStatement stmt = con.prepareStatement("SELECT max(assetoriginqty) as \"max\" FROM assets"))
<<<<<<< HEAD
>>>>>>> f9df239 (second commit)
=======
>>>>>>> 2f5efda (first commit)
>>>>>>> 255ebd47c260d310a0f1bfbb91f9146df2945530
        {
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                quantity = Integer.parseInt(rs.getString("max"));
            }
        }
        catch(SQLException ex)
        {
           ex.getMessage();
           System.out.println(ex.getMessage());
        }
        
        return quantity;
    }
    
    public int findMin(){
        int quantity=0;
        try(Connection con = dbconnection.createConnection(); 
<<<<<<< HEAD
        PreparedStatement stmt = con.prepareStatement("SELECT min(assetoriginqty) as \"min\" FROM Assets"))
=======
        PreparedStatement stmt = con.prepareStatement("SELECT min(assetoriginqty) as \"min\" FROM assets"))
<<<<<<< HEAD
>>>>>>> f9df239 (second commit)
=======
>>>>>>> 2f5efda (first commit)
>>>>>>> 255ebd47c260d310a0f1bfbb91f9146df2945530
        {
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                quantity = Integer.parseInt(rs.getString("min"));
            }
        }
        catch(SQLException ex)
        {
           ex.getMessage();
           System.out.println(ex.getMessage());
        }
        
        return quantity;
    }
    
<<<<<<< HEAD
    public int findAvg(){
        int quantity=0;
        try(Connection con = dbconnection.createConnection(); 
        PreparedStatement stmt = con.prepareStatement("SELECT avg(assetoriginqty) as \"average\" FROM Assets"))
=======
    public double findAvg(){
        double quantity=0;
        try(Connection con = dbconnection.createConnection(); 
        PreparedStatement stmt = con.prepareStatement("SELECT avg(assetoriginqty) as \"average\" FROM assets"))
<<<<<<< HEAD
>>>>>>> f9df239 (second commit)
=======
>>>>>>> 2f5efda (first commit)
>>>>>>> 255ebd47c260d310a0f1bfbb91f9146df2945530
        {
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
<<<<<<< HEAD
                quantity = Integer.parseInt(rs.getString("average"));
=======
                quantity = Double.parseDouble(rs.getString("average"));
<<<<<<< HEAD
>>>>>>> f9df239 (second commit)
=======
>>>>>>> 2f5efda (first commit)
>>>>>>> 255ebd47c260d310a0f1bfbb91f9146df2945530
            }
        }
        catch(SQLException ex)
        {
           ex.getMessage();
           System.out.println(ex.getMessage());
        }
        
        return quantity;
    }
    
}
