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
public class ProdutoDAO {
    //Método para inserção de dados
    public String inserir(Produto produto){
        String sql = "insert into produto ";
        sql += "values (?,?,?)";
        Connection con = Conexao.abrirConexao();
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt(1, produto.getQtdeEstoque());
            pst.setString(2, produto.getDescricao());
            pst.setDouble(3, produto.getPreco());
            pst.setInt(4, produto.getIdProduto());
            pst.setString(5, produto.getDataCadastro());
            
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
    public String alterar(Produto produto){
        String sql = "update produto set ";
        sql += "qtdeestoque=?,"
             + "descricao=?,"
             + "preco=?,"
             + "datacadastro=?";
        sql += " where idproduto=?";
        Connection con = Conexao.abrirConexao();
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt(1, produto.getQtdeEstoque());
            pst.setString(2, produto.getDescricao());
            pst.setDouble(3, produto.getPreco());
            pst.setInt(4, produto.getIdProduto());
            pst.setString(5, produto.getDataCadastro());
            
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
    public String excluir(Cargo cargo){
        String sql = "delete from cargo ";
        sql += "where codigo=?";
        Connection con = Conexao.abrirConexao();
        try{
            PreparedStatement pst =
                    con.prepareStatement(sql);
            pst.setInt(1, cargo.getCodigo());
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
    public List<Cargo> listarTodos(){
        String sql = "select * from cargo";
        Connection con = Conexao.abrirConexao();
        List<Cargo> lista = new ArrayList<>();
        try{
           PreparedStatement pst = 
                   con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if(rs != null){
                while(rs.next()){
                    Cargo c = new Cargo();
                    c.setCodigo(rs.getInt(1));
                    c.setDescricao(rs.getString(2));
                    c.setSalario(rs.getDouble(3));
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
    public Cargo buscaPorCodigo(int cod){
        String sql = "select * from cargo ";
        sql += "where codigo=?";
        Connection con = Conexao.abrirConexao();
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, cod);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                Cargo c = new Cargo();
                c.setCodigo(rs.getInt(1));
                c.setDescricao(rs.getString(2));
                c.setSalario(rs.getDouble(3));
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
    
    //Método que retorna um objeto, de acordo
    //com a descrição
    public Cargo buscaPorDescricao(String descri){
        String sql = "select * from cargo ";
        sql += "where descricao=?";
        Connection con = Conexao.abrirConexao();
        try{
            PreparedStatement pst =
                    con.prepareStatement(sql);
            pst.setString(1, descri);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                Cargo c = new Cargo();
                c.setCodigo(rs.getInt(1));
                c.setDescricao(rs.getString(2));
                c.setSalario(rs.getDouble(3));
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

