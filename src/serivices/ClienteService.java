
package serivices;

import dao.ClienteDao;
import dao.DaoFactory;
import entities.Cliente;

public class ClienteService {
    
    private ClienteDao dao = DaoFactory.ClienteDaoJDBC();
    
    public void Inserir(Cliente c){
        dao.inserir(c);
    }
}
