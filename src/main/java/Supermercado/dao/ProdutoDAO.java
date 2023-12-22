/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Supermercado.dao;

import Supermercado.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Thekingolias
 */
public class ProdutoDAO {
    public void cadastrarProduto(Produto produto) throws ExceptionDAO{
        Connection connect = null;
        try{
            Conexao conection = new Conexao();
            connect = conection.getConnection();

            String query = "INSERT INTO PRODUTO (descricao, preco) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connect.prepareStatement(query)){
                preparedStatement.setString(1, produto.getDescricao());
                preparedStatement.setString(2, produto.getPreco());
                preparedStatement.executeUpdate();
            }
            System.out.println("Item adicionado com sucesso!");
        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            if(connect != null){
                try{
                    connect.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
    
        public ArrayList<Produto> listarProduto(String nome) throws ExceptionDAO {
        String query = "select * from produto where nome like '%" + nome + "%' order by by nome";
        
       Connection connect = null;
       PreparedStatement pStatement = null;
       ArrayList<Produto> produtos = null;
       
       try{
           Conexao conection = new Conexao();
            connect = conection.getConnection();
           pStatement = connect.prepareStatement(query);
           ResultSet rs = pStatement.executeQuery(query);
           
           if(rs!=null){
               produtos = new ArrayList<Produto>();
               while(rs.next()){
                   Produto produto = new Produto();
                   produto.setCodProduto(rs.getInt("codProduto"));
                   produto.setDescricao(rs.getString("nome"));
                   produto.setPreco(rs.getString("preco"));
                   produtos.add(produto);
                   
               }
           }
           
       } catch (SQLException e) {
           throw new ExceptionDAO("Error ao consultar o Produto." + e);
        }finally{
           try{
               if(pStatement!=null) { pStatement.close();}
           } catch (SQLException e) {
                throw new ExceptionDAO("Error ao fechar o pStatement:" + e);
           }
           try{
               if(connect!=null) {connect.close();}
           } catch (SQLException e) {
                 throw new ExceptionDAO("Error ao fechar conexão:" + e);
           }
       }
    return produtos;
    }

    public void apagarProduto(Produto produto) throws ExceptionDAO {
        Connection connect = null;
        try {
            Conexao conection = new Conexao();
            connect = conection.getConnection();

            String query = "DELETE FROM PRODUTO WHERE codProduto=?";
            try (PreparedStatement preparedStatement = connect.prepareStatement(query)) {
                preparedStatement.setInt(1, produto.getCodProduto());
                preparedStatement.executeUpdate();
            }
            System.out.println("Item removido com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void alterarProduto(Produto produto) throws ExceptionDAO {
        Connection connect = null;
        try {
            Conexao conection = new Conexao();
            connect = conection.getConnection();

            String query = "UPDATE PRODUTO SET descricao=?, preco=?, WHERE codProduto=?";
            try (PreparedStatement preparedStatement = connect.prepareStatement(query)) {
                preparedStatement.setString(1, produto.getDescricao());
                preparedStatement.setString(2, produto.getPreco());
                preparedStatement.setInt(4, produto.getCodProduto());

                preparedStatement.executeUpdate();
            }
            System.out.println("Item alterado com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

}
}
