package cdi.example.servlet;

import javax.enterprise.context.RequestScoped;

/**
 * @author smustafov
 */
@RequestScoped
@Special
public class MessageA implements Message {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String get() {
		return "Message A";
	}

}
