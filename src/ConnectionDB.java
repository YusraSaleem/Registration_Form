import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class ConnectionDB {
    Statement stat;
    Connection conn;
    ConnectionDB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
           conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentRegistrationForm", "root", "Y21sw034");
            stat = conn.createStatement();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

