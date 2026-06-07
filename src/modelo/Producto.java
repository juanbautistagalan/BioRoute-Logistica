package modelo;
public class Producto {
    private int idProducto; private String nombre; private String categoria; private double precioUnitario; private int stockActual; private int stockMinimo;
    public Producto(int idProducto, String nombre, String categoria, double precioUnitario, int stockActual, int stockMinimo){this.idProducto=idProducto;this.nombre=nombre;this.categoria=categoria;this.precioUnitario=precioUnitario;this.stockActual=stockActual;this.stockMinimo=stockMinimo;}
    public int getIdProducto(){return idProducto;} public String getNombre(){return nombre;} public double getPrecioUnitario(){return precioUnitario;} public int getStockActual(){return stockActual;}
    public void descontarStock(int cantidad){this.stockActual-=cantidad;} public boolean estaBajoStockMinimo(){return stockActual<=stockMinimo;}
    public void mostrarDatos(){System.out.println("ID: "+idProducto+" | "+nombre+" | Categoría: "+categoria+" | Precio: $"+precioUnitario+" | Stock: "+stockActual+" | Stock mínimo: "+stockMinimo);}
}
