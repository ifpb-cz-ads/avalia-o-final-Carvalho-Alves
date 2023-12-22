/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Supermercado.model;

import Supermercado.dao.ExceptionDAO;
import Supermercado.dao.UsuarioDAO;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Thekingolias
 */
public class Usuario {
    private Integer codUsuario;
    private String nome;
    private String email;
    private String senha;
    
    public Usuario(){
        
    }

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Integer getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(Integer codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

   public void cadastrarUsuario(Usuario usuario) throws ExceptionDAO{
        new UsuarioDAO().cadastrarUsuario(usuario);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.email);
        hash = 61 * hash + Objects.hashCode(this.senha);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return Objects.equals(this.senha, other.senha);
    }
    
    public void  buscarUsuarioPorEmail(String email) throws ExceptionDAO {
        new UsuarioDAO().buscarUsuarioPorEmail(email);
    }
    
}
