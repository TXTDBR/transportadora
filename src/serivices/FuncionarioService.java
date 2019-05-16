
package serivices;

import dao.DaoFactory;
import dao.FuncionarioDao;
import entities.Cliente;
import entities.Funcionario;
import java.util.List;

public class FuncionarioService {
    
    private final FuncionarioDao dao = DaoFactory.FuncionarioDaoJDBC();
    
    public void InserirOuAtualizar(Funcionario c){
        if(c.getId() == null){
           dao.inserir(c); 
        }else{
           dao.editar(c); 
        }
        
    }
    
    public Funcionario buscarPorId(String cpf){
        return dao.buscarPorId(cpf);
    }
    
    public void remover(Integer id){
        dao.remover(id);
    }  

    public List<Funcionario> listarPorNome(String nome){
        return dao.buscarPorNome(nome);
    }
}
