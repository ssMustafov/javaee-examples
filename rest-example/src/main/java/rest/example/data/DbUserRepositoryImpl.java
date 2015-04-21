package rest.example.data;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
		return entityManager.find(User.class, id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<User> getAllUsers() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> criteria = builder.createQuery(User.class);
		Root<User> user = criteria.from(User.class);
		criteria.select(user);
		return entityManager.createQuery(criteria).getResultList();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User getUserByEmail(String email) throws NoResultException {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> criteria = builder.createQuery(User.class);
		Root<User> user = criteria.from(User.class);
		criteria.select(user).where(builder.equal(user.get("email"), email));

		User foundUser = null;
		try {
			foundUser = entityManager.createQuery(criteria).getSingleResult();
		} catch (NoResultException e) {
			// no result ok to go
		}

		return foundUser;
	}

}
