
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet("/CookiesServlet")
public class CookiesServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
        //visita por primera vez nuestro sitio
        boolean nuevoUsuario = true;
        //obtenemos el arreglo de cookies
        Cookie[] cookies = request.getCookies();
        //buscamos si hay una cokie existente
        //llamada visitanterecurrente
        if(cookies != null){
            for (Cookie c:cookies) {
                if(c.getName().equals("visitanteRecurrente") && c.getValue().equals("si")){
                    //si ya existe la cookies es un usuario recurente
                    nuevoUsuario = false;
                    break;
                }
            }
        }
        String mensaje = null;
        if(nuevoUsuario){
            Cookie visitanteCookie = new Cookie("visitanteRecurrente","si");
            response.addCookie(visitanteCookie);
            mensaje = "Gracias por visitar nuestro sitio por primera vez";
        }
        else{
            mensaje = "Gracias por visitar nuestro sitio nuevamente";
        }
        response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter out = response.getWriter();
        out.print("Mensaje" + mensaje);
        out.close();
        
    }
}
