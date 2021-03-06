
package serivices;

import dao.ClienteDao;
import dao.DaoFactory;
import entities.Cliente;
import java.util.List;

public class ClienteService {
    
    private final ClienteDao dao = DaoFactory.ClienteDaoJDBC();
    
    public void InserirOuAtualizar(Cliente c){
        if(c.getId() == null){
           dao.inserir(c); 
        }else{
           dao.editar(c); 
        }
        
    }
    
    public Cliente buscarPorId(String cpf){
        return dao.buscarPorId(cpf);
    }
    
    public void remover(Integer id){
        dao.remover(id);
    }  

    public List<Cliente> listarPorNome(String nome){
        return dao.buscarPorNome(nome);
    }
}
