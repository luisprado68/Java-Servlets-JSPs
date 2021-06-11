
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/SesionesServlet")
public class SesionesServlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
        response.setContentType("text/html;charset=UTF-8");
        //obtenemos una sesion creada o bien crea una si no hay
        HttpSession sesion = request.getSession();
        String titulo = null;
        
        //solicitamos el contador visitas 
        Integer contadorVisitas = (Integer) sesion.getAttribute("contadorVisitas");
        //consultamos si es la priemera vez
        if(contadorVisitas == null){
            contadorVisitas = 1;
            titulo = "Bienvenido por primera vez";
        }
        else{
            contadorVisitas++;
            titulo = "Bienvenido nuevamente";
                   
        }
        //agregamos el nuevo valor a la sesion
        sesion.setAttribute("contadorVisitas", contadorVisitas);
        
        PrintWriter out = response.getWriter();
        out.print(titulo);
        out.print("<br>");
        out.print("nro de accesos al recurso " + contadorVisitas);
        out.print("<br>");
        out.print("ID de la sesion: "+ sesion.getId());
        out.close();
    }
}
