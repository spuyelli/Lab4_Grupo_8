package entidades;

public class Usuario {
	private int dni;
	private String password;
	private int tipoUsuario;
	private boolean estado;
	public Usuario(int dni, String password, int tipoUsuario, boolean estado) {
		this.dni = dni;
		this.password = password;
		this.tipoUsuario = tipoUsuario;
		this.estado = estado;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
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
	
}
