/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.Cliente;
import java.sql.*;
import java.util.*;

public class ClienteDaoJDBC {

    private static final String SQL_SELECT = "SELECT id_cliente, nombre,apellido,email,telefono,saldo FROM clientes";
    private static final String SQL_SELECT_BY_ID = "SELECT id_cliente, nombre,apellido,email,telefono,saldo FROM clientes WHERE id_cliente = ?";
    private static final String SQL_INSERT = "INSERT INTO clientes (nombre,apellido,email,telefono,saldo) VALUES (?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE clientes SET nombre = ?, apellido = ?, email = ?, telefono = ?, saldo = ? WHERE id_cliente = ?;";
    private static final String SQL_DELETE = "DELETE FROM clientes WHERE id_cliente = ?";

    public List<Cliente> seleccionar() {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;
        List<Cliente> clientes = new ArrayList<>();

        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idCliente = rs.getInt("id_cliente");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                Double saldo = rs.getDouble("saldo");
                cliente = new Cliente(idCliente, nombre, apellido, email, telefono, saldo);
                clientes.add(cliente);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(con);

        }
        return clientes;
    }

    public Cliente encontrarCliente(Cliente cliente) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, cliente.getIdCliente());
            rs = stmt.executeQuery();
            rs.absolute(1);//en el caso de que existe nos posicionamos en primer registro
            
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            String email = rs.getString("email");
            String telefono = rs.getString("telefono");
            Double saldo = rs.getDouble("saldo");
            //asginamos los valores 
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setEmail(email);
            cliente.setTelefono(telefono);
            cliente.setSaldo(saldo);
            

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(con);

        }
        return cliente;
    }

    public int insertar(Cliente cliente) {
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_INSERT);
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefono());
            stmt.setDouble(5, cliente.getSaldo());
            registros = stmt.executeUpdate();
            System.out.println("registros  actualizados= " + registros);
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);

        } finally {
            Conexion.close(stmt);
            Conexion.close(con);
        }
        return registros;
    }

    public int actualizar(Cliente cliente) {
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_UPDATE);

            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefono());
            stmt.setDouble(5, cliente.getSaldo());
            stmt.setDouble(6, cliente.getIdCliente());
            registros = stmt.executeUpdate();
            System.out.println("registros  actualizados= " + registros);
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);

        } finally {
            Conexion.close(stmt);
            Conexion.close(con);
        }
        return registros;
    }

    public int eliminar(Cliente cliente) {
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_DELETE);

            stmt.setInt(1, cliente.getIdCliente());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);

        } finally {
            Conexion.close(stmt);
            Conexion.close(con);
        }
        return registros;
    }
}
