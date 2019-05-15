/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Cliente;

/**
 *
 * @author 169121742018.2
 */
public interface ClienteDaoInterface {
    
    void inserir(Cliente c);
    void buscar(Cliente c);
    void buscarPorId(Integer id);
    void remover(Integer id);
    void editar(Cliente c);
}
