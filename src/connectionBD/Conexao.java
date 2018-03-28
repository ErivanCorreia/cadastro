/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectionBD;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jaiane
 */
public class Conexao {

    // public Statement stmt;// responsável por fazer as pesquisas em um bd;
    //public ResultSet rs;// responsável por armazenar o resultado de uma pesquisa;
    // private Connection conn;
    private static String driver = "org.postgresql.Driver";
    private static String caminho = "jdbc:postgresql://localhost:5432/projetoCrud";
    private static String usuario = "postgres";
    private static String senha = "postgres";

    public static Connection conexaoBD() throws ClassNotFoundException {

        try {
            // System.setProperty("jdbc.Drivers", driver); testei sem isso e funfou
            Class.forName(driver);
            return DriverManager.getConnection(caminho, usuario, senha);
            // JOptionPane.showMessageDialog(null, "conectado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO:\n" + ex.getMessage());
        }
        return null;

    }

    public static void desconectaBD(Connection conn) {
        try {
            conn.close();
            //JOptionPane.showMessageDialog(null, "desconectado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro close:\n" + ex.getMessage());
        }
    }

    /* public static void executaSql(String sql) {
        Connection con = null;
        ResultSet rs = null;
        Statement stmt = null;
        try {
            stmt = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO NO MÉTODO EXECUTA SQL:\n" + ex.getMessage());
        }
    }*/
}
