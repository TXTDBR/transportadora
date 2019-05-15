/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.DB;
import db.DbException;
import entities.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author 169121742018.2
 */
public class ClienteDao implements ClienteDaoInterface{

    private Connection con = null;
    
    public ClienteDao(Connection con){
        this.con = con;
    }
    
    @Override
    public void inserir(Cliente c) {
        PreparedStatement st = null;
        String sql = "Insert into cliente (nome, cpf, telefone, email) values (?,?,?,?)";
        
        try{
            con = DB.getConnection();
            st = con.prepareStatement(sql);
            st.setString(1, c.getNome());
            st.setString(2, c.getCpf());
            st.setString(3, c.getTelefone());
            st.setString(4, c.getEmail());
            st.executeUpdate();
        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public void buscar(Cliente c) {

    }

    @Override
    public void buscarPorId(Integer id) {

    }

    @Override
    public void remover(Integer id) {

    }

    @Override
    public void editar(Cliente c) {
 
    }
    
}
