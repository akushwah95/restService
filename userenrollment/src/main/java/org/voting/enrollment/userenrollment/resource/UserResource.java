package org.voting.enrollment.userenrollment.resource;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.voting.enrollment.userenrollment.model.User;
import org.voting.enrollment.userenrollment.utils.UserUtils;


@Path("/items")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {
UserUtils userUtils =new UserUtils();
	
	@GET
	public List<User> getItems()
	{
		return userUtils.getAllUsers();
	}
	
	@GET
	@Path("/{fingerPrint}")
	public User getItem(@PathParam("fingerPrint") String fingerPrint){
	  
		return userUtils.getUser(fingerPrint);
	}
	
	@POST
	public String addItem(User user){
	  
	  boolean added = userUtils.addUser(user);
	  
	  if(added)
	  return "User is added";
	  else 
	    return "Not able to added ";
	}
	
	@PUT
   public String updateItem(User user){
    
    boolean added = userUtils.updateUser(user);
    
    if(added)
    return "User is Updated";
    else 
      return "Not able to update";
  }
	 
	@DELETE
	@Path("/{fingerPrint}")
   public String deleteItem(@PathParam("fingerPrint") String fingerPrint){
    
    return userUtils.removeUser(fingerPrint);
    
  
  }

}
