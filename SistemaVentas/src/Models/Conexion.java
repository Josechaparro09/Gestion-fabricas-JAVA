
package Models;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import javax.swing.JOptionPane;
public class Conexion {
    Connection con;
    public Connection getConexion (){
        try {
            String db ="jdbc:mysql://uvptgjeckffgyd7s:yeEvrKZriqoUy75RfOGz@bbstpbh1cpto1krjvl6d-mysql.services.clever-cloud.com:3306/bbstpbh1cpto1krjvl6d";
            con = DriverManager.getConnection(db,"uvptgjeckffgyd7s","yeEvrKZriqoUy75RfOGz");
            return con;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return null;
    }
}
