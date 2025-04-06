package pe.edu.tecsup.tienda.services;

import java.util.List;

import pe.edu.tecsup.tienda.entities.Categoria;
import pe.edu.tecsup.tienda.repositories.CategoriaRepository;

public class CategoriaService {

	
	private CategoriaRepository categoriaRepository;
	
	
	public CategoriaService() {
	
		this.categoriaRepository = new CategoriaRepository();
	
	}


	public List<Categoria> listar() throws Exception{
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
