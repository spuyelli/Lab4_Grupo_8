package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dao.ProvinciaDao;
import entidades.Provincia;
import negocioImpl.PaisNegImpl;

public class ProvinciaDaoImpl implements ProvinciaDao{
	
	private Conexion cn;
	private static final String test = "select provincias.id, provincias.descripcion from provincias";
	private static final String select = "select * from provincias where id = ?";
	
	public ProvinciaDaoImpl()
	{
		
	}
	
	@Override
	public ArrayList<Provincia> listarProvincias() {
		cn = new Conexion();
		cn.Open();
		ArrayList<Provincia> provincias = new ArrayList<Provincia>();

		try 
		{
			ResultSet rs= cn.query(test);
			while(rs.next())
			 {
				 Provincia prov = new Provincia();
				 prov.setIdProvincia(rs.getInt("provincias.id"));
				 prov.setDescripcion(rs.getString("provincias.descripcion"));
				 provincias.add(prov);
				
			 }
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return provincias;
		
	}
	
	public Provincia select(int id) {
		Connection conexion = Conexion.getConexion().getSQLConexion();
		ResultSet resultSet;
		try {
			PreparedStatement statement = conexion.prepareStatement(select);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				return getProvincia(resultSet);
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private Provincia getProvincia(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("id");
		String desc = resultSet.getString("descripcion");
		int idPais = resultSet.getInt("idPais");
		Provincia p = new Provincia();
		p.setIdProvincia(id);
		p.setDescripcion(desc);
		p.setIdPais( new PaisNegImpl().select(idPais) );
		return p;
	}
}
