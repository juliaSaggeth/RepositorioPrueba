
package proyecto1;

import java.sql.ResultSet;
import java.sql.*;

public class Clientes {
     conexion cn = new conexion();
    
    public void insertar(String idCliente, String apellido1C, String apellido2C, String nombres, String direccionC, String email, String telefonoCliente, String telefonoCReferencia) { 
        cn.UID("INSERT INTO clientes(idCliente,apellido1C,apellido2C,nombres,direccionC,email,telefonoCliente,telefonoCReferencia) VALUES('" + idCliente + "','" + apellido1C + "','" + apellido2C + "','" + nombres + "','" + direccionC + "','"+ email + "','" + telefonoCliente + "','" + telefonoCReferencia + "')");
    }
    
    public ResultSet buscar(String idCliente) {
        return (cn.getValores("SELECT * FROM clientes WHERE idCliente='" + idCliente + "'"));
    } 
    
    public void modificar(String idCliente, String apellido1C, String apellido2C, String nombres, String direccionC, String email, String telefonoCliente, String telefonoCReferencia) {
        cn.UID("UPDATE clientes SET apellido1C='" + apellido1C + "',apellido2C='" + apellido2C + "',nombres='" + nombres + "',direccionC='" + direccionC + "',email='"+email+ "',telefonoCliente='" + telefonoCliente + "',telefonoCReferencia='" + telefonoCReferencia + "' WHERE idCliente='" + idCliente + "'");
    }
    
    public ResultSet contarRegistros() {
        return (cn.getValores("SELECT COUNT(idCliente) FROM clientes"));
    }
    
    public ResultSet mayorRegistro() {
        return (cn.getValores("SELECT MAX(idCliente) FROM clientes"));
    }
    
    public ResultSet llenarTabla(){
        return cn.getValores("SELECT clientes.idCliente, clientes.apellido1C, clientes.apellido2C, clientes.nombres, clientes.direccionC, clientes.email, clientes.telefonoCliente, clientes.telefonoCReferencia FROM clientes");
    }
    
    public ResultSet llenarClientes(){
        return cn.getValores("SELECT * from clientes"); 
    }
    
    public void eliminar(String idCliente) {
        cn.UID("DELETE FROM clientes WHERE idCliente='" + idCliente + "'");
    }
}
