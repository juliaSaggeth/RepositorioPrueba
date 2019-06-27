
package proyecto1;

import java.sql.ResultSet;


public class vendedores {
     conexion cn = new conexion();
    
    public void insertar(String idVendedor, String apellido1V, String apellido2V, String nombresV, String direccionV, String telefonoVendedor, String telefonoVReferencia) { 
        cn.UID("INSERT INTO vendedores(idVendedor,apellido1V,apellido2V,nombresV,direccionV,telefonoVendedor,telefonoVReferencia) VALUES('" + idVendedor + "','" + apellido1V + "','" + apellido2V + "','" + nombresV + "','" + direccionV + "','" + telefonoVendedor + "','" + telefonoVReferencia + "')");
    }
    
    public ResultSet buscar(String idVendedor) {
        return (cn.getValores("SELECT * FROM vendedores WHERE idVendedor='" + idVendedor + "'"));
    } 
    
    public void modificar(String idVendedor, String apellido1V, String apellido2V, String nombresV, String direccionV, String telefonoVendedor, String telefonoVReferencia) {
        cn.UID("UPDATE vendedores SET apellido1V='" + apellido1V + "',apellido2V='" + apellido2V + "',nombresV='" + nombresV + "',direccionV='" + direccionV +"',telefonoVendedor='" + telefonoVendedor + "',telefonoVReferencia='" + telefonoVReferencia + "' WHERE idVendedor='" + idVendedor + "'");
    }
    
    public ResultSet contarRegistros() {
        return (cn.getValores("SELECT COUNT(idVendedor) FROM vendedores"));
    }

    public ResultSet mayorRegistro() {
        return (cn.getValores("SELECT MAX(idVendedor) FROM vendedores"));
    }
    
    public ResultSet llenarTabla(){
        return cn.getValores("SELECT vendedores.idVendedor, vendedores.apellido1V, vendedores.apellido2V, vendedores.nombresV, vendedores.direccionV, vendedores.telefonoVendedor, vendedores.telefonoVReferencia FROM vendedores");
    }
    
    public ResultSet llenarVendedores(){
        return cn.getValores("SELECT * from vendedores"); 
    }
    
    public void eliminar(String idVendedor) {
        cn.UID("DELETE FROM vendedores WHERE idVendedor='" + idVendedor + "'");
    }

    
}