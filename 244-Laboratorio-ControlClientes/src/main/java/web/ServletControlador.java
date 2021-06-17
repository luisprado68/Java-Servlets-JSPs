package web;

import datos.ClienteDaoJDBC;
import dominio.Cliente;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarCliente(request, response);
                     System.out.println("nada!");
                    break;
                case "eliminar":
                    this.eliminarCliente(request, response);
                     
                    break;
                default:
                    this.accionDefault(request, response);
                     System.out.println("nada!");
            }
        } else {
            this.accionDefault(request, response);
            
            
        }

    }

    private void accionDefault(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Cliente> clientes = new ClienteDaoJDBC().seleccionar();
        //System.out.println("clientes = " + clientes);
        //para tener un mayor alcanze utilizamos session
        HttpSession session = request.getSession();
        session.setAttribute("clientes", clientes);
        session.setAttribute("totalClientes", clientes.size());
        session.setAttribute("saldoTotal", this.obtenerSaldoTotal(clientes));
        //request.getRequestDispatcher("clientes.jsp").forward(request, response);
        //evitamos que la url se mantenga igual para no insertar clientes no deseados
        response.sendRedirect("clientes.jsp");
    }

    private double obtenerSaldoTotal(List<Cliente> clientes) {
        double saldoTotal = 0;
        for (Cliente cliente : clientes) {
            saldoTotal += cliente.getSaldo();
        }
        return saldoTotal;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarCliente(request, response);
                    break;
                case "modificar":
                    this.modificarCliente(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }

    }

    protected void insertarCliente(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        //recuperamos los datos
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        String saldoString = request.getParameter("saldo");
        double saldo = 0;
        if (saldoString != null && !saldoString.equals("")) {
            saldo = Double.parseDouble(saldoString);
        }
        //creamos el objeto cliente
        Cliente cliente = new Cliente(nombre, apellido, email, telefono, saldo);
        //insertamos el cliente
        int cantidadRegistros = new ClienteDaoJDBC().insertar(cliente);
        System.out.println("cantidadRegistros = " + cantidadRegistros);
        //listamos con la lista actualizada
        this.accionDefault(request, response);
    }
    
    protected void modificarCliente(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        //recuperamos los datos
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        String saldoString = request.getParameter("saldo");
        double saldo = 0;
        if (saldoString != null && !saldoString.equals("")) {
            saldo = Double.parseDouble(saldoString);
        }
        //creamos el objeto cliente
        Cliente cliente = new Cliente(idCliente,nombre, apellido, email, telefono, saldo);
        //insertamos el cliente
        int cantidadRegistros = new ClienteDaoJDBC().actualizar(cliente);
        System.out.println("cantidadRegistros = " + cantidadRegistros);
        //listamos con la lista actualizada
        this.accionDefault(request, response);
    }
    
    protected void eliminarCliente(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        //recuperamos los datos
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        
        //creamos el objeto cliente
        Cliente cliente = new Cliente(idCliente);
        //insertamos el cliente
        int cantidadRegistros = new ClienteDaoJDBC().eliminar(cliente);
        System.out.println("cantidadRegistros = " + cantidadRegistros);
        //listamos con la lista actualizada
        this.accionDefault(request, response);
    }
    
    

    protected void editarCliente(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        //recuperamos los datos
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));

        //creamos el objeto cliente
        Cliente cliente = new ClienteDaoJDBC().encontrarCliente(new Cliente(idCliente));
        request.setAttribute("cliente", cliente);
        String jspEditar = "/WEB-INF/paginas/cliente/editarCliente.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }
    
    

}
