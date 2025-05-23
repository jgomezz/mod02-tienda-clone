package pe.edu.tecsup.tienda.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import pe.edu.tecsup.tienda.entities.Categoria;
import pe.edu.tecsup.tienda.utils.ConexionBD;

public class CategoriaRepository {

	private static final Logger log 
		= Logger.getLogger(CategoriaRepository.class);

	public List<Categoria> listar() throws Exception{
		
		log.info("Obtenido las categorias desde el repositorio");
	
		List<Categoria> categorias = new ArrayList<>();
	
		// Establece la conexion a la base de datos
		Connection con = ConexionBD.obtenerConexion();

		// Realiza la consulta a la base de datos
		String query = "SELECT * FROM categorias ORDER BY orden";
		PreparedStatement stmt = con.prepareStatement(query);
		ResultSet rs = stmt.executeQuery();
				
		while (rs.next()) {
			Categoria categoria = new Categoria();
			categoria.setId(rs.getInt("id"));
			categoria.setNombre(rs.getString("nombre"));
			categoria.setOrden(rs.getInt("orden"));
			categorias.add(categoria);
		}
		
		rs.close();
		stmt.close();
		con.close();
		
		log.info("categorias: " + categorias);
			
		
		return categorias;
	
	
	
	}

}
