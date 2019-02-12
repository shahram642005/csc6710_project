package jokeproject;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List; 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/***************************************************
 * UserDAO.java
 * This class provides the servlet functionality
 * @author Shahram Behmardi Kalantari
 *
 ***************************************************/
public class ControllerServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
	
	/* implement the init method that runs once for the life cycle of servlet */
	public void init()
	{
		// String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        // String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        // String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
        
		userDAO = new UserDAO("jdbc:mysql://127.0.0.1:3306/sampledb?", "john", "pass1234");
	}
	
	/* implement the doPost method */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
        doGet(request, response);
    }
	
	/* implement the doGet method */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
        String action = request.getServletPath();
 
        try {
            switch (action) {
            case "/init":
            	initializeDatabase(request, response);
            	break;
            case "/new":
                showRegForm(request, response);
                break;
            case "/insert":
                insertUser(request, response);
                break;
            case "/login":
            	loginUser(request, response);
            	break;
            case "/delete":
                //deleteUser(request, response);
                break;
            case "/edit":
                //showEditForm(request, response);
                break;
            case "/update":
                //updateUser(request, response);
                break;
            default:
                //listUser(request, response);
                break;
            }
        }
        catch (SQLException ex)
        {
            throw new ServletException(ex);
        }
    }
	
	/* insert a user into User table */
	private void initializeDatabase(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException
	{
		userDAO.createUserTable();

		RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
		dispatcher.forward(request, response);
	}
	
	/* go to registration form */
	private void showRegForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException
	{
		RequestDispatcher dispatcher = request.getRequestDispatcher("Registration.jsp");
        dispatcher.forward(request, response);
	}
	
	/* insert a user into User table */
	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException
	{
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		int age = Integer.parseInt(request.getParameter("age"));
		User user = new User(userName, password, firstName, lastName, email, gender, age);
		userDAO.insertUser(user);

		RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
		dispatcher.forward(request, response);
	}
	
	/* check if user is in database and it's username and pass match the User table */
	private void loginUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException
	{
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		User user = new User();
		user = userDAO.getUser(userName);
		if (user.password == password)
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("UserJokes.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("Error.jsp");
			dispatcher.forward(request, response);
		}
	}
}
