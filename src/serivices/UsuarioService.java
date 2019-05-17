
package serivices;

import dao.DaoFactory;
import dao.UsuarioDao;
import entities.Usuario;

public class UsuarioService {
    
    private UsuarioDao dao = DaoFactory.UsuarioDaoJDBC();
    
    public Usuario logar(Usuario user){
        return dao.logar(user);
    }    
}
