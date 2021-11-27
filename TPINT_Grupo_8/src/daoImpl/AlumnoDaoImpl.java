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


public class AlumnoDaoImpl implements AlumnoDao {
	
	private static final String readall = "select * from universidad.alumnos where estado = 1";
	private static final String insert = "INSERT INTO universidad.alumnos (dni, legajo, nombre, apellido, fechaNacimiento, idNacionalidad, domicilio, idLocalidad, email, telefono, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	
	public AlumnoDaoImpl()
	{
		
	}
	
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
	
	public boolean agregarAlumno(Alumno alumno) { 
		 
		Conexion conexionSql = null; 
		

		try {
			
		    conexionSql = new Conexion();
			Connection connection  = Conexion.getConexion().getSQLConexion();
			
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setInt(1, alumno.getDni());
			statement.setInt(2, 9999);
			statement.setString(3, alumno.getNombre());
			statement.setString(4, alumno.getApellido());
			statement.setString(5, alumno.getFechaNacimiento().toString());
			statement.setInt(6, alumno.getNacionalidad().getIdPais());
			statement.setString(7, alumno.getDomicilio().getCalle_Numero());
			statement.setInt(8, alumno.getLocalidad().getIdLocalidad());
			statement.setString(9, alumno.getEmail());
			statement.setInt(10, alumno.getTelefono());
			statement.setBoolean(11, true);
			
			if(statement.executeUpdate()==1) {
				connection.commit();
				return true;
			}
				
		} catch (SQLException e) {
			
			 e.printStackTrace();
		} 
		
		finally {
			conexionSql.cerrarConexion();
		}

		return false;
	
	}
}

