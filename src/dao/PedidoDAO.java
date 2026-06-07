package dao;
import java.util.ArrayList; import modelo.Pedido;
public class PedidoDAO { private ArrayList<Pedido> pedidos; public PedidoDAO(ArrayList<Pedido> pedidos){this.pedidos=pedidos;} public void registrar(Pedido pedido){pedidos.add(pedido);} public ArrayList<Pedido> listar(){return pedidos;} }
