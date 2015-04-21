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
 * Defines operations for the rest service.
 * 
 * @author smustafov
 */
@Path("users")
public interface UsersResource {

	/**
	 * Returns json with the all users.
	 * 
	 * @return - all users' data as json
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	List<User> getAllUsers();

	/**
	 * Returns {@link User}'s data in json.
	 * 
	 * @param id
	 *            - the id of the user
	 * @return - user data as json
	 */
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	User getUserById(@PathParam("id") int id);

	/**
	 * Removes a {@link User} by id.
	 * 
	 * @param id
	 *            - the id of the user to be removed
	 */
	@DELETE
	@Path("/{id}")
	void removeUser(@PathParam("id") int id);

	/**
	 * Adds new {@link User}. It gets user's parameters from the Http POST request.
	 * 
	 * @param name
	 *            - name of the user to be added
	 * @param email
	 *            - email of the user to be added
	 * @param age
	 *            - age of the user to be added
	 * @param addresses
	 *            - list of address of the user
	 */
	@POST
	void addUser(@FormParam("name") String name, @FormParam("email") String email,
			@FormParam("age") int age);

}
