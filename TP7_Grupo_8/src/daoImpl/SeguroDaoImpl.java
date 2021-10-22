package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.SeguroDao;
import entidades.Seguro;
import entidades.TipoSeguro;

public class SeguroDaoImpl implements SeguroDao {

	private static final String insert = "INSERT INTO seguros (idSeguro, descripcion, idTipo, costoContratacion, costoAsegurado) VALUES(?, ?, ?, ?, ?)";
	private static final String delete = "DELETE FROM seguros WHERE idSeguro = ?";
	private static final String readall = "SELECT * FROM seguros inner join tiposeguros on seguros.idTipo = tiposeguros.idTipo";
	private static final String select = "SELECT * FROM seguros WHERE idSeguro = ?";
	private static final String update = "UPDATE seguros SET Descripcion = ?, tipoSeguro = ?, CostoContratacion = ?, CostoMaximoAsegurado = ? WHERE (IdSeguro = ?)";

	public boolean insert(Seguro seguro) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try {
			statement = conexion.prepareStatement(insert);
			
			///Hasta aca hice habría que continuar desarrollando
			statement.setInt(1, seguro.getIdSeguro());
			statement.setString(2, seguro.getDescripcion());
			statement.setInt(3, seguro.getTipoSeguro().getId());
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

	public boolean delete(Seguro seguro) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isDeleteExitoso = false;
		try {
			statement = conexion.prepareStatement(delete);
			statement.setInt(1, seguro.getIdSeguro());
			if (statement.executeUpdate() > 0) {
				conexion.commit();
				isDeleteExitoso = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isDeleteExitoso;
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

	public boolean update(Seguro seguro) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isUpdateExitoso = false;
		try {
			statement = conexion.prepareStatement(update);
			statement.setInt(1, seguro.getIdSeguro());
			statement.setString(2, seguro.getDescripcion());
			statement.setInt(3, seguro.getTipoSeguro().getId());
			statement.setFloat(4, seguro.getCostoContratacion());
			statement.setFloat(5, seguro.getCostoMaximoAsegurado());
			if (statement.executeUpdate() > 0) {
				conexion.commit();
				isUpdateExitoso = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isUpdateExitoso;
	}

	private Seguro getSeguro(ResultSet resultSet) throws SQLException {
		int idSeguro = resultSet.getInt("idSeguro");
		String descripcion = resultSet.getString("descripcion");
		TipoSeguro tipoSeguro = getTipoSeguro(resultSet);
		float costoContratacion = resultSet.getFloat("costoContratacion");
		float costoMaximoAsegurado = resultSet.getFloat("costoAsegurado");
		return new Seguro(idSeguro, descripcion, tipoSeguro, costoContratacion, costoMaximoAsegurado);
	}
	
	private TipoSeguro getTipoSeguro(ResultSet resultSet) {
		TipoSeguroDaoImpl tsdaoi = new TipoSeguroDaoImpl();
		try {
			tsdaoi.select(resultSet.getInt("idTipo"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
