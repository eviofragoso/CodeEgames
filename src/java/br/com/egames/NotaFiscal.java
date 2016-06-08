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
public class NotaFiscal {
    private String  idNota;
    private String  idPedido;
    private String  data;
    private Double  precoTotal;
    private Integer cpfCliente;

    public String getIdNota() {
        return idNota;
    }

    public void setIdNota(String idNota) {
        this.idNota = idNota;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(Double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public Integer getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(Integer cpfCliente) {
        this.cpfCliente = cpfCliente;
    }
    
    
}
