
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
public class FazPedido {
    
    private String  idPedido;
    private String  data;
    private Integer cpfCliente;

    public Integer getCpfcliente() {
        return cpfCliente;
    }

    public void setCpfcliente(Integer cpfcliente) {
        this.cpfCliente = cpfcliente;
    }

    public String getIdpedido() {
        return idPedido;
    }

    public void setIdpedido(String idpedido) {
        this.idPedido = idpedido;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
