package dao;
import java.util.ArrayList; import modelo.Producto;
public class ProductoDAO { private ArrayList<Producto> productos; public ProductoDAO(ArrayList<Producto> productos){this.productos=productos;} public void registrar(Producto producto){productos.add(producto);} public ArrayList<Producto> listar(){return productos;} }
