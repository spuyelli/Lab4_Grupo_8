package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import daoImpl.Conexion;
import dao.PaisDao;
import entidades.Pais;

public class PaisDaoImpl implements PaisDao {

	
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
	
	
}
