package modelo;
import java.util.ArrayList;
public class Pedido { private int idPedido; private Cliente cliente; private String estadoActual; private ArrayList<DetallePedido> detalles;
    public Pedido(int idPedido, Cliente cliente){this.idPedido=idPedido;this.cliente=cliente;this.estadoActual="Pendiente";this.detalles=new ArrayList<>();}
    public int getIdPedido(){return idPedido;} public ArrayList<DetallePedido> getDetalles(){return detalles;} public void agregarDetalle(DetallePedido detalle){detalles.add(detalle);} public double calcularTotal(){double total=0; for(DetallePedido d:detalles) total+=d.calcularSubtotal(); return total;} public void actualizarEstado(String nuevoEstado){this.estadoActual=nuevoEstado;} public void mostrarResumen(){System.out.println("Pedido ID: "+idPedido+" | Cliente: "+cliente.getNombre()+" | Estado: "+estadoActual+" | Total: $"+calcularTotal());} }
