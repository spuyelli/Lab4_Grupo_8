package negocioImpl;

import dao.UsuarioDAO;
import daoImpl.UsuarioDAOImpl;
import entidades.Usuario;
import negocio.UsuarioNeg;

public class UsuarioNegImpl implements UsuarioNeg{
	
	public UsuarioDAO uDAO = new UsuarioDAOImpl();

	public UsuarioNegImpl(UsuarioDAO uDAO) {
		this.uDAO = uDAO;
	}
	
	public UsuarioNegImpl() {
	}

	@Override
	public boolean insert(Usuario user) {
		return uDAO.insert(user);
	}

	@Override
	public Usuario select(int DNI) {
		return uDAO.select(DNI);
	}

	@Override
	public boolean update(int DNI, boolean estado) {
		return uDAO.update(DNI, estado);
	}

}
