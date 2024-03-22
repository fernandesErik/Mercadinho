package sla;

/**
 * A classe Produto representa um produto disponível para venda.
 * Inclui métodos para obter e definir informações sobre o produto, como nome, preço, ID e tipo.
 *
 * Além disso, a classe implementa o método toString para fornecer uma representação de string
 * da instância da classe.
 *
 * @author ydebo
 */
//**************************************************QUESTÃO 01**************************************************
public class Produto {

    private static int cont = 0;
    private String nome;
    private double preco;
    private int id;
    private String tipo;

    /**
     * Construtor da classe Produto que inicializa as propriedades do produto.
     *
     * @param nome O nome do produto.
     * @param preco O preço do produto.
     * @param tipo O tipo do produto.
     */
    public Produto(String nome, double preco, String tipo) {
        this.nome = nome;
        this.preco = preco;
        this.tipo = tipo;
        this.id = cont;
        cont++;
    }

    /**
     * Obtém o nome do produto.
     *
     * @return O nome do produto.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do produto.
     *
     * @param nome O novo nome do produto.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o preço do produto.
     *
     * @return O preço do produto.
     */
    public double getPreco() {
        return preco;
    }

    /**
     * Define o preço do produto.
     *
     * @param preco O novo preço do produto.
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * Obtém o ID do produto.
     *
     * @return O ID do produto.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o ID do produto.
     *
     * @param id O novo ID do produto.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtém o tipo do produto.
     *
     * @return O tipo do produto.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Define o tipo do produto.
     *
     * @param tipo O novo tipo do produto.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtém o contador de produtos.
     *
     * @return O contador de produtos.
     */
    public static int getCont() {
        return cont;
    }

    /**
     * Define o contador de produtos.
     *
     * @param cont O novo valor do contador de produtos.
     */
    public static void setCont(int cont) {
        Produto.cont = cont;
    }

    //**************************************************QUESTÃO 03**************************************************
    @Override
    public String toString() {
        return "Produto{" + "nome=" + nome + ", preco=" + preco + ", id=" + id + ", tipo=" + tipo + '}';
    }
}
