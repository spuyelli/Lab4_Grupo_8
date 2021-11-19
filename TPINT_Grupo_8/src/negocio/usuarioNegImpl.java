package negocio;

import dao.UsuarioDAO;
import daoImpl.UsuarioDAOImpl;
import entidades.Usuario;

public class usuarioNegImpl implements usuarioNeg{
	
	public UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

	public usuarioNegImpl(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	
	public usuarioNegImpl() {
	}

	@Override
	public boolean insert(Usuario user) {
		return usuarioDAO.insert(user);
	}

	@Override
	public Usuario select(int DNI) {
		return usuarioDAO.select(DNI);
	}

	@Override
	public boolean update(int DNI, boolean estado) {
		return usuarioDAO.update(DNI, estado);
	}
	
	

}
