package sla;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A classe Venda representa uma transação de venda de produtos.
 * Inclui métodos para buscar produtos, realizar vendas, preencher IDs e quantidades,
 * calcular o total da venda e mostrar os detalhes da transação.
 * 
 * Além disso, a classe implementa o método toString para fornecer uma representação de string
 * da instância da classe.
 *
 * @author ydebo
 */
//**************************************************QUESTÃO 01**************************************************
public class Venda {

    private Estoque estoque;
    private Produto preco;
    private List<Integer> ids = new ArrayList<>();
    private List<Integer> Quant = new ArrayList<>();

    /**
     * Busca um produto pelo seu ID na lista de produtos.
     *
     * @param idProduto O ID do produto a ser buscado.
     * @param listadeProdutos A lista de produtos disponíveis.
     * @return O produto encontrado ou null se não encontrado.
     */
    public Produto buscarProduto(int idProduto, List<Produto> listadeProdutos) {
        for (Produto produto : listadeProdutos) {
            if (produto.getId() == idProduto) {
                return produto;
            }
        }
        return null;
    }

    /**
     * Realiza uma venda, registrando os produtos vendidos e o total da venda.
     *
     * @param listadeProdutos A lista de produtos disponíveis.
     * @param caixa O caixa para registrar a venda.
     * @param est O estoque para atualizar a quantidade de produtos.
     */
    public void fazVenda(List<Produto> listadeProdutos, Caixa caixa, Estoque est) {
        List<Integer> ids = preencherIds();
        List<Integer> qtd = preencherQtd(ids, listadeProdutos);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine();

        double total = calculaTotal(ids, qtd, est.getListadeProdutos());
        caixa.registraVenda(listadeProdutos, total, nomeCliente);

        System.out.println("Venda realizada com sucesso!");
    }

    /**
     * Preenche a lista de IDs dos produtos vendidos.
     *
     * @return A lista de IDs dos produtos vendidos.
     */
    public List<Integer> preencherIds() {
        Scanner scan = new Scanner(System.in);
        int id = 0;
        while (id != -1) {
            System.out.println("Digite o código do produto (digite -1 para encerrar):");
            id = scan.nextInt();
            ids.add(id);
        }
        return ids;
    }

    /**
     * Preenche a lista de quantidades dos produtos vendidos.
     *
     * @param ids A lista de IDs dos produtos vendidos.
     * @param listadeProdutos A lista de produtos disponíveis.
     * @return A lista de quantidades dos produtos vendidos.
     */
    public List<Integer> preencherQtd(List<Integer> ids, List<Produto> listadeProdutos) {
        Scanner scan = new Scanner(System.in);
        int qtd;
        List<Integer> Quant = new ArrayList<>();

        for (int id : ids) {
            if (id == -1) {
                break;
            }

            Produto produto = buscarProduto(id, listadeProdutos);

            if (produto != null) {
                System.out.println("Digite a quantidade do produto " + produto.getNome() + ":");
                qtd = scan.nextInt();
                Quant.add(qtd);
            } else {
                System.out.println("Produto com ID " + id + " não encontrado.");
            }
        }

        return Quant;
    }

    /**
     * Calcula o total da venda com base nos IDs, quantidades e preços dos produtos.
     *
     * @param ids A lista de IDs dos produtos vendidos.
     * @param quantidades A lista de quantidades dos produtos vendidos.
     * @param listadeProdutos A lista de produtos disponíveis.
     * @return O total da venda.
     */
    public double calculaTotal(List<Integer> ids, List<Integer> quantidades, List<Produto> listadeProdutos) {
        int tamanhoLista = ids.size();
        double total = 0;

        for (int i = 0; i < tamanhoLista; i++) {
            int id = ids.get(i);
            Produto produto = buscarProduto(id, listadeProdutos);

            if (produto != null) {
                int quantidade = quantidades.get(i);
                double precoUnitario = produto.getPreco();
                double subtotal = precoUnitario * quantidade;
                total += produto.getPreco() * quantidade;
            } else {
                System.out.println("Produto com ID " + id + " não encontrado.");
            }
        }

        System.out.println("Total da compra: R$ " + total);

        return total;
    }

    /**
     * Mostra os detalhes dos produtos vendidos, incluindo nome, quantidade, preço unitário e subtotal.
     *
     * @param listaProdutos A lista de produtos disponíveis.
     */
    public void mostraProdutos(List<Produto> listaProdutos) {
        System.out.println("Mostra Produtos:");

        for (int i = 0; i < ids.size(); i++) {
            int idProduto = ids.get(i);
            Produto produto = buscarProduto(idProduto, listaProdutos);

            if (produto != null) {
                int quantidade = Quant.get(i);
                double precoUnitario = produto.getPreco();
                double subtotal = precoUnitario * quantidade;

                System.out.println("Produto: " + produto.getNome());
                System.out.println("Quantidade: " + quantidade);
                System.out.println("Preço Unitário: " + precoUnitario);
                System.out.println("Subtotal: " + subtotal);
                System.out.println("--------------------------");
            }
        }
    }

    /**
     * Obtém a lista de quantidades dos produtos vendidos.
     *
     * @return A lista de quantidades dos produtos vendidos.
     */
    public List<Integer> getQuant() {
        return Quant;
    }

    /**
     * Define a lista de quantidades dos produtos vendidos.
     *
     * @param Quant A lista de quantidades dos produtos vendidos.
     */
    public void setQuant(List<Integer> Quant) {
        this.Quant = Quant;
    }

    //**************************************************QUESTÃO 03**************************************************
    @Override
    public String toString() {
        return "Venda{" + "estoque=" + estoque + ", preco=" + preco + ", ids=" + ids + ", Quant=" + Quant + '}';
    }
}
