package pe.edu.tecsup.tienda.repositories;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import pe.edu.tecsup.tienda.entities.Categoria;

public class CategoriaRepository {

	private static final Logger log 
		= Logger.getLogger(CategoriaRepository.class);

	public List<Categoria> listar() throws Exception{
		
		log.info("Obtenido las categorias desde el repositorio");
	
		List<Categoria> categorias = new ArrayList<>();
		
		
		categorias.add(new Categoria(1,"Procesadores",1));
		categorias.add(new Categoria(2,"Memorias",2));
		categorias.add(new Categoria(3,"Discos Duros",3));
			
		
		return categorias;
	
	
	
	}

}
