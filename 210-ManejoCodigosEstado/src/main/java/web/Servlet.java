/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //simulando los valores correctos
        String usuarioOk="luis";
        String passwwordOk = "123";
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        
        PrintWriter out = response.getWriter();
                
        if(usuario.equals(usuarioOk) && password.equals(passwwordOk)){
            
            out.print("<h1>");
            out.print("Datos correctos");
            out.print("<br>Usuario: "+ usuario);
            out.print("<br>Password: " + password);
            out.print("</h1>");
        }
        else{
            //enviamos el tipo de codigo de estado
            response.sendError(response.SC_UNAUTHORIZED,"Las credenciales son incorrectas");
        }
        
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = request.get
    }
    
}
