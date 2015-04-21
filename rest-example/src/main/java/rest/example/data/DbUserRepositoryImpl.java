package rest.example.data;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import rest.example.model.User;

/**
 * @author smustafov
 */
@Stateless
public class DbUserRepositoryImpl implements UserRepository {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void add(User user) {
		entityManager.persist(user);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User remove(int id) {
		User user = getUserById(id);
		entityManager.remove(user);
		return user;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User getUserById(int id) {
		TypedQuery<User> query = entityManager.createNamedQuery("User.getUserById", User.class)
				.setParameter("id", id);
		return query.getSingleResult();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<User> getAllUsers() {
		TypedQuery<User> query = entityManager.createNamedQuery("User.getAllUsers", User.class);
		return query.getResultList();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User getUserByEmail(String email) throws NoResultException {
		User foundUser = null;
		try {
			TypedQuery<User> query = entityManager.createNamedQuery("User.getUserByEmail",
					User.class).setParameter("email", email);
			foundUser = query.getSingleResult();
		} catch (NoResultException e) {
			// no result ok to go
		}
		return foundUser;
	}
}
