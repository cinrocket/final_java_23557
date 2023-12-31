package controlador;

import dao.OradoresDAO;
import jakarta.servlet.annotation.WebServlet;
import modelo.Orador;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

@WebServlet("/registroOrador")
public class RegistroOrador extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String tema = request.getParameter("tema");

        
        Orador orador = new Orador();
        orador.setNombre(nombre);
        orador.setApellido(apellido);
        orador.setTema(tema);

        java.util.Date fechaActual = new java.util.Date();
        orador.setFechaAlta(new Date(fechaActual.getTime()));

        OradoresDAO oradoresDAO = new OradoresDAO();
        oradoresDAO.agregarOrador(orador);
        
        response.sendRedirect(request.getContextPath() + "/vistas/verOradores.jsp");
    }
}
