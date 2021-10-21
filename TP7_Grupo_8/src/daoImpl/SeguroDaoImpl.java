package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.SeguroDao;
import entidades.Seguro;

public class SeguroDaoImpl implements SeguroDao {

	private static final String insert = "INSERT INTO Seguros(IdSeguro, Descripcion, tipoSeguro, CostoContratacion, CostoMaximoAsegurado) VALUES(?, ?, ?, ?, ?)";
	private static final String delete = "DELETE FROM Seguros WHERE IdSeguro = ?";
	private static final String readall = "SELECT * FROM Seguros";
	private static final String select = "SELECT * FROM Seguros WHERE Dni = ?";
	private static final String update = "UPDATE Seguros SET Descripcion = ?, tipoSeguro = ?, CostoContratacion = ?, CostoMaximoAsegurado = ? WHERE (IdSeguro = ?)";

	public boolean insert(Seguro seguro) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try {
			statement = conexion.prepareStatement(insert);
			
			///Hasta aca hice habría que continuar desarrollando
			statement.setString(1, seguro.getIdSeguro());
			statement.setString(2, persona.getApellido());
			statement.setString(3, persona.getNombre());
			if (statement.executeUpdate() > 0) {
				conexion.commit();
				isInsertExitoso = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isInsertExitoso;
	}

	public boolean delete(Persona persona_a_eliminar) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isUpdateExitoso = false;
		try {
			statement = conexion.prepareStatement(delete);
			statement.setString(1, persona_a_eliminar.getDni());
			if (statement.executeUpdate() > 0) {
				conexion.commit();
				isUpdateExitoso = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isUpdateExitoso;
	}

	public List<Persona> readAll() {
		PreparedStatement statement;
		ResultSet resultSet;
		ArrayList<Persona> personas = new ArrayList<Persona>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				personas.add(getPersona(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return personas;
	}

	public Persona select(String dni) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		ResultSet resultSet;
		try {
			statement = conexion.prepareStatement(select);
			statement.setString(1, dni);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				return getPersona(resultSet);
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean update(Persona persona) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isUpdateExitoso = false;
		try {
			statement = conexion.prepareStatement(update);
			statement.setString(1, persona.getNombre());
			statement.setString(2, persona.getApellido());
			statement.setString(3, persona.getDni());
			if (statement.executeUpdate() > 0) {
				conexion.commit();
				isUpdateExitoso = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isUpdateExitoso;
	}

	private Persona getPersona(ResultSet resultSet) throws SQLException {
		String dni = resultSet.getString("Dni");
		String nombre = resultSet.getString("Nombre");
		String tel = resultSet.getString("Apellido");
		return new Persona(dni, nombre, tel);
	}
}
