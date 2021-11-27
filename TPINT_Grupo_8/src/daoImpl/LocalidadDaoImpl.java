package daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.LocalidadDao;
import entidades.Localidad;

public class LocalidadDaoImpl implements LocalidadDao {
	
	private Conexion cn;
	private static final String test = "select localidades.id, localidades.descripcion from localidades";
	
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
}
