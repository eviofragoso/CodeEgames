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
public class Transportadora {
    private String cnpjTransp;
    private String enderecoTransp;
    private String nomeTransp;
    private String emailTransp;
    private Integer cpfCliente;
    private String idNota;
    private String idPedido;
    private String idTelefone;

    public String getCnpjTransp() {
        return cnpjTransp;
    }

    public void setCnpjTransp(String cnpjTransp) {
        this.cnpjTransp = cnpjTransp;
    }

    public String getEnderecoTransp() {
        return enderecoTransp;
    }

    public void setEnderecoTransp(String enderecoTransp) {
        this.enderecoTransp = enderecoTransp;
    }

    public String getNomeTransp() {
        return nomeTransp;
    }

    public void setNomeTransp(String nomeTransp) {
        this.nomeTransp = nomeTransp;
    }

    public String getEmailTransp() {
        return emailTransp;
    }

    public void setEmailTransp(String emailTransp) {
        this.emailTransp = emailTransp;
    }

    public Integer getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(Integer cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

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

    public String getIdTelefone() {
        return idTelefone;
    }

    public void setIdTelefone(String idTelefone) {
        this.idTelefone = idTelefone;
    }
}
