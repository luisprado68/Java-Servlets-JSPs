package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/CarritoServlet")
public class CarritoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        //traemos el objeto sesion
        HttpSession sesion = request.getSession();
        //recuperamos la lista de articulos agregados recientemente
        List<String> articulos = (List<String>) sesion.getAttribute("articulos");
        //veirificamos si la lista existe
        if (articulos == null) {
            //incializamos la lista de articulos
            articulos = new ArrayList<>();
            sesion.setAttribute("articulos", articulos);
        }
        //procesamos nuevo articulo
        String articuloNuevo = request.getParameter("articulo");
        //revisamos y agremos el nuevo articulo

        if (articuloNuevo != null && !articuloNuevo.equals("")) {
            articulos.add(articuloNuevo);

        }

        try ( PrintWriter out = response.getWriter()) {
            out.print("<h1>Lista de Articulos</h1>");

            for (String articulo : articulos) {
                out.print("<li>" + articulo + "</li>");

            }
            out.print("<br>");
            out.print("<a href=\"/218-CarritoCompras\">Regresar al inicio</a>");
        }
    }
}
