/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Supermercado.dao;

/**
 *
 * @author Thekingolias
 */

import Supermercado.dao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Supermercado.dao.ExceptionDAO;
import Supermercado.model.Usuario;

public class UsuarioDAO{
public void cadastrarUsuario(Usuario usuario) throws ExceptionDAO{
        Connection connect = null;
        try{
            Conexao conection = new Conexao();
            connect = conection.getConnection();

            String query = "INSERT INTO usuario (nome, email, senha) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connect.prepareStatement(query)){
                preparedStatement.setString(1, usuario.getNome());
                preparedStatement.setString(2, usuario.getEmail());
                preparedStatement.setString(3, usuario.getSenha());

                preparedStatement.executeUpdate();
            }
            System.out.println("Usuario adicionado com sucesso!");
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
    
        public ArrayList<Usuario> listarUsuario(String nome) throws ExceptionDAO {
        String query = "select * from usuario where nome like '%" + nome + "%' order by by nome";
        
       Connection connect = null;
       PreparedStatement pStatement = null;
       ArrayList<Usuario> usuarios = null;
       
       try{
           Conexao conection = new Conexao();
            connect = conection.getConnection();
           pStatement = connect.prepareStatement(query);
           ResultSet rs = pStatement.executeQuery(query);
           
           if(rs!=null){
               usuarios = new ArrayList<Usuario>();
               while(rs.next()){
                   Usuario usuario = new Usuario();
                   usuario.setCodUsuario(rs.getInt("codUsuario"));
                   usuario.setNome(rs.getString("nome"));
                   usuario.setEmail(rs.getString("email"));
                   usuario.setSenha(rs.getString("senha"));
                   usuarios.add(usuario);
                   
               }
           }
           
       } catch (SQLException e) {
           throw new ExceptionDAO("Error ao consultar o cadastro." + e);
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
    return usuarios;
    }
     
}

