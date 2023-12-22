/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Supermercado.controller;

import Supermercado.dao.ExceptionDAO;
import Supermercado.dao.ProdutoDAO;
import Supermercado.model.Produto;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author Thekingolias
 */
public class ProdutoController {
    public boolean cadastrarProduto(String descricao, String preco) throws ParseException, ExceptionDAO{
        if(descricao != null && descricao.length() > 0 && preco != null && preco.length() > 0){
        Produto produto = new Produto(descricao, preco);
        ProdutoDAO user = new ProdutoDAO();
        user.cadastrarProduto(produto);
        return true;
        }
        return false;
    }
    public ArrayList<Produto> listarProdutos(String nome) throws ExceptionDAO{
        return new Produto().listarProduto(nome);
    }
    public boolean apagarProduto(int codProduto) throws ExceptionDAO{
        if(codProduto == 0){
            return false;
        }else{
            Produto produto = new Produto();
            produto.setCodProduto(codProduto);
            produto.apagarProduto(produto);
            return true;
        } 
    }
}
