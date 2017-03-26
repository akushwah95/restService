package org.voting.enrollment.userenrollment.resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.voting.enrollment.userenrollment.model.VoteCount;
import org.voting.enrollment.userenrollment.model.Voter;
import org.voting.enrollment.userenrollment.utils.VoterUtils;

@Path("/voter")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VoterResource {
	
	VoterUtils voterUtils =new VoterUtils();
	
	@GET
	public List<Voter> getVoter()
	{
		return voterUtils.getAllVoters();
	}
	
	@GET
	@Path("/{fingerPrint}")
	public Voter getVoter(@PathParam("fingerPrint") String fingerPrint){
	  
		return voterUtils.getVoter(fingerPrint);
	}
	
	@GET
	@Path("/votecount")
	public List<VoteCount> getVoteCount()
	{
		return voterUtils.getVoteCount();
	}
	
	@POST
	public String addVoter(Voter voter){
	  
	  boolean added = voterUtils.addVoter(voter);
	  
	  if(added)
	  return "Thank you for Voting";
	  else 
	    return "Not able to vote ";
	}
	

}
