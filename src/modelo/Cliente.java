package modelo;
public class Cliente {
    private int idCliente; private String nombre; private String telefono; private String direccion; private String email;
    public Cliente(int idCliente,String nombre,String telefono,String direccion,String email){this.idCliente=idCliente;this.nombre=nombre;this.telefono=telefono;this.direccion=direccion;this.email=email;}
    public int getIdCliente(){return idCliente;} public String getNombre(){return nombre;}
    public void mostrarDatos(){System.out.println("ID: "+idCliente+" | Cliente: "+nombre+" | Tel: "+telefono+" | Dirección: "+direccion+" | Email: "+email);}
}
