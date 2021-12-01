package daoImpl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import daoImpl.Conexion;
import dao.PaisDao;
import entidades.Pais;

public class PaisDaoImpl implements PaisDao {

	
	private Conexion cn;
	//private static final String readall = "select cursos.anio, cursos.id, cursos.semestre, docentes.apellido, materias.descripcion from docentes join cursos on docentes.dni = cursos.dniDocente join materias on cursos.idMateria = materias.id ";
	private static final String test = "select paises.id, paises.descripcion from paises";
	
	public PaisDaoImpl()
	{
		
	}
	
	@Override
	public ArrayList<Pais> listarPaises()
	{
		cn = new Conexion();
		cn.Open();
		ArrayList<Pais> paises = new ArrayList<Pais>();
			
		//System.out.println(readall);

		try 
		{
			ResultSet rs= cn.query(test);
			while(rs.next())
			 {
				 Pais pai = new Pais();
				 pai.setIdPais(rs.getInt("paises.id"));
				 pai.setDescripcion(rs.getString("paises.descripcion"));
				 paises.add(pai);
				
			 }
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return paises;
	}
/**	
	public ArrayList<Pais> listarPaises() {
		
		ResultSet resultSet; 
		ArrayList<Pais> paises = new ArrayList<Pais>();
		Conexion conexionSql = null; 
		String query = "select id, descripcion from paises";
			
		try {
			conexionSql = new Conexion();
			Connection connection = conexionSql.getSQLConexion();
			PreparedStatement statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{	
				paises.add(
				new Pais(resultSet.getInt("id"), resultSet.getString("descripcion")));
			}
			
			return paises; 
				
		} 
		catch (SQLException e) {
			
			 e.printStackTrace();
		} 
		
		finally {
			conexionSql.cerrarConexion();
		}

        return null; 
	}
	
	**/
}
