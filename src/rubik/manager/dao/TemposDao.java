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
import rubik.manager.logica.Tempos;


/**
 *
 * @author Wz
 */
public class TemposDao {
    
    private Connection conexao;
    
    public TemposDao() throws SQLException{
        this.conexao = CriaConexao.getConexao();
    }
    
    public List<Tempos> getLista(String logins, String id) throws SQLException{
        String sql = "select * from " + logins + " where media like ?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setString(1, id);
        ResultSet rs = stmt.executeQuery();
        
        List<Tempos> minhaLista = new ArrayList<>();
        
        while(rs.next()){
            Tempos tempos = new Tempos();
            tempos.setId(Long.valueOf(rs.getString("id")));
            tempos.setCategoria(rs.getString("categoria"));
            tempos.setMelhorTempo(rs.getString("melhorTempo"));
            tempos.setPiorTempo(rs.getString("piorTempo"));
            tempos.setMedia(rs.getString("media"));
            tempos.setTempo1(rs.getString("tempo1"));
            tempos.setTempo2(rs.getString("tempo2"));
            tempos.setTempo3(rs.getString("tempo3"));
            tempos.setTempo4(rs.getString("tempo4"));
            tempos.setTempo5(rs.getString("tempo5"));

            minhaLista.add(tempos);
        }
        
        rs.close();
        stmt.close();
        return minhaLista;       
        
    }
    
    
    
    public void criaTabelaTempos(String login) throws SQLException{
        //Prepara a conexão
        String sql = "CREATE TABLE " + login + "(id INT(2) NOT NULL AUTO_INCREMENT,"
                + "categoria VARCHAR(15), melhorTempo VARCHAR(10), piorTempo VARCHAR(10),"
                + " media VARCHAR(10), tempo1 VARCHAR(10), tempo2 VARCHAR(10),tempo3 VARCHAR(10),"
                + " tempo4 VARCHAR(10), tempo5 VARCHAR(10), PRIMARY KEY(id))";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
                        
        //Executa o código sql
        stmt.execute();
        stmt.close();
    }
    
    public void insereTempos(String login, Tempos contato) throws SQLException{
        //Prepara a conexão
        String sql = "insert into " + login + "(categoria, melhorTempo, piorTempo, "
                + "media, tempo1, tempo2,tempo3, tempo4, tempo5) values "
                + "(?,?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);

        stmt.setString(1, contato.getCategoria());
        stmt.setString(2, contato.getMelhorTempo());
        stmt.setString(3, contato.getPiorTempo());
        stmt.setString(4, contato.getMedia());
        stmt.setString(5, contato.getTempo1());
        stmt.setString(6, contato.getTempo2());
        stmt.setString(7, contato.getTempo3());
        stmt.setString(8, contato.getTempo4());
        stmt.setString(9, contato.getTempo5());

                        
        //Executa o código sql
        stmt.execute();
        stmt.close();
    }
    
}
