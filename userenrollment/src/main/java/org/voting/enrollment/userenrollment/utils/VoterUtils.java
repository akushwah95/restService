package org.voting.enrollment.userenrollment.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.voting.enrollment.userenrollment.model.VoteCount;
import org.voting.enrollment.userenrollment.model.Voter;
import org.voting.enrollment.userenrollment.service.DatabaseService;

public class VoterUtils {

	public VoterUtils() {}
	
	Connection con = null;
	  List<Voter> voters =null;
	  
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
	  
	  
	  public List<Voter> getAllVoters(){
		    try {
		    	voters = new ArrayList<Voter>();
		    	Voter voter;
		      ResultSet rs =null;
		          Statement stmt =getStatement();
		          if(stmt!=null){ rs=stmt.executeQuery("select * from VOTING_DETAILS"); }
		          
		          if(rs!=null){
		            while (rs.next()) {
		            	voter = new Voter();
		            	voter.setFingerPrint(rs.getString("fingerprint_Id"));
		            	voter.setHasVotedTo(rs.getString("hasvotedto"));
		            	voters.add(voter);
		              
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
		    return voters;
		}
	  
	  // get the details of voter
	  
	  	  public Voter getVoter(String fingerPrint){
		  Voter voter = null;
	    ResultSet rs =null;
	    try {
	    Statement stmt= getStatement();
	    rs = stmt!=null ? stmt.executeQuery("select * from VOTING_DETAILS where fingerPrint_id='"+fingerPrint+"'"):null;
	    if (rs!=null){
	      while (rs.next()) {
	    	  voter = new Voter();
	    	  voter.setFingerPrint(rs.getString("fingerprint_Id"));
          	 voter.setHasVotedTo(rs.getString("hasvotedto"));
          	
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
	    
	    return voter ;
	    
	  }
	  	  // Add voter details
	  	  
	  	public boolean addVoter(Voter voter){
		     int count=0;
		     try {
		       con = DatabaseService.getconnection();
		       if(con !=null){
		         Statement  stmt =con.createStatement();
		    
		      if(stmt!=null){
		         count =stmt.executeUpdate("INSERT INTO VOTING_DETAILS (fingerPrint_Id,hasvotedto) VALUES ('"+voter.getFingerPrint()+"','"+voter.getHasVotedTo()+"')");  
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
	  	
	  	//this is used to return the number of votes per party
	  	
	  public List<VoteCount> getVoteCount()
	  {   
		   List<VoteCount> voterCounts = new ArrayList<VoteCount>();
				  
		  VoteCount voteCount = null;
		  ResultSet rs =null;
		    try {
		    Statement stmt= getStatement();
		    rs = stmt!=null ? stmt.executeQuery("select count(*) as votecount,hasvotedto from VOTING_DETAILS group by hasvotedto"):null;
		    if (rs!=null){
		      while (rs.next()) {
		    	  voteCount = new VoteCount();
		    	  voteCount.setCount(rs.getString("votecount"));
		    	  voteCount.setHasVotedTo(rs.getString("hasvotedto"));
		    	  voterCounts.add(voteCount);
	          	 
	          	
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
		return voterCounts;
		  
	  }
	

}
