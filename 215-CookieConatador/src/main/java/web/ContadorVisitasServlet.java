package web;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;



@WebServlet("/ContadorVisitasServlet")
public class ContadorVisitasServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
        
        
        int contador = 0;
        
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("contadorVisitas") ){
                    contador = Integer.parseInt(cookie.getValue()); 
                }
            }
        }
        contador++;
        //Agregmos  la respuesta al navegador
        Cookie c = new Cookie("contadorVisitas",Integer.toString(contador));
        // esta cookie se almacenara por una hora
        c.setMaxAge(3600);
        response.addCookie(c);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("Contador de visitas de cada cliente:" + contador);
        
    }
}
