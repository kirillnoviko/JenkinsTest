package controller;

import domain.User;
import hicari.DataSource;
import repository.UserRepository;
import repository.impl.UserRepositoryImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(urlPatterns = { "/createUser" })
public class CreateUserController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CreateUserController() {
        super();
    }

    // Отобразить страницу создания продукта.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/createUser.jsp");
        dispatcher.forward(request, response);
    }

    // Когда пользователь вводит информацию продукта, и нажимает Submit.
    // Этот метод будет вызван.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserRepository userRepository= new UserRepositoryImpl();


        String name = (String) request.getParameter("name");
        String surname = (String) request.getParameter("surname");

        User user = new User(name, surname, "0" ,0);

        String errorString = null;

        userRepository.save(user);
        response.sendRedirect(request.getContextPath() + "/userList");

    }


}
