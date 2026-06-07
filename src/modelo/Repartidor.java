package modelo;
public class Repartidor extends Usuario { public Repartidor(int idUsuario,String nombreUsuario){super(idUsuario,nombreUsuario,"Repartidor");} @Override public void mostrarMenu(){System.out.println("Usuario Repartidor habilitado para actualizar estados de pedidos.");} }
