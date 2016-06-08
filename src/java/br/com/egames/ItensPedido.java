/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.egames;

/**
 *
 * @author Leandro
 */
public class ItensPedido {
    private String  idPedido;
    private Integer qtdeProdutoPedido;
    private Integer idProduto;

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public Integer getQtdeProdutoPedido() {
        return qtdeProdutoPedido;
    }

    public void setQtdeProdutoPedido(Integer qtdeProdutoPedido) {
        this.qtdeProdutoPedido = qtdeProdutoPedido;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }
    
    
}
