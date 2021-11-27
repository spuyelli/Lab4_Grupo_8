package negocioImpl;

import dao.UsuarioDAO;
import daoImpl.UsuarioDAOImpl;
import entidades.Usuario;
import negocio.usuarioNeg;

public class usuarioNegImpl implements usuarioNeg{
	
	public UsuarioDAO uDAO = new UsuarioDAOImpl();

	public usuarioNegImpl(UsuarioDAO uDAO) {
		this.uDAO = uDAO;
	}
	
	public usuarioNegImpl() {
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
