package org.voting.enrollment.userenrollment.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.voting.enrollment.userenrollment.model.User;
import org.voting.enrollment.userenrollment.service.DatabaseService;

public class UserUtils {
	
	public UserUtils() {}
	  Connection con = null;
	  List<User> users =null;
	  
	  private Statement getStatement(){
	    Statement stmt=null;
	    try {
	      con = DatabaseService.getconnection();
	      if(con !=null){
	          stmt =con.createStatement();
	         } 
	      return stmt;
	    }catch (SQLException e) {
	          e.printStackTrace();
	        }
	    return stmt;
	    
	  }

	  public List<User> getAllUsers(){
	    try {
	    	users = new ArrayList<User>();
	    	User user;
	      ResultSet rs =null;
	          Statement stmt =getStatement();
	          if(stmt!=null){ rs=stmt.executeQuery("select * from NAME_RECORDS_DETAILS"); }
	          
	          if(rs!=null){
	            while (rs.next()) {
	            	user = new User();
	            	user.setFingerPrint(rs.getString("barcode_Id"));
	            	user.setName(rs.getString("product_name"));
	            	user.setDob(rs.getString("price"));
	            	user.setAddress(rs.getString("discounted_price"));
	            	user.setMobileNumber(rs.getInt("quantity"));
	            	user.setFatherName(rs.getString("price"));
	            	user.setMotherName(rs.getString("discounted_price"));
	            	users.add(user);
	              
	          }
	            rs.close();
	          }       
	         
	       
	      
	    }catch (SQLException e) {
	          e.printStackTrace();
	        }finally{
	          if(con!=null)
	          {
	            try {
	              con.close();
	            } catch (SQLException e) {
	              
	              e.printStackTrace();
	            }
	          }
	          
	        }
	    return users;
	}
	  
	  public User getUser(String fingerPrint){
		  User user = new User();
	    ResultSet rs =null;
	    try {
	    Statement stmt= getStatement();
	    rs = stmt!=null ? stmt.executeQuery("select * from NAME_RECORDS_DETAILS where fingerPrint_id='"+fingerPrint+"'"):null;
	    if (rs!=null){
	      while (rs.next()) {
	      
	        user.setFingerPrint(rs.getString("barcode_Id"));
          	user.setName(rs.getString("product_name"));
          	user.setDob(rs.getString("price"));
          	user.setAddress(rs.getString("discounted_price"));
          	user.setMobileNumber(rs.getInt("quantity"));
          	user.setFatherName(rs.getString("price"));
          	user.setMotherName(rs.getString("discounted_price"));
	      } }
	    }catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	      }finally{
	        if(con!=null)
	        {
	          try {
	            con.close();
	            rs.close();
	          } catch (SQLException e) {
	            
	            e.printStackTrace();
	          }
	        }
	        
	      }
	    
	    return user ;
	    
	  }

	   public boolean addUser(User user){
	     int count=0;
	     try {
	       con = DatabaseService.getconnection();
	       if(con !=null){
	         Statement  stmt =con.createStatement();
	    
	      if(stmt!=null){
	         count =stmt.executeUpdate("INSERT INTO NAME_RECORDS_DETAILS (fingerPrint_Id,voter_name,dob,address,father_name,mother_name,mobile_number) VALUES ('"+user.getFingerPrint()+"','"+user.getName()+"',"+user.getDob()+","+user.getAddress()+","+user.getFatherName()+","+user.getMotherName()+","+user.getMobileNumber()+")");  
	      }
	       }
	       }catch (SQLException e) {
	           // TODO Auto-generated catch block
	           e.printStackTrace();
	         }finally{
	           if(con!=null)
	           {
	             try {
	               con.close();
	             } catch (SQLException e) {
	               
	               e.printStackTrace();
	             }
	           }
	           
	         }
	     if (count>0){
	       return true;
	     }
	     else 
	      return false;
	   }
	   
	   
	   public boolean updateUser(User user){
	     int count=0;
	     try {
	       con = DatabaseService.getconnection();
	       if(con !=null){
	         Statement  stmt =con.createStatement();
	    
	      if(stmt!=null){
	         stmt.executeUpdate("DELETE from NAME_RECORDS_DETAILS where fingerPrint_id='"+user.getFingerPrint()+"'");
	         count =stmt.executeUpdate("INSERT INTO NAME_RECORDS_DETAILS (fingerPrint_Id,voter_name,dob,address,father_name,mother_name,mobile_number) VALUES ('"+user.getFingerPrint()+"','"+user.getName()+"',"+user.getDob()+","+user.getAddress()+","+user.getFatherName()+","+user.getMotherName()+","+user.getMobileNumber()+")");  
	      }
	       }
	       }catch (SQLException e) {
	           // TODO Auto-generated catch block
	           e.printStackTrace();
	         }finally{
	           if(con!=null)
	           {
	             try {
	               con.close();
	             } catch (SQLException e) {
	               
	               e.printStackTrace();
	             }
	           }
	           
	         }
	     if (count>0){
	       return true;
	     }
	     else 
	      return false;
	   }
	   
	   public String removeUser(String fingerPrint){
	     int count=0;
	     User user= new User();
	     ResultSet rs =null;
	     try {
	       con = DatabaseService.getconnection();
	       if(con !=null){
	         Statement  stmt =con.createStatement();
	         rs = stmt!=null ? stmt.executeQuery("select * from NAME_RECORDS_DETAILS where fingerPrint_id='"+fingerPrint+"'"):null;
	         if (rs!=null){
	           while (rs.next()) {
	        	   user.setFingerPrint(rs.getString("barcode_Id"));
	             	user.setName(rs.getString("product_name"));
	             	user.setDob(rs.getString("price"));
	             	user.setAddress(rs.getString("discounted_price"));
	             	user.setMobileNumber(rs.getInt("quantity"));
	             	user.setFatherName(rs.getString("price"));
	             	user.setMotherName(rs.getString("discounted_price"));
	           } }
	    
	      if(stmt!=null){
	           
	         count =  stmt.executeUpdate("DELETE from NAME_RECORDS_DETAILS where fingerPrint_id='"+user.getFingerPrint()+"'");
	      }
	       }
	       }catch (SQLException e) {
	           // TODO Auto-generated catch block
	           e.printStackTrace();
	         }finally{
	           if(con!=null)
	           {
	             try {
	               con.close();
	               rs.close();
	             } catch (SQLException e) {
	               
	               e.printStackTrace();
	             }
	           }
	           
	         }
	     if (count>0){
	       return "User is removed :"+user.getFingerPrint()+" :"+user.getName();
	     }
	     else 
	     return "User is  not removed";
	   }

}
