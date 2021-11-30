package negocioImpl;

import java.util.ArrayList;
import dao.AlumnoDao;
import daoImpl.AlumnoDaoImpl;
import entidades.Alumno;
import entidades.Curso;
import negocio.AlumnoNeg;

public class AlumnoNegImpl implements AlumnoNeg{
	private AlumnoDao aluDao = new AlumnoDaoImpl();
	
	public AlumnoNegImpl(){

	}

	public ArrayList<Alumno> listarAlumnos() {
		return (ArrayList<Alumno>) aluDao.readAll();
	}

	@Override
	public boolean actualizarAlumno(Alumno al) {
		aluDao.ModificarAlumno(al);
		return false;
	}

	@Override
	public boolean agregarAlumno(Alumno alumno) {
		AlumnoDao alumnoDao = new AlumnoDaoImpl();
		return alumnoDao.agregarAlumno(alumno);
	}

	@Override
	public Alumno select(int dni) {
		return aluDao.select(dni);
	}
	
	public Alumno select_all(int dni) {
		return aluDao.select_all(dni);
	}

	public boolean agregarAlumnoACurso(Alumno alumno, Curso curso) {
		AlumnoDao alumnoDao = new AlumnoDaoImpl();
		return alumnoDao.agregarAlumnoACurso(alumno, curso);
	}

	@Override
	public boolean eliminarAlumno(int dni) {
		boolean eliminado =false;
		
		eliminado= aluDao.eliminarAlumno(dni);
		
		return eliminado;
	}

	
	public Alumno buscarAlumno(int dni) {
		System.out.print("esto es negocio buscar alumno:" + dni);
	return aluDao.BuscarAlumno(dni);
		
	}
	
	
}
