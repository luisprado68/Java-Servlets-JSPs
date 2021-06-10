
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GeneracionExcelServlet")
public class GeneracionExcelServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
        //indicamos el tipo de respuesta al navegador
        response.setContentType("aplication/vnd.ms-excel");
        //tipo de contenido y descarga de excel
        response.setHeader("Content-Disposition", "attachment;filename=excelEjemplo.xls");
        //para un ejemplo mas profesional de excel poi.apache.org
        //indicamos al navegador que no guarde informacion previa sino nueva
        response.setHeader("Pragma", "no-cache");//no guarde cache
        response.setHeader("Cache-control", "no-store");//para que no guarde
        response.setDateHeader("Expires",-1);//para que espire de manera inmediata
        
        //despleglamos la informacion al cache
        PrintWriter out = response.getWriter();
        out.println("\tValores");
        out.println("\t1");
        out.println("\t2");
        out.println("Total\t=SUMA(B2:B3)");
        out.close();
        
        
        
    }
}
