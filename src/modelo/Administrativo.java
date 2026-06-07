package modelo;
public class Administrativo extends Usuario { public Administrativo(int idUsuario,String nombreUsuario){super(idUsuario,nombreUsuario,"Administrativo");} @Override public void mostrarMenu(){System.out.println("Usuario Administrativo habilitado para gestionar productos, clientes y pedidos.");} }
