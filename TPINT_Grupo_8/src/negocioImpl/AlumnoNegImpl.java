package negocioImpl;

import java.util.ArrayList;

import dao.AlumnoDao;
import dao.CursoDao;
import daoImpl.AlumnoDaoImp;
import daoImpl.CursoDaoImpl;
import entidades.Alumno;
import entidades.Curso;
import negocio.AlumnoNeg;
import negocio.CursoNeg;

public class AlumnoNegImpl implements AlumnoNeg{
	private AlumnoDao aluDao = new AlumnoDaoImp();
	public AlumnoNegImpl(){
		
	}
	
	public ArrayList<Alumno> listarAlumnos() {
		return (ArrayList<Alumno>) aluDao.readAll();
	}

	@Override
	public boolean actualizarAlumno(Alumno al) {
		// TODO Auto-generated method stub
		return false;
	}
}
