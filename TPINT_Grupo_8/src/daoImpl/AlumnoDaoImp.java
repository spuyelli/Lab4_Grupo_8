package daoImpl;

import java.util.List;
import java.util.concurrent.locks.StampedLock;

import dao.AlumnoDao;
import entidades.Alumno;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class AlumnoDaoImp implements AlumnoDao {
	
	private static final String readall = "select * from universidad.alumnos where estado = 1";
	
	
	public List<Alumno> readAll(){
		
		ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
		
		PreparedStatement statement;
		ResultSet resultSet;		
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				listaAlumnos.add(getAlumno(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaAlumnos;
		
	}



	private Alumno getAlumno(ResultSet resultSet) throws SQLException {
		
		int dni = resultSet.getInt("dni");
		int legajo = resultSet.getInt("legajo");
		String nombre = resultSet.getString("nombre");
		String apellido = resultSet.getString("apellido");		
		String email = resultSet.getString("email");
		int telefono = resultSet.getInt("telefono");
		
		
		return new Alumno(dni, legajo, nombre, apellido, email, telefono);		
		
	}
	
	public Boolean buscarDni(int dni) {
		PreparedStatement statement;
		ResultSet resultSet;	
		Connection conexion = Conexion.getConexion().getSQLConexion();
		try {
			
			statement = conexion.prepareStatement("select  * from alumnos where dni = "+dni+"");
			resultSet = statement.executeQuery();
			if(resultSet != null) {return true;}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	public Boolean actualizarAlumno(Alumno al) {
		PreparedStatement statement;
		ResultSet resultSet;	
		Connection conexion = Conexion.getConexion().getSQLConexion();
		try {
			statement = conexion.prepareStatement("update alumnos set nombre ='"+al.getNombre()  +" ' , apellido = '"+al.getApellido()+"' , domicilio = '"+al.getDomicilio()+"', fechaNacimiento ='"+al.getFechaNacimiento()+"',idNacionalidad='"+al.getNacionalidad()+"', idLocalidad='"+al.getNacionalidad()+"', email='"+al.getEmail()+"', telefono='"+al.getTelefono()+" where dni = '"+al.getDni()+"'"
			);
			resultSet = statement.executeQuery();
			if(resultSet != null) {return true;}
		} catch (SQLException e) {
			e.printStackTrace();
		}return false;
	}
	
	
}
