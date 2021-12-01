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
	
	private Conexion cn;
	private static final String readAll = "select paises.id, paises.descripcion from paises";
	private static final String select = "select * from paises where id = ?";
	
	public PaisDaoImpl()
	{
		
	}
	
	@Override
	public ArrayList<Pais> listarPaises()
	{
		cn = new Conexion();
		cn.Open();
		ArrayList<Pais> paises = new ArrayList<Pais>();
		try 
		{
			ResultSet rs= cn.query(readAll);
			while(rs.next())
			 {
				 Pais pai = new Pais();
				 pai.setIdPais(rs.getInt("id"));
				 pai.setDescripcion(rs.getString("descripcion"));
				 paises.add(pai);
			 }
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return paises;
	}
	
	public Pais select(int id) {
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
	
	private Pais getPais(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("id");
		String desc = resultSet.getString("descripcion");
		Pais p = new Pais();
		p.setIdPais(id);
		p.setDescripcion(desc);
		return p;
	}

}
