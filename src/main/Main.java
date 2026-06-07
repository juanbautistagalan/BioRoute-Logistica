package main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import modelo.*;

public class Main {
    private static ArrayList<Producto> productos = new ArrayList<>();
    private static ArrayList<Cliente> clientes = new ArrayList<>();
    private static ArrayList<Pedido> pedidos = new ArrayList<>();
    private static ArrayList<EstadoPedido> historialEstados = new ArrayList<>();
    private static int contadorPedidos = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        cargarDatosIniciales();
        demostrarPolimorfismo();
        int opcion = -1;
        while (opcion != 0) {
            mostrarMenuPrincipal();
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion) {
                    case 1: registrarProducto(scanner); break;
                    case 2: listarProductos(); break;
                    case 3: buscarProductoPorNombre(scanner); break;
                    case 4: registrarCliente(scanner); break;
                    case 5: listarClientes(); break;
                    case 6: crearPedido(scanner); break;
                    case 7: actualizarEstadoPedido(scanner); break;
                    case 8: consultarTrazabilidad(scanner); break;
                    case 9: verProductosConStockBajo(); break;
                    case 10: ordenarProductosPorStock(); break;
                    case 0: System.out.println("Saliendo del sistema BioRoute..."); break;
                    default: System.out.println("Opción inválida. Intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar un número válido.");
            } catch (Exception e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
            }
        }
        scanner.close();
    }

   private static void mostrarMenuPrincipal() {
    System.out.println();
    System.out.println("=== SISTEMA BIOROUTE ===");
    System.out.println("1. Registrar producto");
    System.out.println("2. Listar productos");
    System.out.println("3. Buscar producto por nombre");
    System.out.println("4. Registrar cliente");
    System.out.println("5. Listar clientes");
    System.out.println("6. Crear pedido");
    System.out.println("7. Actualizar estado de pedido");
    System.out.println("8. Consultar trazabilidad de pedido");
    System.out.println("9. Ver productos con stock bajo");
    System.out.println("10. Ordenar productos por stock");
    System.out.println("0. Salir");
    System.out.print("Seleccione una opción: ");
}

    private static void cargarDatosIniciales() {
        productos.add(new Producto(1, "Miel orgánica 500g", "Endulzantes", 2500.00, 50, 10));
        productos.add(new Producto(2, "Quinoa orgánica 1kg", "Cereales", 3200.00, 3, 5));
        productos.add(new Producto(3, "Yerba mate orgánica 1kg", "Infusiones", 3500.00, 40, 10));
        clientes.add(new Cliente(1, "Almacén Orgánico del Sur", "011-4555-1234", "Av. Rivadavia 3200", "contacto@organicosur.com"));
        clientes.add(new Cliente(2, "Dietética Vida Sana", "0351-422-5678", "Bv. San Juan 850", "info@vidasana.com"));
    }

    private static void demostrarPolimorfismo() {
        Usuario usuarioAdmin = new Administrativo(1, "admin01");
        Usuario usuarioRepartidor = new Repartidor(2, "repartidor01");
        usuarioAdmin.mostrarMenu();
        usuarioRepartidor.mostrarMenu();
    }

    private static void registrarProducto(Scanner scanner) {
        System.out.print("Nombre: "); String nombre = scanner.nextLine();
        System.out.print("Categoría: "); String categoria = scanner.nextLine();
        System.out.print("Precio unitario: "); double precio = Double.parseDouble(scanner.nextLine());
        System.out.print("Stock actual: "); int stock = Integer.parseInt(scanner.nextLine());
        System.out.print("Stock mínimo: "); int stockMinimo = Integer.parseInt(scanner.nextLine());
        Producto producto = new Producto(productos.size()+1, nombre, categoria, precio, stock, stockMinimo);
        productos.add(producto);
        System.out.println("Producto registrado correctamente.");
    }

    private static void listarProductos() { for (Producto producto : productos) producto.mostrarDatos(); }

    private static void buscarProductoPorNombre(Scanner scanner) {
        System.out.print("Ingrese el nombre del producto a buscar: ");
        String nombreBuscado = scanner.nextLine();
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombreBuscado)) { producto.mostrarDatos(); return; }
        }
        System.out.println("No se encontró un producto con ese nombre.");
    }

    private static void registrarCliente(Scanner scanner) {
        System.out.print("Nombre del cliente: "); String nombre = scanner.nextLine();
        System.out.print("Teléfono: "); String telefono = scanner.nextLine();
        System.out.print("Dirección: "); String direccion = scanner.nextLine();
        System.out.print("Email: "); String email = scanner.nextLine();
        clientes.add(new Cliente(clientes.size()+1, nombre, telefono, direccion, email));
        System.out.println("Cliente registrado correctamente.");
    }

    private static void listarClientes() { for (Cliente cliente : clientes) cliente.mostrarDatos(); }

    private static void crearPedido(Scanner scanner) {
        listarClientes();
        System.out.print("Ingrese ID del cliente: "); int idCliente = Integer.parseInt(scanner.nextLine());
        Cliente cliente = buscarClientePorId(idCliente);
        if (cliente == null) { System.out.println("Cliente no encontrado."); return; }
        Pedido pedido = new Pedido(contadorPedidos++, cliente);
        String continuar = "s";
        while (continuar.equalsIgnoreCase("s")) {
            listarProductos();
            System.out.print("Ingrese ID del producto: "); int idProducto = Integer.parseInt(scanner.nextLine());
            Producto producto = buscarProductoPorId(idProducto);
            if (producto == null) { System.out.println("Producto no encontrado."); }
            else {
                System.out.print("Cantidad: "); int cantidad = Integer.parseInt(scanner.nextLine());
                if (producto.getStockActual() < cantidad) System.out.println("Stock insuficiente.");
                else { pedido.agregarDetalle(new DetallePedido(producto, cantidad)); producto.descontarStock(cantidad); }
            }
            System.out.print("¿Desea agregar otro producto? (s/n): "); continuar = scanner.nextLine();
        }
        if (pedido.getDetalles().isEmpty()) { System.out.println("No se creó el pedido porque no tiene productos."); return; }
        pedidos.add(pedido);
        historialEstados.add(new EstadoPedido(pedido.getIdPedido(), "Pendiente", "admin01"));
        pedido.mostrarResumen();
    }

    private static void actualizarEstadoPedido(Scanner scanner) {
        System.out.print("Ingrese ID del pedido: "); int idPedido = Integer.parseInt(scanner.nextLine());
        Pedido pedido = buscarPedidoPorId(idPedido);
        if (pedido == null) { System.out.println("Pedido no encontrado."); return; }
        System.out.print("Nuevo estado: "); String nuevoEstado = scanner.nextLine();
        pedido.actualizarEstado(nuevoEstado);
        historialEstados.add(new EstadoPedido(idPedido, nuevoEstado, "repartidor01"));
        System.out.println("Estado actualizado correctamente.");
    }

    private static void consultarTrazabilidad(Scanner scanner) {
        System.out.print("Ingrese ID del pedido: "); int idPedido = Integer.parseInt(scanner.nextLine());
        boolean encontrado = false;
        for (EstadoPedido estado : historialEstados) if (estado.getIdPedido() == idPedido) { estado.mostrarEstado(); encontrado = true; }
        if (!encontrado) System.out.println("No se encontraron estados para ese pedido.");
    }

    private static void verProductosConStockBajo() {
        for (Producto producto : productos) if (producto.estaBajoStockMinimo()) producto.mostrarDatos();
    }

    private static void ordenarProductosPorStock() {
        productos.sort(Comparator.comparingInt(Producto::getStockActual));
        listarProductos();
    }

    private static Producto buscarProductoPorId(int idProducto) { for (Producto p : productos) if (p.getIdProducto()==idProducto) return p; return null; }
    private static Cliente buscarClientePorId(int idCliente) { for (Cliente c : clientes) if (c.getIdCliente()==idCliente) return c; return null; }
    private static Pedido buscarPedidoPorId(int idPedido) { for (Pedido p : pedidos) if (p.getIdPedido()==idPedido) return p; return null; }
}
