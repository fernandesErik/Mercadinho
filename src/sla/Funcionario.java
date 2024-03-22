
package sla;

/**
 *
 * @author ydebo
 */
//**************************************************QUESTÃO 01**************************************************
public class Funcionario {
    private int cpf;
    private String nome;
    private int senha;
    /**
     * 
     * @param cpf
     * @param nome
     * @param senha 
     */
    public Funcionario(int cpf, String nome, int senha){
    this.cpf= cpf;
    this.nome=nome;
    this.senha=senha;
    
    }
/**
 * 
 * @return o Cpf
 */
    public int getCpf() {
        return cpf;
    }
/**
 * 
 * @param cpf 
 */
    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
    /**
     * 
     * @return o nome
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
     * @return a senha
     */

    public int getSenha() {
        return senha;
    }
    /**
     * 
     * @param senha 
     */

    public void setSenha(int senha) {
        this.senha = senha;
    }
    
    
//**************************************************QUESTÃO 03**************************************************

    @Override
    public String toString() {
        return "Funcionario{" + "cpf=" + cpf + ", nome=" + nome + ", senha=" + senha + '}';
    }
  
    }
    
