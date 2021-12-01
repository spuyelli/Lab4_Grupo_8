package daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.MateriaDao;
import entidades.Materia;

public class MateriaDaoImpl implements MateriaDao {
	private Conexion cn;
	private static final String readall = "select materias.id, materias.descripcion from materias";
	
	public MateriaDaoImpl(){
		
	}
	

	@Override
	public List<Materia>  readAll()
	{
		cn = new Conexion();
		cn.Open();
		ArrayList<Materia> materias = new ArrayList<Materia>();
			
		System.out.println(readall);

		try 
		{
			ResultSet rs= cn.query(readall);
			while(rs.next())
			 {
				 Materia mat = new Materia();
				 mat.setIdMateria(rs.getInt("materias.id"));
				 mat.setDescripcion(rs.getString("materias.descripcion"));
				 materias.add(mat);
			 }
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return materias;
	}
}
