package cdi.example.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author smustafov
 */
@WebServlet("/message")
public class NewServlet extends HttpServlet {

	private static final long serialVersionUID = -7814254994329852918L;

	@Inject
	private Message message;

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
			IOException {
		resp.getWriter().write(message.get());
	}

}
