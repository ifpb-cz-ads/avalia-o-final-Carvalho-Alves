/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Supermercado.controller;

import Supermercado.dao.ExceptionDAO;
import Supermercado.dao.UsuarioDAO;
import Supermercado.model.Usuario;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author Thekingolias
 */
public class UsuarioController {
    public boolean cadastrarUsuario(String nome, String email, String senha) throws ParseException, ExceptionDAO{

        if(nome != null && nome.length() > 0 && email != null && email.length() > 0 && senha != null && senha.length() > 0){
        Usuario usuario = new Usuario(nome, email, senha);
        UsuarioDAO user = new UsuarioDAO();
        user.cadastrarUsuario(usuario);
        return true;
        }
        return false;
    }
    public ArrayList<Usuario> listarUsuario(String nome) throws ExceptionDAO{
        return new Usuario().listarUsuario(nome);
    }
}
