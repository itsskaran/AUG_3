import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection_1 {

    public java.sql.Connection Connect() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        java.sql.Connection con1= DriverManager.getConnection("jdbc:mysql://localhost/inventotry", "root", "");
        return con1;

    }


}
