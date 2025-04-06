package pe.edu.tecsup.tienda.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pe.edu.tecsup.tienda.entities.Categoria;
import pe.edu.tecsup.tienda.services.CategoriaService;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class CategoriaListarServlet
 */
@WebServlet("/CategoriaListarServlet")
public class CategoriaListarServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private static final Logger log 
		= Logger.getLogger(CategoriaListarServlet.class);
	
	private CategoriaService categoriaService;

	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoriaListarServlet() {
        super();
        
        this.categoriaService = new CategoriaService();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		log.info("Obteniendo las categorias de la tienda");
		
		try {
		
			List<Categoria> categorias = this.categoriaService.listar();
			
			log.info("Categorias obtenidas --> " +  categorias);
			

		} catch (Exception e) {
			
			e.printStackTrace();
		
		}
		
		
		
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
