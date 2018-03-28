/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloBeans;

/**
 *
 * @author jaiane
 */
public class Cliente extends Pessoa {

    private int id;
    private int idPesquisa;

    public Cliente() {
        super();
    }

    public int getIdPesquisa() {
        return idPesquisa;
    }

    public void setIdPesquisa(int idPesquisa) {
        this.idPesquisa = idPesquisa;
    }

    public int getId() {
        return id;
    }

    public void setId(int idN) {
        this.id = idN;
    }

    @Override
    public String toString() {
        return "CLIENTE" + "ID: " + this.id + "\nNome: " + this.getNome()
                + "\nCPF: " + this.getCpf() + "\nTelefone: " + this.getTelefone();
    }

}
