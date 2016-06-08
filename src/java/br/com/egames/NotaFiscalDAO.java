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
public class NotaFiscalDAO {
    //Método para inserção de dados
    public String inserir(NotaFiscal notafiscal){
        String sql = "insert into notafiscal ";
        sql += "values (?,?,?,?,?)";
        Connection con = Conexao.abrirConexao();
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setDouble(1, notafiscal.getPrecoTotal());
            pst.setString(2, notafiscal.getData());
            pst.setString(3, notafiscal.getIdNota());
            pst.setString(4, notafiscal.getIdPedido());
            pst.setInt   (5, notafiscal.getCpfCliente());
            
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
    public List<NotaFiscal> listarTodos(){
        String sql = "select * from notafiscal";
        Connection con = Conexao.abrirConexao();
        List<NotaFiscal> lista = new ArrayList<>();
        try{
           PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if(rs != null){
                while(rs.next()){
                    NotaFiscal c = new NotaFiscal();
                    
                    c.setPrecoTotal(rs.getDouble(1));
                    c.setData      (rs.getString(2));
                    c.setIdNota    (rs.getString(3));
                    c.setIdPedido  (rs.getString(4));
                    c.setCpfCliente(rs.getInt(5));
                    
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

