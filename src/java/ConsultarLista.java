import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConsultarLista extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            //Si queremos ver toda la lista de alumno entonces ocuparemos el método antes hecho llamado:
            //getAllAlumnos() que está en la clase AccionesDelAlumno
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Lista general de alumnos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Lista general de alumnos</h1>"
                       +"<br>"
                       +"<a href='index.html'>Regresar al menú principal</a>"
                       +"<br>"
                       +"<a href='GuardarRegistro'>Guardar nuevo alumno</a>");
            
                       //Debemos obtener  la lista de los alumnos
                       List<Alumno> lista=AccionesDelAlumno.getAllAlumnos();
                       
                       //Ahora hacemos una tabla en donde se mostrará la lista:
                       out.println("<table border='1'>");
                       out.println("<tr>"
                                   +"<th>ID</th>"
                                   +"<th>Nombre</th>"
                                   +"<th>Password</th>"
                                   +"<th>Email</th>"
                                   +"<th>País</th>"
                                   +"</tr>");
                       
                                
                       //Tenemos que recorrer el tamaño de la tabla y obtener sus elementos
                       for(Alumno a:lista)
                       {
                           out.println("<tr>"
                                   +"<th>"+a.getId()+"</th>"
                                   +"<th>"+a.getNombre()+"</th>"
                                   +"<th>"+a.getPassword()+"</th>"
                                   +"<th>"+a.getEmail()+"</th>"
                                   +"<th>"+a.getPais()+"</th>"
                                   +"<br>"
                                   +"<th><a href='EditarDatosDelAlumno?id="+a.getId()+"'>Editar datos del alumno</a></th>"
                                   +"<br>"
                                   +"<th><a href='EliminarAlumno?id="+a.getId()+"'>Eliminar alumno</a></th>"
                                   +"</tr>");
                           out.println("</table>");
                       }
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
