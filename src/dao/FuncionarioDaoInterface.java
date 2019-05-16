/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Cliente;
import entities.Funcionario;
import java.util.List;

/**
 *
 * @author 169121742018.2
 */
public interface FuncionarioDaoInterface {
    
   
    void inserir(Funcionario c);
    Funcionario buscarPorId(String cpf);
    List<Funcionario> buscarPorNome(String nome);
    void remover(Integer id);
    void editar(Funcionario c);
    Funcionario getNomePorId(Integer id);
    Funcionario getIdPorNome(String nome);
}
