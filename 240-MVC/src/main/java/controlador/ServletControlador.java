
package controlador;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import modelo.Rectangulo;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        //1-Procesamos parametros
        
        String accion = request.getParameter("accion");
        //2 - Creamos los javabeans
        Rectangulo recRequest = new Rectangulo(2,3);
        Rectangulo recSession = new Rectangulo(3,4);
        Rectangulo recAplicacion = new Rectangulo(1,5);
        
        //3 - Agregamos el javabeans a algun alcance
       
        //revisame la variable accion
        if("agregarVariables".equals(accion)){
            
            //alcance request
            request.setAttribute("rectanguloRequest", recRequest);
            //alcance session
            HttpSession session = request.getSession();
            session.setAttribute("rectanguloSession", recSession);
            //alcance aplicacion
            ServletContext application = this.getServletContext();
            application.setAttribute("rectanguloApplication", recAplicacion);
            
            //argegamos mensaje
            request.setAttribute("mensaje", "Las variables fueron agregadas");
            
            //4 - redireccionamos al jsp index
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        else if("listarVariables".equals(accion)){
            
            //4 - redireccionamos al jsp que depliega las variables
            request.getRequestDispatcher("WEB-INF/alcanceVariables.jsp").forward(request, response);
        }
        else{
            //rediccionamos a la pagina de inicio
            request.setAttribute("mensaje", "Accion no proporcionada o deconocida");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            
            //esta linea no propaga los  objetos response y request
            //response.sendRedirect("index.jsp");
        }
        
    }
}
