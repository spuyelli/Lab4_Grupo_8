package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DocenteDao;
import entidades.Alumno;
import entidades.Curso;
import entidades.Docente;
import entidades.Domicilio;
import entidades.Localidad;
import entidades.Materia;
import entidades.Pais;
import entidades.Persona;

public class DocenteDaoImpl implements DocenteDao {
	private Conexion cn;
	private static final String readall = "select * from docentes";
	 private static final String buscar ="select * from universidad.docentes where dni=?";

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

	
	public Docente BuscarDocente(int dni){
		Docente doc = new Docente();
		Conexion conexionSql = null;
		
		try {
			
			conexionSql = new Conexion();
			Connection connection  = Conexion.getConexion().getSQLConexion();
			PreparedStatement statement = connection.prepareStatement(buscar);
			statement.setInt(1, dni);
				
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
			 System.out.print(resultSet.getInt("legajo"));
		   	 doc.setDni(resultSet.getInt("dni"));
		   	doc.setLegajo(resultSet.getInt("legajo"));
		   	doc.setNombre(resultSet.getString("nombre"));
		   	doc.setApellido(resultSet.getString("apellido"));
		   	doc.setEmail(resultSet.getString("email"));
		   	doc.setTelefono(resultSet.getInt("telefono"));
		   	 
		    Domicilio dom = new Domicilio();
		   	dom.setCalle_Numero(resultSet.getString("domicilio"));
		   	doc.setDomicilio(dom);
				
			Pais pais = new Pais();
			pais.setIdPais(resultSet.getInt("idNacionalidad"));
			doc.setNacionalidad(pais);
				
			Localidad loc = new Localidad();
			loc.setIdLocalidad(resultSet.getInt("idLocalidad"));
			doc.setLocalidad(loc);
				
			Persona pers = new Persona();
			pers.setFechaNacimiento(resultSet.getDate("fechaNacimiento").toLocalDate());
			doc.setFechaNacimiento(pers.getFechaNacimiento());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return doc;
		
	}
	
	public boolean ModificaDocente(Docente doc){
		//dni actual //3
		// TODO Auto-generated method stub
		
	Conexion conexionSql = null; 
				
		    conexionSql = new Conexion();
			Connection connection  = Conexion.getConexion().getSQLConexion();

			try {
				PreparedStatement statement = connection.prepareStatement(buscar);
				System.out.println("llamada a modificar");
				
				
				
				statement.setString(1, doc.getNombre());
				statement.setString(2, doc.getApellido());
				
				statement.setString(3, doc.getFechaNacimiento().toString());
			
			//	statement.setInt(5, alumno.getNacionalidad().getIdPais());
				statement.setString(4, doc.getDomicilio().getCalle_Numero());

			//	statement.setInt(7, alumno.getLocalidad().getIdLocalidad());
				statement.setString(5, doc.getEmail());
		
				statement.setInt(6, doc.getTelefono());
				
				
				
				statement.setInt(7, doc.getDni());
				
				System.out.println(doc.getNombre()+ doc.getApellido() + doc.getDni());
				
				if(statement.executeUpdate()==1) {
					connection.commit();
					return true;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		 return false;
	
	}
	
}
