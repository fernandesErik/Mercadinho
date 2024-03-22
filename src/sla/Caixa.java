package sla;

import java.util.ArrayList;
import java.util.List;
import java.lang.Integer;

/**
 * A classe Caixa representa um sistema de caixa para gerenciar vendas e gerar
 * recibos. Inclui métodos para calcular vendas diárias e mensais, bem como
 * registrar e imprimir recibos para transações de vendas.
 *
 * @author ydebo
 */
//**************************************************QUESTÃO 01**************************************************
public class Caixa {

    /**
     * Lista de nomes pré-definidos de caixas.
     */
    private static List<String> ListaCaixas = List.of("Ca1", "Ca2", "Ca3", "CaR", "Cp");

    /**
     * Lista para armazenar transações de vendas diárias.
     */
    private static List<Venda> Diario = new ArrayList<>();

    /**
     * Lista para armazenar totais de vendas mensais.
     */
    static List<Float> Mensal = new ArrayList<>();

    /**
     * Calcula o total de vendas para um determinado dia.
     *
     * @param est O estoque/informações de produtos.
     * @param cli As informações do cliente.
     * @return O total de vendas para o dia.
     */
    public float calcularDiario(Estoque est, Cliente cli) {
        float totalDiario = 0;

        for (Venda venda : Diario) {
            List<Integer> ids = venda.preencherIds();
            List<Integer> Quant = venda.preencherQtd(ids, est.getListadeProdutos());
            String nomeCliente = cli.getNome();
            double totalVenda = venda.calculaTotal(ids, Quant, est.getListadeProdutos());
            totalDiario += totalVenda;
        }

        return totalDiario;
    }

    /**
     * Calcula o total de vendas para cada dia de um mês e acumula o total
     * mensal.
     *
     * @param estoque O estoque/informações de produtos.
     * @param cli As informações do cliente.
     * @return O total de vendas para o mês.
     */
    public float CalculoMensal(Estoque estoque, Cliente cli) {
        float totalMensal = 0;

        for (int i = 0; i < 12; i++) {
            float totalDiario = calcularDiario(estoque, cli);
            totalMensal += totalDiario * 30;
            Mensal.add(totalDiario);
        }

        return totalMensal;
    }

    /**
     * Registra uma transação de venda e imprime um recibo.
     *
     * @param listadeProdutos A lista de produtos na venda.
     * @param total O valor total da venda.
     * @param nomeCliente O nome do cliente.
     */
    //**************************************************QUESTÃO 08**************************************************
    public void registraVenda(List<Produto> listadeProdutos, double total, String nomeCliente) {
        emitirComprovante(listadeProdutos, total, nomeCliente);
    }

    /**
     * Emite um recibo para uma transação de venda.
     *
     * @param listadeProdutos A lista de produtos na venda.
     * @param total O valor total da venda.
     * @param nomeCliente O nome do cliente.
     */
//**************************************************QUESTÃO 10**************************************************    
    public void emitirComprovante(List<Produto> listadeProdutos, double total, String nomeCliente) {
        System.out.println("*****COMPROVANTE DE VENDA*****");
        for (Produto produto : listadeProdutos) {
            System.out.println(produto);
        }
        System.out.println("TOTAL:" + total);
        System.out.println("Cliente: " + nomeCliente);
    }

    /**
     * Obtém a lista de totais de vendas mensais.
     *
     * @return A lista de totais de vendas mensais.
     */
    public static List<Float> getMensal() {
        return Mensal;
    }
}
