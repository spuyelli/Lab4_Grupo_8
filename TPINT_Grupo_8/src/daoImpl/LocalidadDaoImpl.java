package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dao.LocalidadDao;
import entidades.Localidad;

public class LocalidadDaoImpl implements LocalidadDao {
	
	private Conexion cn;
	private static final String test = "select localidades.id, localidades.descripcion from localidades";
	private static final String select = "select * from localidades where id = ?";
	
	public LocalidadDaoImpl()
	{
		
	}
	
	@Override
	public ArrayList<Localidad> listarLocalidades() {
		cn = new Conexion();
		cn.Open();
		ArrayList<Localidad> localidades = new ArrayList<Localidad>();

		try 
		{
			ResultSet rs= cn.query(test);
			while(rs.next())
			 {
				 Localidad localidad = new Localidad();
				 localidad.setIdLocalidad(rs.getInt("localidades.id"));
				 localidad.setDescripcion(rs.getString("localidades.descripcion"));
				 localidades.add(localidad);
				
			 }
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return localidades;
	}
	
	public Localidad select(int id) {
		Connection conexion = Conexion.getConexion().getSQLConexion();
		ResultSet resultSet;
		try {
			PreparedStatement statement = conexion.prepareStatement(select);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				return getPais(resultSet);
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private Localidad getPais(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("id");
		String desc = resultSet.getString("descripcion");
		int idProv = resultSet.getInt("idProvincia");
		Localidad l = new Localidad();
		l.setIdLocalidad(id);
		l.setDescripcion(desc);
		l.setIdProvincia(new ProvinciaDaoImpl().select(idProv));
		return l;
	}
}
