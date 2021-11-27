package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.UsuarioDAO;
import entidades.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO{
	
	private static final String insert = "INSERT INTO `universidad`.`usuarios` (`dni`, `tipoUsuario`, `pass`, `estado`) VALUES (?, ?, ?, ?)";
	private static final String select = "SELECT * FROM usuarios WHERE dni = ?";
	private static final String update = "UPDATE `universidad`.`usuarios` SET `estado` = ? WHERE (`dni` = ?)";

	@Override
	public boolean insert(Usuario user) {
		boolean isInsertExitoso = false;
		try {
			PreparedStatement statement;
			Connection conexion = Conexion.getConexion().getSQLConexion();
		
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, user.getDni());
			statement.setInt(2, user.getTipoUsuario());
			statement.setString(3, user.getPassword());
			statement.setBoolean(4, user.isEstado());
			if (statement.executeUpdate() > 0) {
				conexion.commit();
				isInsertExitoso = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isInsertExitoso;
	}

	@Override
	public Usuario select(int DNI) {
		Connection conexion = Conexion.getConexion().getSQLConexion();
		ResultSet resultSet;
		try {
			PreparedStatement statement = conexion.prepareStatement(select);
			statement.setInt(1, DNI);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				return getUsuario(resultSet);
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean update(int DNI, boolean estado) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isUpdateExitoso = false;
		try {
			statement = conexion.prepareStatement(update);
			statement.setInt(1, DNI);
			statement.setBoolean(2, estado);
			if (statement.executeUpdate() > 0) {
				conexion.commit();
				isUpdateExitoso = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isUpdateExitoso;
	}

	private Usuario getUsuario(ResultSet resultSet) throws SQLException {
		int DNI = resultSet.getInt("dni");
		int tipoUsuario = resultSet.getInt("tipoUsuario");
		String password = resultSet.getString("pass");
		boolean estado = resultSet.getBoolean("estado");
		return new Usuario(DNI, password, tipoUsuario, estado);
	}
	
}
