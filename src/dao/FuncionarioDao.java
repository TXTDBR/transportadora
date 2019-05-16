 
package dao;
 
import db.DB;
import db.DbException;
import entities.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDao implements FuncionarioDaoInterface{

    private Connection con = null;
    public FuncionarioDao(Connection con){
        this.con = con;
    }
    @Override
    public void inserir(Funcionario c) {
        PreparedStatement st = null;
        String sql = "Insert into funcionario (nome, cpf, telefone, email) values (?,?,?,?)";

        try {
            st = con.prepareStatement(sql);
            st.setString(1, c.getNome());
            st.setString(2, c.getCpf());
            st.setString(3, c.getTelefone());
            st.setString(4, c.getEmail());
            //st.setInt(5, c.getDepartamentoId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public Funcionario buscarPorId(String cpf) {
         String sql = "select * from funcionario where cpf = ?";
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = con.prepareStatement(sql);
            st.setString(1, cpf);
            rs = st.executeQuery();
            if (rs.next()) {
                Funcionario c = new Funcionario();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setTelefone(rs.getString("telefone"));
                c.setEmail(rs.getString("email"));
               // c.setDepartamento(rs.getInt("departamentoId"));
                return c;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Funcionario> buscarPorNome(String nome) {
        String sql = "select * from funcionario where nome like ?";
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = con.prepareStatement(sql);
            st.setString(1, nome + "%");
            rs = st.executeQuery();
            List<Funcionario> list = new ArrayList<>();

            while (rs.next()) {
                Funcionario c = new Funcionario();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setTelefone(rs.getString("telefone"));
                c.setEmail(rs.getString("email"));
               // c.setDepartamento(rs.getInt("departamentoId"));
                list.add(c);
            }
            return list;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void remover(Integer id) {
        String sql = "delete from funcionario where id = ?";
        PreparedStatement st = null;
        try {
            st = con.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void editar(Funcionario c) {
        String sql = "update funcionario set nome=?, cpf=?, telefone=?, email=? where id=?";
        PreparedStatement st = null;
        try {
            st = con.prepareStatement(sql);
            st.setString(1, c.getNome());
            st.setString(2, c.getCpf());
            st.setString(3, c.getTelefone());
            st.setString(4, c.getEmail());
            //st.setInt(5, c.getDepartamentoId());
            st.setInt(5, c.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public Funcionario getNomePorId(Integer id) {
    return null;
    }

    @Override
    public Funcionario getIdPorNome(String nome) {
        return null;
    }
    
    
    
}
