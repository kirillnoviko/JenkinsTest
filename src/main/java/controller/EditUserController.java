package controller;

import domain.Student;
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

@WebServlet(urlPatterns = { "/editUser" })
public class EditUserController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public EditUserController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserRepository userRepository=new UserRepositoryImpl();

        Long idUser = Long.parseLong(request.getParameter("id"));
        User user=userRepository.findOne(idUser);

        request.setAttribute("user", user);

        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/editUser.jsp");
        dispatcher.forward(request, response);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserRepository userRepository = new UserRepositoryImpl();
        String surname = (String) request.getParameter("surname");
        String name = (String) request.getParameter("name");

        User user = new Student();
        user.setName(name);
        user.setSurname(surname);
        user.setId(Long.parseLong(request.getParameter("id")));

        userRepository.update(user);

        request.setAttribute("product", user);
        response.sendRedirect(request.getContextPath() + "/userList");

    }





}
