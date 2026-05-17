package dao;

import conexion.ConexionBD;
import modelo.Producto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    public void registrarProducto(Producto p) {
        String sql = "INSERT INTO productos (nombre, categoria, precio_unitario, stock_actual, stock_minimo) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getCategoria());
            ps.setDouble(3, p.getPrecioUnitario());
            ps.setInt(4, p.getStockActual());
            ps.setInt(5, p.getStockMinimo());
            ps.executeUpdate();
            System.out.println("Producto registrado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Producto> listarProductos() {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM productos";
        try (Connection con = ConexionBD.getConexion();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Producto p = new Producto();
                p.setIdProducto(rs.getInt("id_producto"));
                p.setNombre(rs.getString("nombre"));
                p.setCategoria(rs.getString("categoria"));
                p.setPrecioUnitario(rs.getDouble("precio_unitario"));
                p.setStockActual(rs.getInt("stock_actual"));
                p.setStockMinimo(rs.getInt("stock_minimo"));
                lista.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void actualizarStock(int idProducto, int nuevoStock) {
        String sql = "UPDATE productos SET stock_actual = ? WHERE id_producto = ?";
        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, nuevoStock);
            ps.setInt(2, idProducto);
            ps.executeUpdate();
            System.out.println("Stock actualizado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
