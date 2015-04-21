package rest.example.data;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import rest.example.annotations.InMemory;
import rest.example.model.User;

/**
 * @author smustafov
 */
@ApplicationScoped
@InMemory
public class InMemoryUserRepositoryImpl implements UserRepository {

	private List<User> users = new ArrayList<>();

	public InMemoryUserRepositoryImpl() {
		User user = new User();
		user.setName("Sinan Mustafov");
		user.setEmail("sinan@gmail.com");
		user.setAge(22);
		users.add(user);
	}

	@Override
	public void add(User user) {
		users.add(user);
	}

	@Override
	public User remove(int id) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId() == id) {
				return users.remove(i);
			}
		}
		return null;
	}

	@Override
	public User getUserById(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		return users;
	}

}
