package daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DocenteDao;
import entidades.Curso;
import entidades.Docente;
import entidades.Materia;
import entidades.Persona;

public class DocenteDaoImp implements DocenteDao {
	private Conexion cn;
	private static final String readall = "select * from docentes";
	public DocenteDaoImp()
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

}
