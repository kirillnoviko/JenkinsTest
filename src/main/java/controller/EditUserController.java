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

@WebServlet(urlPatterns = { "/editUser" })
public class EditUserController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public EditUserController() {
        super();
    }

    // Отобразить страницу редактирования продукта.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserRepository userRepository=new UserRepositoryImpl();

        Long idUser = Long.parseLong(request.getParameter("id"));
        User user=userRepository.findOne(idUser);

        String errorString = " ";



        // Сохранить информацию в request attribute перед тем как forward к views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("user", user);

        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/editUser.jsp");
        dispatcher.forward(request, response);

    }

    // После того, как пользователь отредактировал информацию продукта и нажал на Submit.
    // Данный метод будет выполнен.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserRepository userRepository = new UserRepositoryImpl();
        String surname = (String) request.getParameter("surname");
        String name = (String) request.getParameter("name");

        User user = new User(0l,name, surname,"1",0l);

        String errorString = null;

        userRepository.update(user);
        // Сохранить информацию в request attribute перед тем как forward к views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("product", user);


        response.sendRedirect(request.getContextPath() + "/userList");

    }





}
