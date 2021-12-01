package negocioImpl;

import java.util.List;
import dao.CalificacionDAO;
import daoImpl.CalificacionDAOImpl;
import entidades.Calificacion;
import negocio.CalificacionNeg;

public class CalificacionNegImpl implements CalificacionNeg{

	public CalificacionDAO cDAO = new CalificacionDAOImpl();
	
	@Override
	public boolean update(Calificacion cal, int test) {
		return cDAO.update(cal, test);
	}

	@Override
	public List<Calificacion> readAll(int curso) {
		return cDAO.readAll(curso);
	}

	@Override
	public Calificacion readAll_Alumno(int curso, int dni) {
		return cDAO.readAll_Alumno(curso, dni);
	}
	
}
