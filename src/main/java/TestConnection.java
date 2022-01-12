import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestConnection {

    public static List<User> fetchData() throws SQLException {
        String SQL_QUERY = "select * from users";
        List<User> users = null;
        try (Connection con = DataSource.getConnection();
             PreparedStatement pst = con.prepareStatement( SQL_QUERY );
             ResultSet rs = pst.executeQuery();) {
            users = new ArrayList<>();
            User user;
            while ( rs.next() ) {
                user = new User();
                user.setName( rs.getString( "name" ) );
                user.setSurname( rs.getString( "surname" ) );
                users.add( user );
            }
        }
        return users;
    }
}
