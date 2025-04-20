package pe.edu.tecsup.tienda.servlets;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pe.edu.tecsup.tienda.entities.Categoria;
import pe.edu.tecsup.tienda.services.CategoriaService;
import pe.edu.tecsup.tienda.services.ProductoService;

/**
 * Servlet implementation class ProductoRegistrarServlet
 */
@WebServlet("/ProductoRegistrarServlet")
public class ProductoRegistrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger log 
		= Logger.getLogger(ProductoRegistrarServlet.class);
	
	private CategoriaService categoriaService;

	private ProductoService productoService;
    
	/**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoRegistrarServlet() {
        super();
		this.categoriaService = new CategoriaService();
        this.productoService = new ProductoService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		log.info("doGet() ProductoRegistrarServlet");
		try {
			
			List<Categoria> categorias = categoriaService.listar();
			
			request.setAttribute("categorias", categorias);
			
			request.getRequestDispatcher("/WEB-INF/jsp/producto/registrar.jsp")
				   .forward(request, response);
	        
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
