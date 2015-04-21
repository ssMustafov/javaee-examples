package rest.example.data;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import rest.example.model.User;

/**
 * @author smustafov
 */
@Stateless
public class DbUserRepositoryImpl implements UserRepository {

	// @PersistenceUnit(unitName = "rest-example")
	// private EntityManagerFactory entityManager;
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void add(User user) {

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User remove(int id) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User getUserById(int id) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<User> getAllUsers() {
		return (List<User>) entityManager.createQuery("from appuser").getResultList();
	}

}
