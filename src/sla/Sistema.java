package sla;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author ydebo
 */
//**************************************************QUESTÃO 01**************************************************
public class Sistema {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//**************************************************QUESTÃO 20**************************************************
        Estoque estoque = new Estoque();
        Produto prod1 = new Produto("Cerveja", 10.0, "Bebida");
        Produto prod2 = new Produto("Sorvete", 9.0, "Bebida");
        Produto prod3 = new Produto("Cerveja", 18.0, "Bebida");
        
        estoque.adicionarProduto(prod1);
        estoque.adicionarProduto(prod2);
        estoque.adicionarProduto(prod3);
        
        List<Produto> listadeProdutos = estoque.getListadeProdutos();
        
        estoque.comparaPreco();
        
        System.out.println("Produtos ordenados:");
        for(Produto produto: listadeProdutos){
        System.out.println(produto);
        }
//**************************************************LOGIN************************************************************
//        Login login = new Login();
//        login.menuLogin();
//        if (login.talogado()) {
//            System.out.println("Login feito com sucesso!");
//        } else {
//            System.out.println("Login falhou.");
//            login.menuLogin();
//        }
//**************************************************QUESTÃO 17**************************************************

//         Mercado mercado = new Mercado();
//        Cliente cliente1 = new Cliente("Joao","a","a","a","a","a",1);
//        Cliente cliente2 = new Cliente("Maria","a","a","a","a","a",1);
//        Cliente cliente3 = new Cliente("Carlos","a","a","a","a","a",1);
//
//        mercado.adicionarCliente(cliente1);
//        mercado.adicionarCliente(cliente2);
//        mercado.adicionarCliente(cliente3);
//
//        // Crie um Comparator que compara os clientes com base no nome
//        Comparator<Cliente> comparator = Comparator.comparing(Cliente::getNome);
//
//        // Teste o método findCliente com o Comparator
//        Cliente clienteEncontrado = mercado.findCliente(comparator);
//
//        // Exiba o resultado na saída padrão
//        if (clienteEncontrado != null) {
//            System.out.println("Cliente encontrado: " + clienteEncontrado.getNome());
//        } else {
//            System.out.println("Cliente não encontrado");
//        }
//**************************************************QUESTÃO 16**************************************************
//           List<Funcionario> listadeFuncionario = new ArrayList<>();
//         listadeFuncionario.add(new Funcionario(1,"Joao",30));
//        listadeFuncionario.add(new Funcionario(2,"Maria",25));
//        listadeFuncionario.add(new Funcionario(3,"Carlos", 35));
//
//        // Crie um Comparator para ordenar por nome em ordem crescente
//        Comparator<Funcionario> comparatorPorNomeAscendente = Comparator.comparing(Funcionario::getNome);
//
//        // Crie um Comparator para ordenar por idade em ordem decrescente
//        Comparator<Funcionario> comparatorPorCpfDescendente = Comparator.comparing(Funcionario::getCpf).reversed();
//
//        // Utilize o método sort da classe Collections com os comparators criados
//        Collections.sort(listadeFuncionario, comparatorPorNomeAscendente);
//        System.out.println("Lista de Funcionários ordenada por nome em ordem ascendente: " + listadeFuncionario);
//
//        Collections.sort(listadeFuncionario, comparatorPorCpfDescendente);
//        System.out.println("Lista de Funcionários ordenada por Cpf em ordem descendente: " + listadeFuncionario);
//**************************************************QUESTÃO 15**************************************************
//**************************************************ITERATOR****************************************************
//        List<Funcionario> listadeFuncionario = new ArrayList<>();
//        Mercado mercado = new Mercado();
//        listadeFuncionario.add(new Funcionario(1, "Joao", 30));
//        listadeFuncionario.add(new Funcionario(2, "Maria", 25));
//        listadeFuncionario.add(new Funcionario(3, "Carlos", 35));
//
//        // Exibir a lista de funcionários antes da remoção
//        System.out.println("Lista de Funcionários antes da remoção:"+listadeFuncionario);
//
//        // Chamar o método RemoveFunc para demitir um funcionário
//        mercado.RemoveFunc(listadeFuncionario,2);
//
//        // Exibir a lista de funcionários após a remoção
//        System.out.println("Lista de Funcionários após a remoção:"+listadeFuncionario);
//        mercado.exibirFuncionarios();
//****************************************FOREACH****************************************  
//        Mercado mercado = new Mercado();
//
//        Cliente cliente1 = new Cliente("Joao", "a", "a", "a", "a", "a", 1);
//        Cliente cliente2 = new Cliente("Maria", "a", "b", "a", "a", "a", 1);
//        Cliente cliente3 = new Cliente("Carlos", "a", "c", "a", "a", "a", 1);
//
//        mercado.adicionarCliente(cliente1);
//        mercado.adicionarCliente(cliente2);
//        mercado.adicionarCliente(cliente3);
//
//        String CpfProcurado = "b"; 
//        Cliente clienteProcurado = mercado.verificarCadastroCliente(CpfProcurado);
//
//        if (clienteProcurado != null) {
//            System.out.println("Cliente encontrado: " + clienteProcurado.getNome());
//        } else {
//            System.out.println("Cliente não encontrado");
//
//        }
    }
//
}

/**
 * *****************************QUESTÃO 11-A********************************
 * >Vantagens: Maior controle sobre o acesso da variável. O encapsulamento é
 * melhor, pois com o uso de private a variável não pode ser acessada
 * diretamente fora da classe o que garante mais segurança. >Desvantagem tem um
 * overhead devido à necessidade de criar métodos get e set para acessar a
 * variável.
 *
 */
//    private static int contadorClientes = 0;
//
//    public static void incrementarContadorClientes() {
//        contadorClientes++;
//    }
//
//    public static int getContadorClientes() {
//        return contadorClientes;
//    }
/**
 * *****************************QUESTÃO 11-B******************************
 * Vantagens: Com o uso do protected temos uma maior flexbilidade em herarquias
 * de classe, pois com o uso dele conseguimos ter acesso direto as subclasses.
 * Menos repetição de código, já que a variável pode ser acessada diretamente
 * pelas subclasses
 *
 * > Desvantagens: Menos encapsulamento em relação ao get e set pois as
 * subclasses podem ser acessadas diretamente. Menos controle da manipulação da
 * variável, pois qualquer classe no mesmo pacote consegue acessa-la.
 */
//    protected static int contadorClientes2 = 0;
//
//**************************************************QUESTÃO 12**************************************************
/**
 * Metodo responsável por mostrar quantas instancias cliadas de Produto e
 * Cliente
 */
//    public void mostraInstancia() {
//        System.out.println("Numero de produtos: " + Produto.getCont());
//        System.out.println("Numero de Clientes: " + Cliente.getCont());
//    }
//}
