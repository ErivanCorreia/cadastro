/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connectionBD.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modeloBeans.Cliente;

/**
 *
 * @author jaiane
 */
public class ClienteDao {

    public ClienteDao() {

    }

    public void cadastrarCliente(Cliente x) throws ClassNotFoundException {
        Connection con = Conexao.conexaoBD();

        try {

            PreparedStatement pst = con.prepareStatement("INSERT INTO cliente(nome,cpf,telefone)VALUES(?,?,?) ");
            pst.setString(1, x.getNome());
            pst.setString(2, x.getCpf());
            pst.setString(3, x.getTelefone());
            pst.execute();
            
            pst = con.prepareStatement("SELECT * FROM cliente");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                x.setId(rs.getInt("id"));
                x.setNome(rs.getString("nome"));
                x.setCpf(rs.getString("cpf"));
                x.setTelefone(rs.getString("telefone"));
            }
            
            JOptionPane.showMessageDialog(null, "SALVO COM SUCESSO\n ID DO CLIENTE:" +x.getId());
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro: " + ex.getMessage());
        }

        Conexao.desconectaBD(con);
    }
    
    public void pesquisaCliente(Cliente x) throws ClassNotFoundException{
        Connection con = Conexao.conexaoBD();
        
        ResultSet rs = null;
        try {
            
            Statement stmt = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.TYPE_FORWARD_ONLY);
            rs = stmt.executeQuery("SELECT * FROM cliente WHERE id = "+x.getIdPesquisa()+"");
            
            while(rs.next()){
               
                x.setId(rs.getInt("id"));
                x.setNome(rs.getString("nome"));
                x.setCpf(rs.getString("cpf"));
                x.setTelefone(rs.getString("telefone"));
                
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro ao pesquisar: "+ex.getMessage());
        }
        
        Conexao.desconectaBD(con);
    }

    public void editar(Cliente x) throws ClassNotFoundException{
        Connection con = Conexao.conexaoBD();
        
        try {
            PreparedStatement pst = con.prepareStatement("UPDATE cliente SET nome=?, cpf=?, telefone=? WHERE id = ?");

            pst.setString(1, x.getNome());
            pst.setString(2, x.getCpf());
            pst.setString(3, x.getTelefone());
            pst.setInt(4, x.getId());
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro editar: "+ex.getMessage());
        }
        
        Conexao.desconectaBD(con);
    }

    public void excluir(Cliente x) throws ClassNotFoundException{
        Connection con = Conexao.conexaoBD();
        
        try {
            PreparedStatement pst = con.prepareStatement("DELETE FROM cliente WHERE id=?");
            pst.setInt(1, x.getId());
            pst.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Conexao.desconectaBD(con);
    }
        
}
