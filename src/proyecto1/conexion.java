
package proyecto1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class conexion {
    private final String url = "jdbc:mysql://localhost:3306/AngelesPru1";
    private final String login = "root"; //Administrador de MySQL
    private final String password = "081666061296";
    private Connection cnx = null;
    private Statement sttm = null;
    private ResultSet rst = null;

    //método para Update, Insert, Delete
    public void UID(String sql) {
        try {
            Class.forName("com.mysql.jdbc.Driver"); //instanciar la clase
            cnx = DriverManager.getConnection(url, login, password);
            sttm = cnx.createStatement(); //Crea un objeto SQLServerStatement para enviar instrucciones SQL a la base de datos.
            sttm.executeUpdate(sql);//Ejecuta la instrucción SQL determinada, que puede ser una instrucción INSERT, UPDATE, DELETE o una instrucción SQL que no devuelve nada
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            System.exit(1); //salir de aplicación
        }
    }

    //Método para Consultar
    public ResultSet getValores(String sql) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx = DriverManager.getConnection(url, login, password);
            sttm = cnx.createStatement();
            rst = sttm.executeQuery(sql);  //resultset
        } catch (ClassNotFoundException | SQLException c) {
            JOptionPane.showMessageDialog(null, "Error: " + c.getMessage());
            System.exit(1);
        } finally { //actividad que siempre ocurre
            return rst;
        }
    }

    public void desconectar() {
        try {
            cnx.close();
            System.out.println("Se cerró la conexión");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }
    }
    
}
