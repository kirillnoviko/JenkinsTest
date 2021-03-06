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
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = { "/userList" })
public class UsersShowController extends HttpServlet {

        private static final long serialVersionUID = 1L;

        public UsersShowController() {
            super();
        }

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            UserRepository userRepository=new UserRepositoryImpl();
            List<User> result = new ArrayList<>();
            String errorString = null;
            User user= new Student();


            /*try{*/
                result = userRepository.findAll();
            /*}
            catch(Exception e){
                errorString=e.getMessage();
            }*/

            request.setAttribute("errorString", errorString);
            request.setAttribute("userList", result);


            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/jsp/userList.jsp");
            dispatcher.forward(request, response);
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            doGet(request, response);
        }

}
