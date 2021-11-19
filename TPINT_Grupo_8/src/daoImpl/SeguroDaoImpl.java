package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.SeguroDao;

public class SeguroDaoImpl implements SeguroDao {
/*
	private static final String insert = "INSERT INTO seguros (idSeguro, descripcion, idTipo, costoContratacion, costoAsegurado) VALUES(?, ?, ?, ?, ?)";
	private static final String readall = "SELECT * FROM seguros inner join tiposeguros on seguros.idTipo = tiposeguros.idTipo";
	private static final String readallTipoEspecifico = "SELECT seguros.idSeguro, seguros.descripcion, tiposeguros.idTipo, seguros.costoContratacion, "
			+ "seguros.costoAsegurado FROM seguros inner join tiposeguros on seguros.idTipo = tiposeguros.idTipo WHERE seguros.idTipo = ?";
	private static final String select = "SELECT * FROM seguros WHERE idSeguro = ?";
	private static final String lastID = "SELECT max(idSeguro) as \"idSeguro\" FROM seguros";

	public boolean insert(Seguro seguro) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try {
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, seguro.getIdSeguro());
			statement.setString(2, seguro.getDescripcion());
			statement.setInt(3, seguro.getTipoSeguro());
			statement.setFloat(4, seguro.getCostoContratacion());
			statement.setFloat(5, seguro.getCostoMaximoAsegurado());
			if (statement.executeUpdate() > 0) {
				conexion.commit();
				isInsertExitoso = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isInsertExitoso;
	}

	public List<Seguro> readAll() {
		PreparedStatement statement;
		ResultSet resultSet;
		ArrayList<Seguro> seguros = new ArrayList<Seguro>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				seguros.add(getSeguro(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return seguros;
	}

	public List<Seguro> readAllTipoEspecifico(int idTipo) {
		PreparedStatement statement;
		ResultSet resultSet;
		ArrayList<Seguro> seguros = new ArrayList<Seguro>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readallTipoEspecifico);
			statement.setInt(1, idTipo);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				seguros.add(getSeguro(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return seguros;
	}

	public Seguro select(String idSeguro) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		ResultSet resultSet;
		try {
			statement = conexion.prepareStatement(select);
			statement.setString(1, idSeguro);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				return getSeguro(resultSet);
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Seguro getSeguro(ResultSet resultSet) throws SQLException {
		int idSeguro = resultSet.getInt("idSeguro");
		String descripcion = resultSet.getString("descripcion");
		int tipoSeguro = resultSet.getInt("idTipo");
		float costoContratacion = resultSet.getFloat("costoContratacion");
		float costoMaximoAsegurado = resultSet.getFloat("costoAsegurado");
		return new Seguro(idSeguro, descripcion, tipoSeguro, costoContratacion, costoMaximoAsegurado);
	}

	@Override
	public int getLastID() {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		ResultSet resultSet;
		try {
			statement = conexion.prepareStatement(lastID);
			resultSet = statement.executeQuery();
			resultSet.next();
			return resultSet.getInt("idSeguro");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
*/
}
