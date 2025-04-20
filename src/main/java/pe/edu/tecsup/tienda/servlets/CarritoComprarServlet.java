package pe.edu.tecsup.tienda.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pe.edu.tecsup.tienda.entities.Producto;
import pe.edu.tecsup.tienda.services.ProductoService;

/**
 * Servlet implementation class CarritoComprarServlet
 */
@WebServlet("/CarritoComprarServlet")
public class CarritoComprarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger log = Logger.getLogger(CarritoComprarServlet.class);  
	
	private ProductoService productoService;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarritoComprarServlet() {
        super();
		this.productoService = new ProductoService();
   }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		log.info("Post CarritoComprarServlet");
		try {
		
			String idProducto = request.getParameter("id");
			
			int id = Integer.parseInt(idProducto);
			
			Producto producto = this.productoService.obtener(id);
			
			log.info("produco --> " + producto);
			
			
			// Usando la session
			
			HttpSession session = request.getSession();
			
			// Busco mis pedidos
			
			List<Producto> misPedidos 
				= (List<Producto>)session.getAttribute("mis_pedidos");
			
			if(misPedidos == null) {
				// Estoy en mi primer pedido	
				misPedidos = new ArrayList<Producto>();
				misPedidos.add(producto);
				
			} else {
				// Ya create el pedido
				misPedidos.add(producto);
			}
			
			session.setAttribute("mis_pedidos", misPedidos);
			
			request.getSession().setAttribute("success", "Producto añadido al carrito");
			
			response.sendRedirect(request.getContextPath() + "/CarritoListarServlet");
			
			
			
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
