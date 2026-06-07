package dao;
import java.util.ArrayList; import modelo.EstadoPedido;
public class EstadoPedidoDAO { private ArrayList<EstadoPedido> historial; public EstadoPedidoDAO(ArrayList<EstadoPedido> historial){this.historial=historial;} public void registrar(EstadoPedido estado){historial.add(estado);} public ArrayList<EstadoPedido> listar(){return historial;} }
