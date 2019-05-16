/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.DbException;
import entities.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 169121742018.2
 */
public class ClienteDao implements ClienteDaoInterface {

    private Connection con = null;
    

    public ClienteDao(Connection con) {
       
        this.con = con;
        
    }

    @Override
    public void inserir(Cliente c) {
        PreparedStatement st = null;
        String sql = "Insert into cliente (nome, cpf, telefone, email) values (?,?,?,?)";

        try {
            st = con.prepareStatement(sql);
            st.setString(1, c.getNome());
            st.setString(2, c.getCpf());
            st.setString(3, c.getTelefone());
            st.setString(4, c.getEmail());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public List<Cliente> buscar() {
        String sql = "select * from cliente";
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            List<Cliente> list = new ArrayList<>();
            
            while(rs.next()){
                Cliente c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setTelefone(rs.getString("telefone"));
                c.setEmail(rs.getString("email"));
                 list.add(c);
            }
            return list;
        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public Cliente buscarPorId(String cpf) {
        String sql = "select * from cliente where id = ?";
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = con.prepareStatement(sql);
            st.setString(1, cpf);
            rs = st.executeQuery();
            if(rs.next()){
                Cliente c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setTelefone(rs.getString("telefone"));
                c.setEmail(rs.getString("email"));
                return c;
            }else{
                return null;
            }
        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public void remover(Integer id) {
        String sql = "delete from cliente where id = ?";
        PreparedStatement st = null;
        try{
            st = con.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
           
        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public void editar(Cliente c) {
        String sql = "update set cliente nome=?, cpf=?, telefone=?, email=? where id=?";
         PreparedStatement st = null;
        try {
            st = con.prepareStatement(sql);
            st.setString(1, c.getNome());
            st.setString(2, c.getCpf());
            st.setString(3, c.getTelefone());
            st.setString(4, c.getEmail());
            st.setInt(5, c.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

}
