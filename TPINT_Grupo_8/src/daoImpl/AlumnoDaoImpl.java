package daoImpl;

import java.util.List;
import dao.AlumnoDao;
import entidades.Alumno;
import entidades.Curso;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class AlumnoDaoImpl implements AlumnoDao {
	private Conexion cn;
	private static final String readall = "select * from universidad.alumnos where estado = '1'";
	private static final String insert = "INSERT INTO universidad.alumnos (dni, nombre, apellido, fechaNacimiento, idNacionalidad, domicilio, idLocalidad, email, telefono, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String select = "select * from universidad.alumnos where estado = 1 and dni = ?";
	private static final String delete = "delete from universidad.alumnos where dni = ?";

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
			statement.setString(2, alumno.getNombre());
			statement.setString(3, alumno.getApellido());
			statement.setString(4, alumno.getFechaNacimiento().toString());
			statement.setInt(5, alumno.getNacionalidad().getIdPais());
			statement.setString(6, alumno.getDomicilio().getCalle_Numero());
			statement.setInt(7, alumno.getLocalidad().getIdLocalidad());
			statement.setString(8, alumno.getEmail());
			statement.setInt(9, alumno.getTelefono());
			statement.setBoolean(10, true);

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
	public boolean agregarAlumnoACurso(Alumno alumno, Curso curso) {


		boolean estado=true;

		cn = new Conexion();
		cn.Open();


		String query = "INSERT INTO alumnosxcursos (dniAlumno,idCurso) VALUES ("+alumno.getDni()+","+curso.getIdCurso()+")";
		try
		 {
			estado=cn.execute(query);
		 }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			cn.close();
		}
		return estado;
	}


	public Alumno select(int dni) {
		PreparedStatement statement;
		ResultSet resultSet;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(select);
			statement.setInt(1, dni);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				return getAlumno(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean eliminarAlumno(int dni) {
/**		boolean eliminado = false;
		
		PreparedStatement statement;
		ResultSet resultSet;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		try {

			statement = conexion.prepareStatement(delete);
			statement.setInt(1, dni);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				return eliminado=true;
			}
//			if(resultSet != null) {return eliminado=true;}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return eliminado;
		
	**/	
		
		
			boolean estado=true;
			cn = new Conexion();
			cn.Open();		 
			String query = "UPDATE universidad.alumnos SET estado=0 WHERE dni="+dni;
			try
			 {
				estado=cn.execute(query);
			 }
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				cn.close();
			}
			return estado;
		
	}
}
