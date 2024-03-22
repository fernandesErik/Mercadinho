/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sla;

/**
 * 
 * @author ydebo
 */
//**************************************************QUESTÃO 01**************************************************
public class Cliente {
    private String nome;
    private String sobrenome;
    private String Cpf;
    private String endereco;
    private String tel;
    private String email;
    private static int cont = 0;
    private int quantC;
    private int idade;
    /**
     * 
     * @param nome
     * @param sobrenome
     * @param Cpf
     * @param endereco
     * @param tel
     * @param email
     * @param idade 
     */
    public Cliente (String nome, String sobrenome, String Cpf, String endereco, String tel, String email, int idade){
    this.nome=nome;
    this.sobrenome=sobrenome;
    this.Cpf=Cpf;
    this.endereco=endereco;
    this.tel=tel;
    this.email=email;
    this.quantC = cont;
    this.idade=idade;
    cont++;
    }
/**
 * 
 * @return o contador
 */
    public static int getCont() {
        return cont;
    }
/**
 * 
 * @param cont 
 */
    public static void setCont(int cont) {
        Cliente.cont = cont;
    }
/**
 * 
 * @return quantidade de clientes
 */
    public int getQuantC() {
        return quantC;
    }
    /**
     * 
     * @param quantC 
     */

    public void setQuantC(int quantC) {
        this.quantC = quantC;
    }
/**
 * 
 * @return  o nome do cliente
 */

    public String getNome() {
        return nome;
    }
/**
 * 
 * @param nome 
 */
    public void setNome(String nome) {
        this.nome = nome;
    }
    /**
     * 
     * @return o sobrenome
     */

    public String getSobrenome() {
        return sobrenome;
    }
/**
 * 
 * @param sobrenome 
 */
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
/**
 * 
 * @return o cpf
 */
    public String getCpf() {
        return Cpf;
    }
    /**
     * 
     * @param Cpf 
     */

    public void setCpf(String Cpf) {
        this.Cpf = Cpf;
    }
/**
 * 
 * @return  o endereco
 */
    public String getEndereco() {
        return endereco;
    }
/**
 * 
 * @param endereco 
 */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
/**
 * 
 * @return o telefone
 */
    public String getTel() {
        return tel;
    }
/**
 * 
 * @param tel 
 */
    public void setTel(String tel) {
        this.tel = tel;
    }
/**
 * 
 * @return email
 */
    public String getEmail() {
        return email;
    }
    /**
     * 
     * @param email 
     */

    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * 
     * @return idade
     */
    public int getIdade() {
    return idade;
}
//**************************************************QUESTÃO 03**************************************************
/**
 * 
 * @return 
 */
    @Override
    public String toString() {
        return "Cliente{" + "nome=" + nome + ", sobrenome=" + sobrenome + ", Cpf=" + Cpf + ", endereco=" + endereco + ", tel=" + tel + ", email=" + email + '}';
    }

    
}
