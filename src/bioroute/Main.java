package bioroute;

import conexion.ConexionBD;
import dao.ProductoDAO;
import modelo.Producto;
import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== BioRoute - Prototipo Operacional ===\n");

        Connection con = ConexionBD.getConexion();
        if (con != null) {
            System.out.println("Conexión validada correctamente.\n");
        }

        ProductoDAO productoDAO = new ProductoDAO();
        List<Producto> productos = productoDAO.listarProductos();

        System.out.println("--- Productos registrados ---");
        for (Producto p : productos) {
            System.out.println("ID: " + p.getIdProducto()
                + " | " + p.getNombre()
                + " | Stock: " + p.getStockActual()
                + " | Mínimo: " + p.getStockMinimo());
        }

        System.out.println("\n=== Fin del prototipo ===");
    }
}
