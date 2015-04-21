package rest.example.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Represents a user.
 * 
 * @author smustafov
 */
@Entity(name = "appuser")
public class User implements Serializable {

	private static final long serialVersionUID = -1304362844502161162L;

	@Id
	@GeneratedValue
	private int id;

	private String name;
	private String email;
	private int age;

	/**
	 * Getter method for id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Getter method for age.
	 *
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Setter method for age.
	 *
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Getter method for name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter method for name.
	 *
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter method for email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter method for email.
	 *
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}
