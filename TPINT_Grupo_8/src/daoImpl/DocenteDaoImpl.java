package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DocenteDao;
import entidades.Docente;


public class DocenteDaoImpl implements DocenteDao {
	private Conexion cn;
	private static final String readall = "select * from docentes";
	private static final String insert = "INSERT INTO universidad.docentes (dni, nombre, apellido, fechaNacimiento, idNacionalidad, domicilio, idLocalidad, email, telefono, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	public DocenteDaoImpl()
	{
		
	}
	@Override
	public List<Docente> readAll()
	{
		cn = new Conexion();
		cn.Open();
		ArrayList<Docente> docentes = new ArrayList<Docente>();
			
		System.out.println(readall);

		try 
		{
			ResultSet rs= cn.query(readall);
			while(rs.next())
			 {
				 Docente doc = new Docente();
				 doc.setApellido(rs.getString("docentes.apellido"));
				 doc.setDni(rs.getInt("docentes.dni"));
				 doc.setLegajo(rs.getInt("docentes.legajo"));
				 doc.setNombre(rs.getString("docentes.nombre"));
				
				docentes.add(doc);
			 }
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return docentes;
	}
	@Override
	public boolean insert() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean agregarDocente(Docente docente) {
		Conexion conexionSql = null; 
		
		try {	
		    conexionSql = new Conexion();
			Connection connection  = Conexion.getConexion().getSQLConexion();
			
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setInt(1, docente.getDni());
			statement.setString(2, docente.getNombre());
			statement.setString(3, docente.getApellido());
			statement.setString(4, docente.getFechaNacimiento().toString());
			statement.setInt(5, docente.getNacionalidad().getIdPais());
			statement.setString(6, docente.getDomicilio().getCalle_Numero());
			statement.setInt(7, docente.getLocalidad().getIdLocalidad());
			statement.setString(8, docente.getEmail());
			statement.setInt(9, docente.getTelefono());
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

}
