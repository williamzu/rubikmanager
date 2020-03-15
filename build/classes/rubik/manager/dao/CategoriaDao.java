/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rubik.manager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import rubik.manager.bancodedados.CriaConexao;
import rubik.manager.logica.Categoria;

/**
 *
 * @author Wz
 */
public class CategoriaDao {
    private Connection conexao;
        
    public CategoriaDao() throws SQLException{
        this.conexao = CriaConexao.getConexao();
    }
    
    public List<Categoria> getLista() throws SQLException{
        String sql = "select * from categoria";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        List<Categoria> minhaLista = new ArrayList<>();
        
        while(rs.next()){
            Categoria usuario = new Categoria();
            usuario.setCategoria(rs.getString("categoria"));                       
            minhaLista.add(usuario);
        }
        
        rs.close();
        stmt.close();
        return minhaLista;      

    }
    
}
