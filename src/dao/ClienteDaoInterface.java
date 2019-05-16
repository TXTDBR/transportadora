/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Cliente;
import java.util.List;

/**
 *
 * @author 169121742018.2
 */
public interface ClienteDaoInterface {
    
   
    void inserir(Cliente c);
    List<Cliente> buscar();
    Cliente buscarPorId(String cpf);
    void remover(Integer id);
    void editar(Cliente c);
}
