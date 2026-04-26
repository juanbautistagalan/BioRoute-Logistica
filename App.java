import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/bioroute_db";
        String usuario = "root"; 
        String password = "1234"; // 

        try {
            Connection con = DriverManager.getConnection(url, usuario, password);
            System.out.println("✅ CONEXIÓN EXITOSA CON BIOROUTE");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM clientes");

            System.out.println("--- LISTA DE CLIENTES EN DB ---");
            while (rs.next()) {
                System.out.println("- ID: " + rs.getInt("id_cliente") + " | Nombre: " + rs.getString("nombre"));
            }
            con.close();
        } catch (Exception e) {
            System.out.println("❌ ERROR: " + e.getMessage());
        }
    }
}
