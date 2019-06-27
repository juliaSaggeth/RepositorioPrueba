package proyecto1;

import java.sql.ResultSet;

public class Pedidos {
    
    conexion cn = new conexion ();
    
    public void insertar(String idPedido, int idVendedor, int idCliente, String FechaPedido, String FechaEntregaSugerida) { 
        cn.UID("INSERT INTO pedidos(idPedido,idVendedor,idCliente,FechaPedido,FechaEntregaSugerida) VALUES('" + idPedido + "','" + idVendedor + "','" + idCliente + "','" + FechaPedido + "','"+ FechaEntregaSugerida + "')");
    }
    
    public ResultSet buscar(String idPedido) {
        return (cn.getValores("SELECT * FROM pedidos WHERE idPedido='" + idPedido + "'"));
    } 
    
    public void modificar(String idPedido, int idVendedor, int idCliente, String FechaPedido, String FechaEntregaSugerida) {
        cn.UID("UPDATE pedidos SET idVendedor='" + idVendedor + "',idCliente='" + idCliente + "',FechaPedido='" + FechaPedido + "',FechaEntregaSugerida='" + FechaEntregaSugerida + "' WHERE idPedido='" + idPedido + "'");
    }
    
    public ResultSet contarRegistros() {
        return (cn.getValores("SELECT COUNT(idPedido) FROM pedidos"));
    }

    public ResultSet mayorRegistro() {
        return (cn.getValores("SELECT MAX(idPedido) FROM pedidos"));
    }
    
    public ResultSet llenarTabla(){
        return cn.getValores("SELECT pedidos.idPedido, vendedores.nombresV, clientes.nombres, pedidos.FechaPedido, pedidos.FechaEntregaSugerida FROM (vendedores INNER JOIN pedidos ON vendedores.idVendedor = pedidos.idVendedor) INNER JOIN clientes ON (clientes.idCliente = pedidos.idCliente) group by pedidos.idPedido");
    }
    
    public ResultSet llenarClientes(){
        return cn.getValores("SELECT * from clientes"); 
    }
    public ResultSet llenarVendedores(){
        return cn.getValores("SELECT * from vendedores"); 
    }
    
    public void eliminar(String idPedido) {
        cn.UID("DELETE FROM pedidos WHERE idPedido='" + idPedido + "'");
    }
    
    
}
