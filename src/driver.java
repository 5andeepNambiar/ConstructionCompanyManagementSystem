import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class driver {
    public static void main(String[] args) {
        try {
            // # jdbc connection
            String url = "jdbc:postgresql://localhost:5432/postgres";
            String user = "postgres";
            String password = "0000";
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println(con+"Connected");
        }
        catch (Exception e) {
            System.out.println("Error: " + e);
        }
        try {
            LoginForm login = new LoginForm();
            login.setSize(500, 400);
            login.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}