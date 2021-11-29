package negocioImpl;

import java.util.List;
import dao.CalificacionDAO;
import daoImpl.CalificacionDAOImpl;
import entidades.Calificacion;
import negocio.CalificacionNeg;

public class CalificacionNegImpl implements CalificacionNeg{

	public CalificacionDAO cDAO = new CalificacionDAOImpl();
	
	@Override
	public boolean update(Calificacion cal) {
		return cDAO.update(cal);
	}

	@Override
	public List<Calificacion> readAll(int curso) {
		return cDAO.readAll(curso);
	}
	
}
