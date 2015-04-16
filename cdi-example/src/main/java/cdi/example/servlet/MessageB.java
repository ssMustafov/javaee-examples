package cdi.example.servlet;

import javax.enterprise.context.RequestScoped;

/**
 * @author smustafov
 */
@RequestScoped
public class MessageB implements Message {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String get() {
		return "Message B";
	}

}
