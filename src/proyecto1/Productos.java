package proyecto1;

import java.sql.ResultSet;

public class Productos {

    conexion cn = new conexion ();

    public void insertar(String idProducto, String saldo, String unidadMedida, String descripcion, String precioVenta, int idTalla, int idCategoria) {
        cn.UID("INSERT INTO productos(idProducto,saldo,unidadMedida,descripcion,precioVenta, idtalla,idcategoria) VALUES('" + idProducto + "','" + saldo + "','" + unidadMedida + "','" + descripcion + "','" + precioVenta + "','" + idTalla + "','" + idCategoria + "')");
    }

    public ResultSet buscar(String idProducto) {
        return (cn.getValores("SELECT * FROM productos WHERE idProducto='" + idProducto + "'"));
    }

    public void modificar(String idProducto, String saldo, String unidadMedida, String descripcion, String precioVenta, int idTalla, int idCategoria) {
        cn.UID("UPDATE productos SET saldo='" + saldo + "',unidadMedida='" + unidadMedida + "',descripcion='" + descripcion + "',precioVenta='" + precioVenta + "',idTalla='" + idTalla + "',idCategoria='" + idCategoria + "' WHERE idProducto='" + idProducto + "'");
    }

    public ResultSet contarRegistros() {
        return (cn.getValores("SELECT COUNT(idProducto) FROM productos"));
    }

    public ResultSet mayorRegistro() {
        return (cn.getValores("SELECT MAX(idProducto) FROM productos"));
    }

    public ResultSet llenarTabla() {
        return cn.getValores("SELECT productos.idProducto, productos.saldo, productos.unidadMedida, productos.descripcion, productos.precioVenta, productos.idTalla, productos.idCategoria FROM productos");
    }

    public void eliminar(String idProducto) {
        cn.UID("DELETE FROM productos WHERE idproducto='" + idProducto + "'");
    }

}
