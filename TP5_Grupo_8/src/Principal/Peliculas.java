package Principal;

public class Peliculas {
	
	private Categorias Categoria;
	
	public Peliculas(Categorias categoria) {
		super();
		Categoria = categoria;
	}

	public Categorias getCategoria() {
		return Categoria;
	}

	public void setCategoria(Categorias categoria) {
		Categoria = categoria;
	}
}

