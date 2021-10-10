package Principal;

public class Peliculas implements Comparable<Peliculas> {

	private Categorias categoria;
	private static int idCont = 0;
	private final int id;
	private String nombre;

	public Peliculas(Categorias categoria, String nombre) {
		this.id = ++Peliculas.idCont;
		this.categoria = categoria;
		this.nombre = nombre;
	}

	public Categorias getCategoria() {
		return categoria;
	}

	public void setCategoria(Categorias categoria) {
		this.categoria = categoria;
	}

	public int getID() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return id + " - " + nombre + " - " + categoria.getCategoria();
	}

	static int getProximoID() {
		return idCont + 1;
	}

	@Override
	public int compareTo(Peliculas o) {
		return this.nombre.toUpperCase().compareTo(o.nombre.toUpperCase());
	}
}
