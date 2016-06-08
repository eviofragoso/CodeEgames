//PRONTO
package br.com.egames;

import java.sql.*;

public class Conexao {

    public static Connection abrirConexao() {
        String driver = "org.postgresql.Driver";
        String user = "leandro";//Coloque o usuário criado para acesso ao banco
        String senha = "leandro";//Coloque a senha para acesso ao banco
        String url = "jdbc:postgresql://127.0.0.1:5432/rh";//Coloque o //servidor onde está instalado o banco
        Connection con = null;
        try {
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(url, user, senha);
            //System.out.println("Conexão realizada com sucesso.");
        } catch (ClassNotFoundException ex) {
            System.err.print(ex.getMessage());
        } catch (SQLException e) {
            System.err.print(e.getMessage());
        }
        return con;
    }
    public static void fecharConexao(Connection con){
        try{
            con.close();
        }catch(SQLException e){
            
        }
    }
}




