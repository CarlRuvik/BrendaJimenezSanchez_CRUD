import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GuardarRegistro extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            //Obtenemos los parámetros que vienen del formulario(index.html)
            String srvnombre,srvpassword,srvemail,srvpais;
            
            //Debemos obtener la solicitud(request) de los parámetros anteriosres:
            srvnombre=request.getParameter("nombre");
            srvpassword=request.getParameter("password");
            srvemail=request.getParameter("email");
            srvpais=request.getParameter("pais");
            
            //Necesitamos de nuevo la clase Alumno:
            Alumno a=new Alumno();
            
            //Enviamos los datos obtenidos mediante los parámetros a la clase Alumno:
            a.setNombre(srvnombre);
            a.setPassword(srvpassword);
            a.setEmail(srvemail);
            a.setPais(srvpais);
            
            //Ejecutamos el método para comunicar la clase AccionesDelAlumno con el servlet
            int estado=AccionesDelAlumno.GuardarAlumno(a);
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Alumno registrado.</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/ESTILO.css\">");
            out.println("</head>");
            out.println("<body>");
            
            if(estado>0)
            {
                out.println("<h1>Alumno registrado con éxito.</h1>");
            }
            else
            {
                out.println("<h1>No se pudo registrar el alumno.</h1>");
            }
            out.println("<a class='LINK2' href='index.html'>Regresar al menú principal</a>");
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
