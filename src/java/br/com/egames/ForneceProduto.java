//PRONTO

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
public class ForneceProduto {
        
    private String cnpjForn;
    private Double precoUnitario;
    private Integer idProduto;

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getCnpjForn() {
        return cnpjForn;
    }

    public void setCnpjForn(String cnpjForn) {
        this.cnpjForn = cnpjForn;
    }

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(Double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }
    
    
}
