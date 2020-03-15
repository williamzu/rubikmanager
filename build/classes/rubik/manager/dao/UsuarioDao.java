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
import rubik.manager.logica.Usuario;

/**
 *
 * @author Wz
 */
public class UsuarioDao {
    
    private Connection conexao;
    
    public UsuarioDao() throws SQLException{
        this.conexao = CriaConexao.getConexao();
    }
    
    public List<Usuario> getLista(String login) throws SQLException{
        String sql = "select * from usuario where login like ?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setString(1, login);
        ResultSet rs = stmt.executeQuery();
        
        List<Usuario> minhaLista = new ArrayList<>();
        
        while(rs.next()){
            Usuario usuario = new Usuario();
            usuario.setLogin(rs.getString("login"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setTipo(rs.getString("tipo"));
            usuario.setNome(rs.getString("nome"));
            usuario.setIdade(rs.getString("idade"));
            usuario.setTelefone(rs.getString("telefone"));
            usuario.setCidade(rs.getString("cidade"));
            usuario.setEmail(rs.getString("email"));
            usuario.setWca(rs.getString("wca"));
            usuario.setCubo(rs.getString("cubo"));
            usuario.setCategoriaFiscalizada(rs.getString("categoriafiscalizada"));            
            minhaLista.add(usuario);
        }
        
        rs.close();
        stmt.close();
        return minhaLista;        
        
    
    }
    
    public List<Usuario> getLista2(String login, String senha) throws SQLException{
            String sql = "select * from usuario where login= ? AND senha= ?";
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            stmt.setString(1, login);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();
        
            List<Usuario> minhaLista = new ArrayList<>();
        
        while(rs.next()){
            Usuario usuario = new Usuario();
            usuario.setLogin(rs.getString("login"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setTipo(rs.getString("tipo"));
            usuario.setIdade(rs.getString("idade"));
            usuario.setTelefone(rs.getString("telefone"));
            usuario.setCidade(rs.getString("cidade"));
            usuario.setEmail(rs.getString("email"));
            usuario.setWca(rs.getString("wca"));
            usuario.setCubo(rs.getString("cubo"));
            usuario.setCategoriaFiscalizada(rs.getString("categoriafiscalizada"));            
            minhaLista.add(usuario);
        }
        
        rs.close();
        stmt.close();
        return minhaLista; 
    }
    
    public void adiciona(Usuario contato) throws SQLException{
        //Prepara a conexão
        String sql = "insert into usuario (login, senha, nome,tipo, idade, telefone, cidade, email, wca, cubo,categoriafiscalizada)" + 
                "values (?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        //seta os valores
        stmt.setString(1, contato.getLogin());
        stmt.setString(2, contato.getSenha());
        stmt.setString(3, contato.getTipo());
        stmt.setString(4, contato.getNome());
        stmt.setString(5, contato.getIdade());
        stmt.setString(6, contato.getTelefone());
        stmt.setString(7, contato.getCidade());
        stmt.setString(8, contato.getEmail());
        stmt.setString(9, contato.getWca());
        stmt.setString(10, contato.getCubo());
        stmt.setString(11, contato.getCategoriaFiscalizada());
        
        
        //Executa o código sql
        stmt.execute();
        stmt.close();
    }
    
    public void altera(Usuario contato) throws SQLException{
        String sql = "update usuario set login=?, senha=?, nome=?, idade=?, telefone=?, cidade=?, email=?, wca=?, cubo=?,categoriafiscalizada=?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        //seta os valores
        stmt.setString(1, contato.getLogin());
        stmt.setString(2, contato.getSenha());
        stmt.setString(3, contato.getTipo());
        stmt.setString(4, contato.getNome());
        stmt.setString(5, contato.getIdade());
        stmt.setString(6, contato.getTelefone());
        stmt.setString(7, contato.getCidade());
        stmt.setString(8, contato.getEmail());
        stmt.setString(9, contato.getWca());
        stmt.setString(10, contato.getCubo());
        stmt.setString(11, contato.getCategoriaFiscalizada());
        
        //Executa o código sql
        stmt.execute();
        stmt.close();
    }
    
    public void remove(Usuario contato) throws SQLException{
        String sql = "delete from usuario where login=?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, contato.getLogin());
        stmt.execute();
        stmt.close();
        
        
    }

}
