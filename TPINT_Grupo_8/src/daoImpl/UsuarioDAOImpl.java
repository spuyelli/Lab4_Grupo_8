package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.UsuarioDAO;
import entidades.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO{
	
	private static final String insert = "INSERT INTO universidad.usuarios (dni, pass) VALUES (?, ?)";
	private static final String selectAdmin = "SELECT usuarios.*, admins.nombre, admins.apellido FROM universidad.usuarios inner join universidad.admins on usuarios.dni =  admins.dni where usuarios.dni = ? and usuarios.estado = true";
	private static final String selectDocente = "SELECT usuarios.*, docentes.nombre, docentes.apellido FROM universidad.usuarios inner join universidad.docentes on usuarios.dni =  docentes.dni where usuarios.dni = ? and usuarios.estado = true";
	private static final String update = "UPDATE `universidad`.`usuarios` SET `estado` = ? WHERE (`dni` = ?)";
	
	@Override
	public boolean insert(Usuario user) {
		
		Conexion conexionSql = null; 
		try {
			conexionSql = new Conexion();
			Connection connection  = Conexion.getConexion().getSQLConexion();
			
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setInt(1, user.getDni());
			statement.setString(2, user.getPassword());
			
			if(statement.executeUpdate()==1) {
				connection.commit();
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			conexionSql.cerrarConexion();
		}
		return false;
	}

	@Override
	public Usuario select(int DNI) {
		Connection conexion = Conexion.getConexion().getSQLConexion();
		ResultSet resultSet;
		try {
			PreparedStatement statement = conexion.prepareStatement(selectAdmin);
			statement.setInt(1, DNI);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				return getUsuario(resultSet);
			}
			statement = conexion.prepareStatement(selectDocente);
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
		String nombre = resultSet.getString("nombre");
		String apellido = resultSet.getString("apellido");
		return new Usuario(DNI, password, tipoUsuario, estado, nombre, apellido);
	}
	
}
