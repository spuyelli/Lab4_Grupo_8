package daoImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

public class CursoDaoImpl  implements CursoDao{
	private Conexion cn;
	private static final String readall = "select cursos.anio, cursos.id, cursos.semestre, docentes.apellido, materias.descripcion from docentes join cursos on docentes.dni = cursos.dniDocente join materias on cursos.idMateria = materias.id ";
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
			
		System.out.println(readall);

		try 
		{
			ResultSet rs= cn.query(readall);
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
				cur.setDocente(per);
				cursos.add(cur);
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
	public boolean insertar(Curso curso)//VER
	{
		/*PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, curso.getIdPersona());
			statement.setString(2, curso.getNombre());
			statement.setString(3, curso.getTelefono());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isInsertExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return isInsertExitoso;
		*/
		return false;
	}
	
	public boolean delete(Curso curso_a_eliminar)//VER
	{
		/*
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(delete);
			statement.setString(1, Integer.toString(curso_a_eliminar.getIdPersona()));
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isdeleteExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return isdeleteExitoso;*/
		return false;
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
}
