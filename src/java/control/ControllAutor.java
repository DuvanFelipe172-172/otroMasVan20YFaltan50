
package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Autor;
import modelo.AutorDAO;


/**
 *
 * @author Duvan Felipe
 */
public class ControllAutor extends HttpServlet {
    AutorDAO dao=new AutorDAO();
    Autor autor=new Autor();
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControllAutor</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllAutor at " + request.getContextPath() + "</h1>");
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
        
        String accion=request.getParameter("accion");
        switch(accion){
            case "Listar":
                List<Autor>datos=dao.listar();
                request.setAttribute("datos", datos);
                request.getRequestDispatcher("Autor.jsp").forward(request, response);
                break;
            case "Nuevo":
                request.getRequestDispatcher("addAutor.jsp").forward(request, response);
                break;
            case "Guardar":
                String id=request.getParameter("txtid");
                String nombre=request.getParameter("txtnombre");
                String cargo=request.getParameter("txtcargo");
                
                autor.setId_autor(Integer.parseInt(id));
                autor.setNombre(nombre);
                autor.setCargo(cargo);
                
                
                dao.agregar(autor);
                request.getRequestDispatcher("ControladorAdmin?accion=Listar").forward(request, response);
                break;
            case "Editar":
                
                String idAutor=request.getParameter("id");
                Autor autor=dao.listarId(idAutor);
                request.setAttribute("autor", autor);
                request.getRequestDispatcher("editAutor.jsp").forward(request, response);
                break;
            case "Actualizar":
                String id1=request.getParameter("txtid");
                String nombre1=request.getParameter("txtnombre");
                String cargo1=request.getParameter("txtcargo");
               
                Autor aux = new Autor(Integer.parseInt(id1),nombre1,cargo1);
                
                
                dao.actualizar(aux);
                request.getRequestDispatcher("Controlador?accion=Listar").forward(request, response);
                break;
            case "Borrar":
                String id2=request.getParameter("id");
                dao.delete(id2);
                request.getRequestDispatcher("ControladorAdmin?accion=Listar").forward(request, response);
                break;
            default:
                throw new AssertionError();
        }
        
         

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
