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
import java.awt.List;

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
            
            throw new RuntimeException("Email Existente! Informe outro");
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
    
   
        
        public Usuario buscarUsuarioPorEmail(String email) throws ExceptionDAO {
    String query = "SELECT * FROM usuario WHERE email = ?";
    
    Connection connect = null;
    PreparedStatement pStatement = null;
    Usuario usuario = null;
    
    try {
        Conexao conection = new Conexao();
        connect = conection.getConnection();
        pStatement = connect.prepareStatement(query);
        pStatement.setString(1, email);
        
        ResultSet rs = pStatement.executeQuery();
        
        if (rs != null && rs.next()) {
            usuario = new Usuario();
            usuario.setEmail(rs.getString("email"));
            usuario.setSenha(rs.getString("senha"));
        }
        
    } catch (SQLException e) {
        throw new ExceptionDAO("Erro ao buscar usuário por email: " + e.getMessage());
    } finally {
        try {
            if (pStatement != null) {
                pStatement.close();
            }
        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao fechar o pStatement: " + e.getMessage());
        }
        try {
            if (connect != null) {
                connect.close();
            }
        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao fechar conexão: " + e.getMessage());
        }
    }
    
    return usuario;
}
     
}

