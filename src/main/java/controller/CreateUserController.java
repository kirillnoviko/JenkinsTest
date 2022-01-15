package controller;

import domain.User;
import repository.UserRepository;
import repository.impl.UserRepositoryImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = { "/createUser" })
public class CreateUserController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CreateUserController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/createUser.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserRepository userRepository= new UserRepositoryImpl();


        String name = (String) request.getParameter("name");
        String surname = (String) request.getParameter("surname");

        User user = new User(name, surname);

        String errorString = null;


        userRepository.save(user);

        response.sendRedirect(request.getContextPath()+ "/userList");

    }


}
