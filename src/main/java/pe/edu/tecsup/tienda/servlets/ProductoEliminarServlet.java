package pe.edu.tecsup.tienda.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pe.edu.tecsup.tienda.services.ProductoService;

import java.io.IOException;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class ProductoEliminarServlet
 */
@WebServlet("/ProductoEliminarServlet")
public class ProductoEliminarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger log 
	= Logger.getLogger(ProductoEliminarServlet.class);
	
	private ProductoService productoService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoEliminarServlet() {
        super();
	    this.productoService =  new ProductoService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		log.info("Get ProductoEliminarServlet");
		try {
			
			Integer id = Integer.parseInt(request.getParameter("id"));
			
			productoService.eliminar(id);
			
			response.sendRedirect(request.getContextPath() + "/ProductoListarServlet");
	        
		} catch (Exception e) {
			log.error(e, e);
			throw new ServletException(e.getMessage(), e);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
