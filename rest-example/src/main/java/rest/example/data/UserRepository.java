package rest.example.data;

import java.util.ArrayList;
import java.util.List;

import rest.example.model.User;

/**
 * @author smustafov
 */
public class UserRepository {

	private static UserRepository instance = new UserRepository();
	private List<User> users = new ArrayList<>();

	private UserRepository() {
		User user = new User();
		user.setName("Sinan Mustafov");
		user.setEmail("sinan@gmail.com");
		user.setAge(22);
		users.add(user);
	}

	public static UserRepository getInstance() {
		return instance;
	}

	public void add(User user) {
		users.add(user);
	}

	public void remove(int id) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId() == id) {
				users.remove(i);
				break;
			}
		}
	}

	public User getUserById(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	public List<User> getAllUsers() {
		return users;
	}

}
