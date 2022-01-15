package controller;

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

@WebServlet(urlPatterns = { "/deleteUser" })
public class DeleteUserController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DeleteUserController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));
        String errorString = null;


        UserRepository userRepository= new UserRepositoryImpl();
        userRepository.delete(id);


            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/jsp/deleteUser.jsp");
            dispatcher.forward(request, response);


            response.sendRedirect(request.getContextPath() + "/userList");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}