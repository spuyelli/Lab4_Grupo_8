package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.CalificacionDAO;
import entidades.Calificacion;

public class CalificacionDAOImpl implements CalificacionDAO {

	private static final String readAll = "SELECT * FROM universidad.alumnosxcursos where idCurso = ?";
	private static final String readAll_Alumno = "SELECT * FROM universidad.alumnosxcursos where idCurso = ? and dniAlumno = ?";

	@Override
	public boolean update(Calificacion cal, int test) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		String update = "update universidad.alumnosxcursos set ";
		try {
			switch (test) {
			case 1:
				update += "parcial_1 = '" + cal.getParcial1() + "'";
				break;
			case 2:
				update += "parcial_2 = '" + cal.getParcial2() + "'";
				break;
			case 3:
				update += "recuperatorio_1 = '" + cal.getRecuperatorio1() + "'";
				break;
			case 4:
				update += "recuperatorio_2 = '" + cal.getRecuperatorio2() + "'";
				break;
			default:
				break;
			}
			
			if (cal.getParcial1() > 6 && cal.getParcial2() > 6) {
				update += ", estadoAprobacion='1'";
			} else if ((cal.getParcial1() < 6) && (cal.getRecuperatorio1() > 6) && (cal.getParcial2() > 6)) {
				update += ", estadoAprobacion='1'";
			} else if (cal.getParcial1() > 6 && cal.getParcial2() < 6 && cal.getRecuperatorio2() > 6) {
				update += ", estadoAprobacion='1'";
			} else if (cal.getRecuperatorio1() > 6 && cal.getRecuperatorio2() > 6) {
				update += ", estadoAprobacion='1'";
			} else {
				update += ", estadoAprobacion='0'";
			}
			
			update += " where (dniAlumno = '" + cal.getDniAlumno() + "') and (idCurso = '" + cal.getIdCurso() + "')";
			statement = conexion.prepareStatement(update);
			statement.executeUpdate();
			conexion.commit();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Calificacion> readAll(int curso) {
		ArrayList<Calificacion> listaCalificaciones = new ArrayList<Calificacion>();

		PreparedStatement statement;
		ResultSet resultSet;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readAll);
			statement.setInt(1, curso);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				listaCalificaciones.add(getCalificacion(resultSet));
			}
			return listaCalificaciones;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Calificacion readAll_Alumno(int curso, int dni) {
		PreparedStatement statement;
		ResultSet resultSet;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readAll_Alumno);
			statement.setInt(1, curso);
			statement.setInt(2, dni);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				return getCalificacion(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Calificacion getCalificacion(ResultSet resultSet) throws SQLException {

		int dniAlumno = resultSet.getInt("dniAlumno");
		int idCurso = resultSet.getInt("idCurso");
		int parcial1 = resultSet.getInt("parcial_1");
		int parcial2 = resultSet.getInt("parcial_2");
		int recuperatorio1 = resultSet.getInt("recuperatorio_1");
		int recuperatorio2 = resultSet.getInt("recuperatorio_2");
		boolean estadoAprobacion = resultSet.getBoolean("estadoAprobacion");

		return new Calificacion(dniAlumno, idCurso, parcial1, parcial2, recuperatorio1, recuperatorio2,
				estadoAprobacion);

	}

}
