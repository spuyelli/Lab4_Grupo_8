package negocioImpl;

import java.util.ArrayList;


import dao.AlumnoDao;
import dao.CursoDao;
import daoImpl.AlumnoDaoImpl;
import daoImpl.Conexion;
import daoImpl.CursoDaoImpl;
import entidades.Alumno;
import entidades.Curso;
import negocio.AlumnoNeg;
import negocio.CursoNeg;

public class AlumnoNegImpl implements AlumnoNeg{
	private AlumnoDao aluDao = new AlumnoDaoImpl();
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

	@Override
	public boolean agregarAlumno(Alumno alumno) {
		//if(validarDNILegajoAlum(alumno)) return -1;
		//DaoAlumno daoalumno = new DaoAlumno();
		//boolean estado = AlumnoDaoImpl //.agregarAlumno(alumno)? true : false;
		AlumnoDao alumnoDao = new AlumnoDaoImpl();
		boolean estado = alumnoDao.agregarAlumno(alumno)? true : false;
		return estado;
	}
	
	public boolean agregarAlumnoACurso(Alumno alumno, Curso curso) {

		AlumnoDao alumnoDao = new AlumnoDaoImpl();
		boolean estado = alumnoDao.agregarAlumnoACurso(alumno, curso)? true : false;
		return false;
	}
	


}
