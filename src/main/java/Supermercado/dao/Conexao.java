/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Supermercado.dao;

/**
 *
 * @author Thekingolias
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public Conexao(){}

    public Connection getConnection() throws SQLException{
        String url = "jdbc:mysql://localhost:3306/supermercado";
        String username = "root";
        String password = "12345";  

        Connection conexao = null;
        try {
            // Carrega o driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Estabelece a conexão
            conexao = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conexao;
    }
}

/* 
drop database if exists supermercado;
create database if not exists supermercado;
use supermercado;


CREATE TABLE usuario (
    codUsuario INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL
);

create table produto(
codProduto int primary key auto_increment,
descricao varchar(200) not null,
preco varchar(20) not null
);
*/