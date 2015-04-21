package rest.example.data;

import java.util.List;

import rest.example.model.User;

/**
 * Defines user repository operations
 * 
 * @author smustafov
 */
public interface UserRepository {

	/**
	 * Adds given user.
	 * 
	 * @param user
	 *            - the user to be added
	 */
	void add(User user);

	/**
	 * Removes user with given id.
	 * 
	 * @param id
	 *            - the id of the user to be removed
	 * @return - the removed user
	 */
	User remove(int id);

	/**
	 * Gets a user by id.
	 * 
	 * @param id
	 *            - the id of the user
	 * @return - the user with the given id
	 */
	User getUserById(int id);

	/**
	 * Gets all the users.
	 * 
	 * @return - list of the users
	 */
	List<User> getAllUsers();

	/**
	 * Finds and returns {@link User} with given email.
	 * 
	 * @param email
	 *            - the email of the user to be found
	 * @return the found user; if there is no user with that email returns null
	 */
	User getUserByEmail(String email);

}
