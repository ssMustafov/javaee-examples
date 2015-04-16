package rest.example.data;

import java.util.List;

import rest.example.model.User;

/**
 * @author smustafov
 */
public interface UserRepository {

	void add(User user);

	User remove(int id);

	User getUserById(int id);

	List<User> getAllUsers();

}
