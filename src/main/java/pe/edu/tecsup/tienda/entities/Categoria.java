package pe.edu.tecsup.tienda.entities;

public class Categoria {



	private Integer id;
	
	private String nombre;
	
	private Integer orden;

	public Categoria(Integer id, String nombre, Integer orden) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.orden = orden;
	}
	
	
	
	public Categoria() {
		// TODO Auto-generated constructor stub
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nombre=" + nombre + ", orden=" + orden + "]";
	}

	
}
