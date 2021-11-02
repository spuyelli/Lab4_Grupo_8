package entidades;

public class Usuario {
	private int dni;
	private String password;
	private boolean admin;
	
	public Usuario(int dni, String password, boolean admin) {
		this.dni = dni;
		this.password = password;
		this.admin = admin;
	}
		
	public int getLegajo() {
		return dni;
	}
	public void setLegajo(int legajo) {
		this.dni = legajo;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
