
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
public class FazPedidoDAO {
    //Método para inserção de dados
    public String inserir(FazPedido fazpedido){
        String sql = "insert into fazpedido ";
        sql += "values (?,?,?)";
        Connection con = Conexao.abrirConexao();
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt   (1, fazpedido.getCpfCliente());
            pst.setString(2, fazpedido.getIdPedido());
            pst.setString(3, fazpedido.getData());
            
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
    
    //Método para listar todos os cargos
    public List<FazPedido> listarTodos(){
        String sql = "select * from fazpedido";
        Connection con = Conexao.abrirConexao();
        List<FazPedido> lista = new ArrayList<>();
        try{
           PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if(rs != null){
                while(rs.next()){
                    FazPedido c = new FazPedido();
                    c.setCpfCliente(rs.getInt(1));
                    c.setIdPedido  (rs.getString(2));
                    c.setData      (rs.getString(3));
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

