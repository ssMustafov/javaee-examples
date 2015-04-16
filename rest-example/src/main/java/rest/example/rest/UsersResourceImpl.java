package rest.example.rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import rest.example.data.UserRepository;
import rest.example.model.User;

/**
 * @author smustafov
 */
@RequestScoped
public class UsersResourceImpl implements UsersResource {

	@Inject
	private UserRepository repository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<User> getAllUsers() {
		return repository.getAllUsers();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User getUserById(int id) {
		User user = repository.getUserById(id);
		if (user == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		return user;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeUser(int id) {
		User removedUser = repository.remove(id);
		if (removedUser == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addUser(String name, String email, int age) {
		User user = new User();
		user.setAge(age);
		user.setEmail(email);
		user.setName(name);
		repository.add(user);
	}

}
