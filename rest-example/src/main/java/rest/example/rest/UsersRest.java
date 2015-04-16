package rest.example.rest;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import rest.example.data.UserRepository;
import rest.example.model.User;

/**
 * @author smustafov
 */
@Path("users")
public class UsersRest {

	private UserRepository repository = UserRepository.getInstance();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getAllUsers() {
		return repository.getAllUsers();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserById(@PathParam("id") int id) {
		User user = repository.getUserById(id);
		if (user == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		return user;
	}

	@POST
	public void addUser(@FormParam("name") String name, @FormParam("email") String email,
			@FormParam("age") int age) {
		User user = new User();
		user.setAge(age);
		user.setEmail(email);
		user.setName(name);
		repository.add(user);
	}

}
