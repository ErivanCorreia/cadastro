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
public class Pessoa {

    private String nome;
    private String cpf;
    private String telefone;

    public Pessoa() {

    }

    public Pessoa(String n, String cpf, String tell) {
        this.nome = n;
        this.cpf = cpf;
        this.telefone = tell;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String NEWnome) {
        this.nome = NEWnome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String newCpf) {
        this.cpf = newCpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String newTell) {
        this.telefone = newTell;
    }

}
