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

	private static final String readall = "SELECT * FROM universidad.alumnosxcursos where idCurso = ?";

	@Override
	public boolean update(Calificacion cal) {
		PreparedStatement statement;
		ResultSet resultSet;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		try {
			statement = conexion.prepareStatement("update universidad.alumnosxcursos set parcial_1 ='"
					+ cal.getParcial1() + " ' , parcial_2 = '" + cal.getParcial2() + "' , recuperatorio_1 = '"
					+ cal.getRecuperatorio1() + "', recuperatorio_2 ='" + cal.getRecuperatorio2()
					+ "',estadoAprobacion='" + cal.isestadoAprobacion() + " where dniAlumno = '" + cal.getDniAlumno()
					+ "' and " + "idCurso = '" + cal.getIdCurso() + "'");
			resultSet = statement.executeQuery();
			if (resultSet != null) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Calificacion> readAll(int curso) {
		List<Calificacion> listaCalificaciones = new ArrayList<Calificacion>();

		PreparedStatement statement;
		ResultSet resultSet;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			statement.setInt(1, curso);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				listaCalificaciones.add(getCalificacion(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaCalificaciones;
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
