package rest.example.rest;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import rest.example.model.User;

/**
 * @author smustafov
 */
@Path("users")
public interface UsersResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	List<User> getAllUsers();

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	User getUserById(@PathParam("id") int id);

	@DELETE
	@Path("/{id}")
	void removeUser(@PathParam("id") int id);

	@POST
	void addUser(@FormParam("name") String name, @FormParam("email") String email,
			@FormParam("age") int age);

}
