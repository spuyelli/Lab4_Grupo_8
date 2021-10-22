package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.TipoSeguroDao;
import entidades.TipoSeguro;

public class TipoSeguroDaoImpl implements TipoSeguroDao{

	private static final String readall = "SELECT * FROM tiposeguros";
	private static final String select = "SELECT * FROM tiposeguros WHERE idSeguro = ?";
	
	@Override
	public TipoSeguro select(int tipoSeguro) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		ResultSet resultSet;
		try {
			statement = conexion.prepareStatement(select);
			statement.setInt(1, tipoSeguro);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				return getTipoSeguro(resultSet);
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<TipoSeguro> readAll() {
		PreparedStatement statement;
		ResultSet resultSet;
		ArrayList<TipoSeguro> tiposSeguros = new ArrayList<TipoSeguro>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				tiposSeguros.add(getTipoSeguro(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tiposSeguros;
	}

	private TipoSeguro getTipoSeguro(ResultSet resultSet) throws SQLException {
		int idTipo = resultSet.getInt("idTipo");
		String descripcion = resultSet.getString("descripcion");
		return new TipoSeguro(idTipo, descripcion);
	}
	
}
