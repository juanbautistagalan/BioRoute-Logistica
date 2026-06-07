package modelo;
import java.time.LocalDateTime;
public class EstadoPedido { private int idPedido; private String estado; private LocalDateTime fechaHora; private String usuarioResponsable; public EstadoPedido(int idPedido,String estado,String usuarioResponsable){this.idPedido=idPedido;this.estado=estado;this.usuarioResponsable=usuarioResponsable;this.fechaHora=LocalDateTime.now();} public int getIdPedido(){return idPedido;} public void mostrarEstado(){System.out.println("Pedido: "+idPedido+" | Estado: "+estado+" | Fecha/Hora: "+fechaHora+" | Responsable: "+usuarioResponsable);} }
