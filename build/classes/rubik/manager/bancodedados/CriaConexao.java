/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rubik.manager.bancodedados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Wz
 */
public class CriaConexao {
    public static Connection getConexao() throws SQLException {
    try {
        Class.forName("com.mysql.jdbc.Driver");
        System.err.println("Conectando ao banco");
        return DriverManager.getConnection("jdbc:mysql://localhost/rubikmanager", "root", "prog3");
    }   catch (ClassNotFoundException e){
            throw new SQLException(e.getMessage());
        }
    }
}
