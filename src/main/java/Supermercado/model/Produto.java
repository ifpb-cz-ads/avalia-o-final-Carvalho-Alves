/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Supermercado.model;

import Supermercado.dao.ExceptionDAO;
import Supermercado.dao.ProdutoDAO;
import java.util.ArrayList;

/**
 *
 * @author Thekingolias
 */
public class Produto {
    private Integer codProduto; 
    private String descricao;
    private String preco;

    public Produto() {
    }

    public Produto(String descricao, String preco) {
        this.descricao = descricao;
        this.preco = preco;
    }

    public Integer getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(Integer codProduto) {
        this.codProduto = codProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }
    
     public void cadastrarProduto(Produto produto) throws ExceptionDAO{
        new ProdutoDAO().cadastrarProduto(produto);
    }
    
    public ArrayList<Produto> listarProduto(String nome) throws ExceptionDAO{
        return new ProdutoDAO().listarProduto(nome);
    }
    public void alterarProduto(Produto produto) throws ExceptionDAO{
        new ProdutoDAO().alterarProduto(produto);
    }
    public void apagarProduto(Produto produto) throws ExceptionDAO{
        new ProdutoDAO().apagarProduto(produto);
    }
    
}
