package modelo;
public abstract class Usuario { protected int idUsuario; protected String nombreUsuario; protected String perfil; public Usuario(int idUsuario,String nombreUsuario,String perfil){this.idUsuario=idUsuario;this.nombreUsuario=nombreUsuario;this.perfil=perfil;} public abstract void mostrarMenu(); }
