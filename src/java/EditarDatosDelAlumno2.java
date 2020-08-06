import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditarDatosDelAlumno2 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            
            //Debemos obtener las variables
            int id;
            String srvnombre,srvpassword,srvemail,srvpais;
                        
            id=Integer.parseInt(request.getParameter("id2"));
            srvnombre=request.getParameter("nombre2");
            srvnombre=request.getParameter("nombre2");
            srvpassword=request.getParameter("password2");
            srvemail=request.getParameter("email2");
            srvpais=request.getParameter("pais2");
            
            //Generamos un objeto del alumno
            Alumno a=new Alumno();
            
            //Enviamos los datos del alumno
            a.setId(id);
            a.setNombre(srvnombre);
            a.setPassword(srvpassword);
            a.setEmail(srvemail);
            a.setPais(srvpais);
            
            //Debemos ejecutar la query
            int estado=AccionesDelAlumno.ModificarDatosDelAlumno(a);
            
            if(estado>0)
            {
                response.sendRedirect("ConsultarLista");
            }
            else
            {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet EditarDatosDelAlumno2</title>");
                out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/ESTILO.css\">");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Error al obtener los datos.</h1>"
                        + "<br>"
                        + "<a class='LINK2' href='index.html'>Regresar al menu principal</a>");
                out.println("</body>");
                out.println("</html>");
            }
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
