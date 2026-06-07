package dao;
import java.util.ArrayList; import modelo.Cliente;
public class ClienteDAO { private ArrayList<Cliente> clientes; public ClienteDAO(ArrayList<Cliente> clientes){this.clientes=clientes;} public void registrar(Cliente cliente){clientes.add(cliente);} public ArrayList<Cliente> listar(){return clientes;} }
