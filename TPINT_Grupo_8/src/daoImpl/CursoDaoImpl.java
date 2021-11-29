package daoImpl;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.CursoDao;
import daoImpl.Conexion;
//import datosImpl.Exception;
//import datosImpl.Override;
//import datosImpl.String;
import entidades.Curso;
import entidades.Materia;
import entidades.Persona;
import entidades.Usuario;

public class CursoDaoImpl  implements CursoDao{

	private Conexion cn;
	private static final String readall = "select cursos.anio, cursos.id, cursos.semestre, docentes.apellido, docentes.nombre, materias.descripcion from docentes join cursos on docentes.dni = cursos.dniDocente join materias on cursos.idMateria = materias.id ";

	private static final String select = "select cursos.anio, cursos.id, cursos.semestre, docentes.apellido, materias.descripcion from docentes join cursos on docentes.dni = cursos.dniDocente join materias on cursos.idMateria = materias.id where cursos.id = ?";


	private static final String test = "select * from cursos";
	public CursoDaoImpl()
	{

	}
	@Override
	public List<Curso> readAll()
	{
		cn = new Conexion();
		cn.Open();
		ArrayList<Curso> cursos = new ArrayList<Curso>();


		try
		{
			ResultSet rs= cn.query(readall);
			while(rs.next())
			 {
				/*
				 Curso cur = new Curso();
				 cur.setIdCurso(rs.getInt("cursos.id"));
				 cur.setSemestre(rs.getInt("cursos.semestre"));
				 cur.setAño(rs.getInt("cursos.anio"));

				 Materia mat = new Materia();
				 mat.setDescripcion(rs.getString("materias.descripcion"));
				 cur.setMateria(mat);


				Persona per = new Persona();
				per.setApellido(rs.getString("docentes.apellido"));
				per.setNombre(rs.getString("docentes.nombre"));
				cur.setDocente(per);
				cursos.add(cur);
*/
				cursos.add(getCurso(rs));

			 }
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return cursos;
	}





	@Override
	public Curso obtenerUltimo() {//VER
		cn = new Conexion();
		cn.Open();
		Curso c = new Curso();
		try
		 {
			 ResultSet rs= cn.query("select * from cursos order by id desc limit 1");
			 rs.next();

			 c.setIdCurso(rs.getInt("cursos.id"));
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 finally
		 {
			 cn.close();
		 }
		return c;
	}

	@Override


public boolean insertar(Curso curso) {

		boolean estado=true;

		cn = new Conexion();
		cn.Open();

		String query = "INSERT INTO cursos (idMateria,dniDocente,semestre,anio) VALUES ('"+curso.getMateria().getIdMateria()+"','"+curso.getDocente().getDni()+"','"+curso.getSemestre()+"', '"+curso.getAño()+"')";

		try
		 {
			estado=cn.execute(query);
		 }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			cn.close();
		}
		return estado;
	}




	public Curso select(int id) {
		cn.Open();
		ResultSet resultSet;
		try {
			PreparedStatement statement = cn.getSQLConexion().prepareStatement(select);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				return getCurso(resultSet);
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Curso getCurso(ResultSet resultSet) throws SQLException {
		Curso cur = new Curso();
		cur.setIdCurso(resultSet.getInt("cursos.id"));
		cur.setSemestre(resultSet.getInt("cursos.semestre"));
		cur.setAño(resultSet.getInt("cursos.anio"));

		Materia mat = new Materia();
		mat.setDescripcion(resultSet.getString("materias.descripcion"));
		cur.setMateria(mat);

		Persona per = new Persona();
		per.setApellido(resultSet.getString("docentes.apellido"));
		per.setNombre(resultSet.getString("docentes.nombre"));
		cur.setDocente(per);
		return cur;
	}
	
	@Override
	public List<Curso> readAllUser(int user) {
		cn = new Conexion();
		cn.Open();
		ArrayList<Curso> cursos = new ArrayList<Curso>();
	
		String query = "select cursos.anio, cursos.id, cursos.semestre, docentes.apellido, docentes.nombre, materias.descripcion from docentes join cursos on docentes.dni = cursos.dniDocente join materias on cursos.idMateria = materias.id where cursos.dniDocente = '"+user+"'";
		//String query = "select cursos.anio, cursos.id, cursos.semestre, docentes.apellido, docentes.nombre, materias.descripcion from docentes join cursos on docentes.dni = cursos.dniDocente join materias on cursos.idMateria = materias.id where cursos.dniDocente = 77777777";
		try
		{
			ResultSet rs= cn.query(query);
			while(rs.next())
			 {
				
				 Curso cur = new Curso();
				 cur.setIdCurso(rs.getInt("cursos.id"));
				 cur.setSemestre(rs.getInt("cursos.semestre"));
				 cur.setAño(rs.getInt("cursos.anio"));

				 Materia mat = new Materia();
				 mat.setDescripcion(rs.getString("materias.descripcion"));
				 cur.setMateria(mat);


				Persona per = new Persona();
				per.setApellido(rs.getString("docentes.apellido"));
				per.setNombre(rs.getString("docentes.nombre"));
				cur.setDocente(per);
				cursos.add(cur);

				//cursos.add(getCurso(rs));

			 }
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return cursos;
	}
	@Override
	public Curso obtenerUno(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
