package dao;

import db.DB;
import db.DbException;
import entities.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDao {

    private Connection con = null;

    public UsuarioDao(Connection con) {
        this.con = con;
    }

    public Usuario logar(Usuario user) {
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "select * from usuario where usuario=? and senha=?";
        try {
            st = con.prepareStatement(sql);
            st.setString(1, user.getUsuario());
            st.setString(2, user.getSenha());
            rs = st.executeQuery();

            if (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome"));
                u.setUsuario(rs.getString("usuario"));
                u.setSenha(rs.getString("senha"));
                return u;
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }finally{
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
        return null;
    }
}
