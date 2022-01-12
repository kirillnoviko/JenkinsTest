
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.List;

@WebServlet(urlPatterns = "/hello", loadOnStartup = 1)
public class HelloServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("HelloServlet: You should see this in the Instance Logs :-)");
        try {
            List<User> users=TestConnection.fetchData();
            for(User user :users){
                System.out.println(user.getName());
            }
        }
        catch (Exception e){
            System.out.println(e);
        }

    }
}