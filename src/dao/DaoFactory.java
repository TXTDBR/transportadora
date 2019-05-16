
package dao;

import db.DB;

public class DaoFactory {
   
    public static ClienteDao ClienteDaoJDBC(){
        return new ClienteDao(DB.getConnection());
    }
    
    public static FuncionarioDao FuncionarioDaoJDBC(){
        return new FuncionarioDao(DB.getConnection());
    }
    
}
