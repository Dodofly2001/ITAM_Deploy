/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import bean.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.dbconnection;
import java.util.ArrayList;

/**
 *
 * @author Afiq
 */
public class UsersDao {
    public Users findAccount(Users userlogin)
    {
       
        String email = userlogin.getUserEmail();
        String password = userlogin.getUserPassword();
        
        try(Connection con = dbconnection.createConnection(); 
<<<<<<< HEAD
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM Users WHERE useremail = ? AND userpassword = ? "))
=======
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM users WHERE useremail = ? AND userpassword = ? "))
<<<<<<< HEAD
>>>>>>> f9df239 (second commit)
=======
>>>>>>> 2f5efda (first commit)
>>>>>>> 255ebd47c260d310a0f1bfbb91f9146df2945530
            
        {
            
            stmt.setString(1, email);
            stmt.setString(2, password);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
             {          
                 String userid = rs.getString("userid");
                 String userfullname = rs.getString("userfullname");
                 String username = rs.getString("username");
                 String usercat = rs.getString("usercategoriesid");
                 
                 userlogin.setUserID(userid);
                 userlogin.setUserFullName(userfullname);
                 userlogin.setUserName(username);//might be remove soon 
                 userlogin.setUserCategories(usercat);
                
            }
        }
        catch(SQLException ex)
        {
            
        }
        
       return userlogin;
    }
    
    public String verifyUser(Users custlogin)
    {
       
        String email = custlogin.getUserEmail();
        String password = custlogin.getUserPassword();
       
        try(Connection con = dbconnection.createConnection(); 
<<<<<<< HEAD
            PreparedStatement stmt = con.prepareStatement("SELECT useremail,userpassword FROM Users WHERE useremail = ? AND userpassword = ? "))
=======
            PreparedStatement stmt = con.prepareStatement("SELECT useremail,userpassword FROM users WHERE useremail = ? AND userpassword = ? "))
<<<<<<< HEAD
>>>>>>> f9df239 (second commit)
=======
>>>>>>> 2f5efda (first commit)
>>>>>>> 255ebd47c260d310a0f1bfbb91f9146df2945530
            
        {
            
            stmt.setString(1, email);
            stmt.setString(2, password);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
             {          
                 
                 String emailDB = rs.getString("useremail");
                 String passDB = rs.getString("userpassword");
                
                if(email.equals(emailDB) && password.equals(passDB))
                {
                    return "SUCCESS";
                }
            }
        }
        catch(SQLException ex)
        {
            //close(con);
        }
        
        return "Invalid user credentials";
        
    }

    public Users getUsers(String userid) {
        
        Users user = new Users();
        try(Connection con = dbconnection.createConnection(); 
<<<<<<< HEAD
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM Users WHERE userid ='"+userid+"'"))
=======
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM users WHERE userid ='"+userid+"'"))
<<<<<<< HEAD
>>>>>>> f9df239 (second commit)
=======
>>>>>>> 2f5efda (first commit)
>>>>>>> 255ebd47c260d310a0f1bfbb91f9146df2945530
            
        {
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
             {          
                 
                 String userfullname = rs.getString("userfullname");
                 String username = rs.getString("username");
                 String useremail = rs.getString("useremail");
                 String userphonenum = rs.getString("userphonenum");
                 String usercat = rs.getString("usercategoriesid");
                 String userpass = rs.getString("userpassword");
                 String servid = rs.getString("servicesid");
                 
                 user = new Users(userid,username,userpass,useremail,userfullname,userphonenum,servid,usercat); 
                
            }
        }
        catch(SQLException ex)
        {
            ex.getMessage();
        }
        
       return user;
    }

    public String userUpdate(Users user) {
        
        String userID = user.getUserID();
        String userName = user.getUserName();
        String userPassword = user.getUserPassword();
        String userEmail = user.getUserEmail();
        String userFullName = user.getUserFullName();
        String userPhoneNum = user.getUserPhoneNum();
        
        try(Connection con = dbconnection.createConnection(); 
<<<<<<< HEAD
        PreparedStatement stmt = con.prepareStatement("UPDATE Users set username='"+userName+"', useremail='"+userEmail+"', userpassword='"+userPassword+"', userfullname='"+userFullName+"', userphonenum='"+userPhoneNum+"' where userid = '"+userID+"'"))
=======
        PreparedStatement stmt = con.prepareStatement("UPDATE users set username='"+userName+"', useremail='"+userEmail+"', userpassword='"+userPassword+"', userfullname='"+userFullName+"', userphonenum='"+userPhoneNum+"' where userid = '"+userID+"'"))
<<<<<<< HEAD
>>>>>>> f9df239 (second commit)
=======
>>>>>>> 2f5efda (first commit)
>>>>>>> 255ebd47c260d310a0f1bfbb91f9146df2945530
            
        {
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
             {          
                 
                return "SUCCESS";
            }
        }
        catch(SQLException ex)
        {
            ex.getMessage();
        }
        return "FAILED";
    }

    public String userVerifyEmail(Users user) {
        String useremail = user.getUserEmail();
        String userid = user.getUserID();
<<<<<<< HEAD
        String checkemail = "SELECT useremail FROM Users WHERE userid <> '"+userid+"'";
=======
        String checkemail = "SELECT useremail FROM users WHERE userid <> '"+userid+"'";
<<<<<<< HEAD
>>>>>>> f9df239 (second commit)
=======
>>>>>>> 2f5efda (first commit)
>>>>>>> 255ebd47c260d310a0f1bfbb91f9146df2945530
        
        try {
            Connection con = dbconnection.createConnection();
            PreparedStatement pstmt = con.prepareStatement(checkemail);
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()){
                String retrieveemail = resultSet.getString(1);
                if (retrieveemail.equals(useremail)) {
                    return "ERROR";
                }
            }
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "SUCCESS";
    }

    public ArrayList getAll() {
        ArrayList <Users>alluser = new ArrayList();
        Users user = new Users();
        try(Connection con = dbconnection.createConnection(); 
<<<<<<< HEAD
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM Users"))
=======
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM users"))
<<<<<<< HEAD
>>>>>>> f9df239 (second commit)
=======
>>>>>>> 2f5efda (first commit)
>>>>>>> 255ebd47c260d310a0f1bfbb91f9146df2945530
            
        {
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
             {          
                 String userid = rs.getString("userid");
                 String userfullname = rs.getString("userfullname");
                 String username = rs.getString("username");
                 String useremail = rs.getString("useremail");
                 String userphonenum = rs.getString("userphonenum");
                 String usercat = rs.getString("usercategoriesid");
                 String userpass = rs.getString("userpassword");
                 String servid = rs.getString("servicesid");
                 
                 user = new Users(userid,username,userpass,useremail,userfullname,userphonenum,servid,usercat); 
                 alluser.add(user);
            }
        }
        catch(SQLException ex)
        {
            ex.getMessage();
        }
        
       return alluser;
    }

    public String updatePass(String userid, String newpass) {
          try(Connection con = dbconnection.createConnection(); 
<<<<<<< HEAD
        PreparedStatement stmt = con.prepareStatement("UPDATE Users set userpassword='"+newpass+"'where userid = '"+userid+"'"))           
=======
        PreparedStatement stmt = con.prepareStatement("UPDATE users set userpassword='"+newpass+"'where userid = '"+userid+"'"))           
<<<<<<< HEAD
>>>>>>> f9df239 (second commit)
=======
>>>>>>> 2f5efda (first commit)
>>>>>>> 255ebd47c260d310a0f1bfbb91f9146df2945530
        {
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
             {          
                 
                return "SUCCESS";
            }
        }
        catch(SQLException ex)
        {
            ex.getMessage();
        }
        return "FAILED";
    }

    public String updateCat(String userid, String catid) {
         try(Connection con = dbconnection.createConnection(); 
<<<<<<< HEAD
        PreparedStatement stmt = con.prepareStatement("UPDATE Users set usercategoriesid='"+catid+"'where userid = '"+userid+"'"))           
=======
        PreparedStatement stmt = con.prepareStatement("UPDATE users set usercategoriesid='"+catid+"'where userid = '"+userid+"'"))           
<<<<<<< HEAD
>>>>>>> f9df239 (second commit)
=======
>>>>>>> 2f5efda (first commit)
>>>>>>> 255ebd47c260d310a0f1bfbb91f9146df2945530
        {
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
             {          
                 
                return "SUCCESS";
            }
        }
        catch(SQLException ex)
        {
            ex.getMessage();
        }
        return "FAILED";
    }

    public String find(String userid) {
        String userfullname = "";
        try(Connection con = dbconnection.createConnection(); 
<<<<<<< HEAD
        PreparedStatement stmt = con.prepareStatement("select userfullname from Users where userid = '"+userid+"'")) 
=======
        PreparedStatement stmt = con.prepareStatement("select userfullname from users where userid = '"+userid+"'")) 
<<<<<<< HEAD
>>>>>>> f9df239 (second commit)
=======
>>>>>>> 2f5efda (first commit)
>>>>>>> 255ebd47c260d310a0f1bfbb91f9146df2945530
        {
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                userfullname = rs.getString("userfullname");
                return userfullname;
            }
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return "ERROR: Users; find";
    }
    
    
}
