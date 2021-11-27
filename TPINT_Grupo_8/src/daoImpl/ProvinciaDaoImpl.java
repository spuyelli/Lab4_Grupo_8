package daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.ProvinciaDao;
import entidades.Pais;
import entidades.Provincia;

public class ProvinciaDaoImpl implements ProvinciaDao{
	
	private Conexion cn;
	private static final String test = "select provincias.id, provincias.descripcion from provincias";
	
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
	
}
