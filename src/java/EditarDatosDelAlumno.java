import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditarDatosDelAlumno extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            //Debemos obtener el id para buscar al alumno por medio de este:
            int id;
            //Obtenemos el parámetro del id:
            id=Integer.parseInt(request.getParameter("id"));
            
            //Obtenemos datos del alumno con su id
            Alumno a=AccionesDelAlumno.getAlumnoById(id);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Ficha de los datos del alumno</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Ficha para editar los datos del alumno</h1>");
            out.println("<form method='get' name='formulario' action='EditarDatosDelAlumno2'>");
            out.println("<table border='1'>");
            out.println("<tr>"
                    + "<td></td>"
                    + "<td><input type='hidden' name='id2' value='"+a.getId()+"'></td>"
                    + "</tr>"
                    + "<tr>"
                    + "<td>Nombre</td>"
                    + "<td><input type='text' name='nombre2' value='"+a.getNombre()+"'></td>"
                    + "</tr>"
                    + "<tr>"
                    + "<td>Password</td>"
                    + "<td><input type='password' name='password2' value='"+a.getPassword()+"'></td>"
                    + "</tr>"
                    + "<tr>"
                    + "<td>Email</td>"
                    + "<td><input type='email' name='email2' value='"+a.getEmail()+"'></td>"
                    + "</tr>"
                    + "<tr><td>País</td><td><select name='pais2'>"
                            + "<option>India</option>"
                            + "<option>México</option>"
                            + "<option>Alemania</option>"
                            + "<option>Scandinavia</option>"
                            + "</select></td></tr>"
                            + "<tr><td colspan='2'><input type='submit' value='Modificar'></td></tr>");
            
            out.println("</table>");
            out.println("</form>");
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
