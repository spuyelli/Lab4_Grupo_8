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
	private Conexion cn = new Conexion();
	private static final String select = "select cursos.anio, cursos.id, cursos.semestre, docentes.apellido, materias.descripcion from docentes join cursos on docentes.dni = cursos.dniDocente join materias on cursos.idMateria = materias.id where cursos.id = ?";
	private static final String readall = "select cursos.anio, cursos.id, cursos.semestre, docentes.apellido, materias.descripcion from docentes join cursos on docentes.dni = cursos.dniDocente join materias on cursos.idMateria = materias.id ";
	private static final String test = "select * from cursos";
	public CursoDaoImpl()
	{
		
	}
	@Override
	public List<Curso> readAll()
	{
		cn.Open();
		ArrayList<Curso> cursos = new ArrayList<Curso>();
			
		System.out.println(readall);

		try 
		{
			ResultSet rs= cn.query(readall);
			while(rs.next())
			 {
				cursos.add(getCurso(rs));
			 }
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return cursos;
	}
	
	
	/*public List<Curso> obtenerUnos() {//PARA EL BUSCADOR
		cn = new Conexion();
		cn.Open();
		 List<Curso> list = new ArrayList<Curso>();
		 try
		 {
			 ResultSet rs= cn.query("Select articulos.idArticulo, articulos.nombre, articulos.precio, articulos.estado, categorias.idCategoria, categorias.nombre , categorias.estado from articulos inner join categorias on articulos.idCategoria = categorias.idCategoria");
			 while(rs.next())
			 {
				 Curso cur = new Curso();
				 cur.setIdArticulo(rs.getInt("articulos.idArticulo"));
				 cur.setNombre(rs.getString("articulos.nombre"));
				 cur.setPrecio(rs.getFloat("articulos.precio"));
				 
				 //Categoria cat = new Categoria();
				 //cat.setIdCategoria(rs.getInt("categorias.idCategoria"));
				 //cat.setNombre(rs.getString("categorias.nombre"));
				 //cat.setEstado(rs.getInt("categorias.estado"));
				 
				 //cur.setCategoria(cat);
				 //cur.setEstado(rs.getInt("articulos.estado"));
				 list.add(cur);
			 }
			 
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 finally
		 {
			 cn.close();
		 }
		 return list;
	}
	*/

	
	@Override
	public Curso obtenerUno(int id) {//VER
		/*cn = new Conexion();
		cn.Open();
		Articulo art = new Articulo();
		try
		 {
			 ResultSet rs= cn.query("Select articulos.idArticulo, articulos.nombre, articulos.precio, articulos.estado, categorias.idCategoria, categorias.nombre , categorias.estado from articulos inner join categorias on articulos.idCategoria = categorias.idCategoria where articulos.estado=1 && articulos.idArticulo="+id);
			 rs.next();
			 
			 art.setIdArticulo(rs.getInt("articulos.idArticulo"));
			 art.setNombre(rs.getString("articulos.nombre"));
			 art.setPrecio(rs.getFloat("articulos.precio"));
			 
			 Categoria cat = new Categoria();
			 cat.setIdCategoria(rs.getInt("categorias.idCategoria"));
			 cat.setNombre(rs.getString("categorias.nombre"));
			 cat.setEstado(rs.getInt("categorias.estado"));
			 
			 art.setCategoria(cat);
			 art.setEstado(rs.getInt("articulos.estado"));
			 
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 finally
		 {
			 cn.close();
		 }*/
		//return art;
		return null;
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

	
	@Override
	public boolean editar(Curso curso) {//VER
		/*
		boolean estado=true;

		cn = new Conexion();
		cn.Open();	

		String query = "UPDATE  articulos SET nombre='"+articulo.getNombre()+"', precio='"+articulo.getPrecio()+"', idCategoria='"+articulo.getCategoria().getIdCategoria()+"', estado='"+articulo.getEstado()+"' WHERE idArticulo='"+articulo.getIdArticulo()+"'";
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
		*/
		return false;
	}
	
	@Override
	public boolean borrar(int id) {//VER
		/*boolean estado=true;
		cn = new Conexion();
		cn.Open();		 
		String query = "UPDATE articulos SET estado=0 WHERE idArticulo="+id;
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
	*/
		return false;
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
		cur.setDocente(per);
		return cur;
	}
}
