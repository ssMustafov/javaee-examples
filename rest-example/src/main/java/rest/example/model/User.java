package rest.example.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

/**
 * Represents a user.
 * 
 * @author smustafov
 */
@Entity(name = "appuser")
@NamedQueries({
		@NamedQuery(name = "User.getAllUsers", query = "SELECT auser FROM appuser auser"),
		@NamedQuery(name = "User.getUserById", query = "SELECT auser FROM appuser auser WHERE auser.id = :id"),
		@NamedQuery(name = "User.getUserByEmail", query = "SELECT auser FROM appuser auser WHERE auser.email = :email") })
public class User implements Serializable {

	private static final long serialVersionUID = -1304362844502161162L;

	@Id
	@GeneratedValue
	private int id;

	@NotNull
	@Size(min = 2, max = 100, message = "name's size must be in 2-100")
	@Pattern(regexp = "[^0-9]*", message = "name cannot contain numbers")
	private String name;

	@NotNull
	@Email(message = "invalid email format")
	@Size(min = 6, max = 50, message = "too long email")
	private String email;

	@Digits(fraction = 1, integer = 100, message = "not valid age")
	private int age;

	/**
	 * Setter method for id.
	 *
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

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
