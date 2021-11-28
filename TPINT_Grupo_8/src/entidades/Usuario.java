package entidades;

public class Usuario extends Persona{
	private String password;
	private int tipoUsuario;
	private boolean estado;
	
	public Usuario(int dni, String password, int tipoUsuario, boolean estado, String nombre, String apellido) {
		setDni(dni);
		this.password = password;
		this.tipoUsuario = tipoUsuario;
		this.estado = estado;
		setNombre(nombre);
		setApellido(apellido);
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	public String getNombreApellido() {
		String nombreApellido = "";
		nombreApellido += getNombre();
		nombreApellido += " ";
		nombreApellido += getApellido();
		return nombreApellido;
	}
	
}
