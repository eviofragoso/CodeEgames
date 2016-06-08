/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.egames;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Leandro
 */
public class ItensPedidoDAO {
    //Método para inserção de dados
    public String inserir(ItensPedido itenspedido){
        String sql = "insert into itenspedido ";
        sql += "values (?,?,?)";
        Connection con = Conexao.abrirConexao();
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt(1, itenspedido.getQtdeProdutoPedido());
            pst.setString(2, itenspedido.getIdPedido());
            pst.setInt(3, itenspedido.getIdProduto());
            
            if(pst.executeUpdate() > 0){
                Conexao.fecharConexao(con);
                return "Registro inserido com sucesso.";
            }else{
                Conexao.fecharConexao(con);
                return "Erro ao inserir registro.";
            }
        }catch(SQLException e){
            Conexao.fecharConexao(con);
            return e.getMessage();
        }        
    }
    
    //Método para excluir dados
    public String excluir(ItensPedido itenspedido){
        String sql = "delete from itenspedido ";
        sql += "where idpedido=?";
        Connection con = Conexao.abrirConexao();
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setString(1, itenspedido.getIdPedido());
            
            if(pst.executeUpdate() > 0){
                Conexao.fecharConexao(con);
                return "Registro excluído com sucesso.";
            }else{
                Conexao.fecharConexao(con);
                return "Erro ao excluir registro.";
            }
        }catch(SQLException e){
            Conexao.fecharConexao(con);
            return e.getMessage();
        }
    }
    
    //Método para listar todos os cargos
    public List<ItensPedido> listarTodos(){
        String sql = "select * from itenspedido";
        Connection con = Conexao.abrirConexao();
        List<ItensPedido> lista = new ArrayList<>();
        try{
           PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if(rs != null){
                while(rs.next()){
                    ItensPedido c = new ItensPedido();
                    c.setIdPedido(rs.getString(1));
                    c.setIdProduto(rs.getInt(2));
                    c.setQtdeProdutoPedido(rs.getInt(3));
                    
                    lista.add(c);
                }
                Conexao.fecharConexao(con);
                return lista;
            }else{
                Conexao.fecharConexao(con);
                return null;
            }
        }catch(SQLException e){
            Conexao.fecharConexao(con);
            return null;
        }
    }
    
}

