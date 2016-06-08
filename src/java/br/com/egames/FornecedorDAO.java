//PRONTO

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
public class FornecedorDAO {
    //Método para inserção de dados
    public String inserir(Fornecedor fornecedor){
        String sql = "insert into fornecedor ";
        sql += "values (?,?,?,?,?)";
        Connection con = Conexao.abrirConexao();
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setString(1, fornecedor.getCnpjForn());
            pst.setString(2, fornecedor.getNomeForn());
            pst.setString(3, fornecedor.getEnderecoForn());
            pst.setString(4, fornecedor.getCepForn());
            pst.setString(5, fornecedor.getIdTelefone());
            
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
    
    //Método para alteração de dados
    public String alterar(Fornecedor fornecedor){
        String sql = "update fornecedor set ";
        sql += "nomeforn=?, enderecoforn=?, cepforn=?, idtelefone=?";
        sql += " where cnpjforn=?";
        Connection con = Conexao.abrirConexao();
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setString(1, fornecedor.getNomeForn());
            pst.setString(2, fornecedor.getEnderecoForn());
            pst.setString(3, fornecedor.getCepForn());
            pst.setString(4, fornecedor.getIdTelefone());
            
            if(pst.executeUpdate() > 0){
                Conexao.fecharConexao(con);
                return "Registro alterado com sucesso.";
            }else{
                Conexao.fecharConexao(con);
                return "Erro ao alterar registro.";
            }
        }catch(SQLException e){
            Conexao.fecharConexao(con);
            return e.getMessage();
        }
    }
    //Método para excluir dados
    public String excluir(Fornecedor fornecedor){
        String sql = "delete from fornecedor ";
        sql += "where cnpjforn=?";
        Connection con = Conexao.abrirConexao();
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setString(1, fornecedor.getCnpjForn());
            
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
    public List<Fornecedor> listarTodos(){
        String sql = "select * from fornecedor";
        Connection con = Conexao.abrirConexao();
        List<Fornecedor> lista = new ArrayList<>();
        try{
           PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if(rs != null){
                while(rs.next()){
                    Fornecedor c = new Fornecedor();
                    c.setCnpjForn    (rs.getString(1));
                    c.setNomeForn    (rs.getString(2));
                    c.setEnderecoForn(rs.getString(3));
                    c.setCepForn     (rs.getString(4));
                    c.setIdTelefone  (rs.getString(5));
                    
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
    
    //Método que retorna um objeto, de acordo
    //com o código
    public Fornecedor buscaPorCnpj(int cod){
        String sql = "select * from fornecedor ";
        sql += "where cnpjforn=?";
        Connection con = Conexao.abrirConexao();
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, cod);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                Fornecedor c = new Fornecedor();
                
                c.setCnpjForn      (rs.getString(1));
                c.setNomeForn      (rs.getString(2));
                c.setEnderecoForn  (rs.getString(3));
                c.setCepForn       (rs.getString(4));
                c.setIdTelefone    (rs.getString(5));
                
                Conexao.fecharConexao(con);
                return c;
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

