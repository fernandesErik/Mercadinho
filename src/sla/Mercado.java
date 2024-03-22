package sla;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Map;

/**
 *
 * @author ydebo 
 */
//**************************************************QUESTÃO 01**************************************************
public class Mercado {

    private List<Cliente> listadeClientes = new ArrayList<>();
    private List<Funcionario> listadeFuncionario = new ArrayList<>();
    private Map<Produto, Integer> carrinho;
    private Estoque est = new Estoque();
    private Venda venda = new Venda();
    private Caixa caixa = new Caixa();
    Scanner scanner = new Scanner(System.in);
    /**
     * Exibe o menu para adm
     */

    public void menuADM() {
        System.out.println("*BEM VINDO  ADM*");
        System.out.println("*ESCOLHA A OPCAO DESEJADA*");
        System.out.println("*1: FAZER CADASTRO DE PRODUTOS*");
        System.out.println("*2: FAZER CADASTRO DE FUNCIONARIOS*");
        System.out.println("*3: AREA DO FUNCIONARIO*");
        System.out.println("*4: FAZER CADASTRO DE ADM*");
        System.out.println("*5: REMOVER FUNCIONARIO*");
        System.out.println("*6: EDITAR FUNCIONARIO*");
        System.out.println("*7: FAZER CADASTRO DE ADM*");
        System.out.println("*8: GERAR RELATORIO DO CAIXA*");
        System.out.println("*9: MOSTRAR QUANTIDADE DE CLIENTES E PRODUTOS*");
        System.out.println("*10: ORDENA PRECOS*");
        System.out.println("*11:ORDENA CPF DOS FUNCIONARIOS");
        System.out.println("*0: Sair do menu*");

        Scanner scanADM = new Scanner(System.in);

        int opc = scanADM.nextInt();

        switch (opc) {
            case 1:
                System.out.println("Nome");
                String nome = scanADM.next();
                System.out.println("Preco");
                double preco = scanADM.nextDouble();
                System.out.println("Tipo");
                String tipo = scanADM.next();

                Produto produto = new Produto(nome, preco, tipo);

                est.cadastrarProduto(produto);

                System.out.println("Produto cadastrado com sucesso!");
                List<Produto> listaDeProdutos = est.getListadeProdutos();
                for (Produto p : listaDeProdutos) {
                    System.out.println("ID: " + p.getId() + ", Nome: " + p.getNome() + ", Preço: " + p.getPreco() + ", Tipo: " + p.getTipo());
                }

                menuADM();
                break;
            case 2:
                System.out.println("CPF:");
                int cpfFC = scanADM.nextInt();
                System.out.println("Nome:");
                String nomeFC = scanADM.next();
                System.out.println("Senha:");
                int senhaFC = scanADM.nextInt();

                Funcionario funcionario = new Funcionario(cpfFC, nomeFC, senhaFC);
                listadeFuncionario.add(funcionario);

                System.out.println("Funcionário cadastrado com sucesso!");
                menuADM();

                break;
            case 3:
                menuFC();
                break;
            case 4:
                cadastroADM();
                menuADM();
                break;
            case 5:
                System.out.println("Digite o CPF do funcionário a ser removido:");
                int cpfRemover = scanADM.nextInt();
                RemoveFunc(listadeFuncionario, cpfRemover);

                menuADM();
                break;

            case 6:
                System.out.println("Digite o CPF do funcionário a ser editado:");
                int cpfEditar = scanADM.nextInt();
                editarFuncionario(cpfEditar);
                menuADM();

                break;
            case 7:
                System.out.println("CPF do administrador:");
                int cpf = scanADM.nextInt();
                System.out.println("Nome:");
                String Nome = scanADM.next();
                System.out.println("Senha:");
                int senha = scanADM.nextInt();

                ADM admin = new ADM(cpf, Nome, senha);
                listadeFuncionario.add(admin);
                System.out.println("Administrador cadastrado");
                menuADM();
                break;
            case 8:
                Cliente cli = new Cliente("", "", "", "", "", "", 0);
                float totalMensal = caixa.CalculoMensal(est, cli);
                System.out.println("Relatorio do Caixa " + totalMensal);
                System.out.println("Detalhes:");

                List<Float> mensalList = caixa.getMensal();
                for (int i = 0; i < mensalList.size(); i++) {
                    System.out.println("Mes " + (i + 1) + ": " + mensalList.get(i));
                }

                menuADM();
                break;
            case 9:
                mostraInstancia();
                menuADM();
                break;
            case 10:
                est.comparaPreco();
                System.out.println("Lista de produtos ordenada por preço:");
                List<Produto> listaProdutosPreco = est.getListadeProdutos();
                for (Produto p : listaProdutosPreco) {
                    System.out.println("ID: " + p.getId() + ", Nome: " + p.getNome() + ", Preço: " + p.getPreco() + ", Tipo: " + p.getTipo());
                }

                menuADM();
                break;
            case 11:
                Comparator<Funcionario> comparatorPorCpfAscendente = Comparator.comparing(Funcionario::getCpf);

                ordenarPorCpf(listadeFuncionario, comparatorPorCpfAscendente);

                System.out.println("Lista de Funcionários ordenada por CPF em ordem ascendente:");
                for (Funcionario func : listadeFuncionario) {
                    System.out.println("CPF: " + func.getCpf() + ", Nome: " + func.getNome() + ", Senha: " + func.getSenha());
                }
                menuADM();
                break;

            case 0:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("*OPCAO INVALIDA*");
        }
    }
    /**
     * Exibe o menu pra funcionarios
     */

    public void menuFC() {
        System.out.println("*BEM VINDO FUNCIONARIO*");
        System.out.println("*ESCOLHA A OPCAO DESEJADA*");
        System.out.println("*1: FAZER CADASTRO DE PRODUTOS*");
        System.out.println("*2: FAZER CADASTRO DE CLIENTES*");
        System.out.println("*3: VERIFICAR CADASTRO DO CLIENTE*");
        System.out.println("*4: EDITAR CLIENTE*");
        System.out.println("*5: REMOVER CLIENTE*");
        System.out.println("*6: FINALIZA VENDA*");
        System.out.println("*7: AREA ADM*");
        System.out.println("*0: Sair*");

        Scanner scanFC = new Scanner(System.in);

        int opc = scanFC.nextInt();

        switch (opc) {

            case 1:
                System.out.println("Nome");
                String nome = scanFC.next();
                System.out.println("Preco");
                double preco = scanFC.nextDouble();
                System.out.println("Tipo");
                String tipo = scanFC.next();

                Produto produto = new Produto(nome, preco, tipo);

                est.cadastrarProduto(produto);

                System.out.println("Produto cadastrado com sucesso!");
                List<Produto> listaDeProdutos = est.getListadeProdutos();
                for (Produto p : listaDeProdutos) {
                    System.out.println("ID: " + p.getId() + ", Nome: " + p.getNome() + ", Preço: " + p.getPreco() + ", Tipo: " + p.getTipo());
                }
                menuFC();
                break;
            case 2:
                criarCliente();
                menuFC();
                break;
            case 3:
                System.out.println("Digite o CPF do cliente a ser encontrado:");
                String cpfAlvo = scanFC.next();
                Cliente clienteComCpfAlvo = verificarCadastroCliente(cpfAlvo);

                if (clienteComCpfAlvo != null) {
                    System.out.println("Cliente encontrado:");
                    System.out.println("Nome: " + clienteComCpfAlvo.getNome());
                    System.out.println("CPF: " + clienteComCpfAlvo.getCpf());
                } else {
                    System.out.println("Cliente com CPF " + cpfAlvo + " não encontrado.");
                }
                menuFC();
                break;

            case 4:
                System.out.println("CPF do Cliente a ser editado:");
                String cpfEditarCliente = scanFC.next();
                Cliente clienteEncontradoEditar = verificarCadastroCliente(cpfEditarCliente);

                if (clienteEncontradoEditar != null) {
                    System.out.println("Novo nome:");
                    String novoNome = scanFC.next();
                    editarClientes(cpfEditarCliente, novoNome);
                    System.out.println("Cliente editado com sucesso!");
                } else {
                    System.out.println("Cliente não encontrado.");
                }
                menuFC();
                break;

            case 5:
                System.out.println("CPF do Cliente a ser removido:");
                String cpfRemoverCliente = scanFC.next();
                Cliente clienteEncontradoRemover = verificarCadastroCliente(cpfRemoverCliente);

                if (clienteEncontradoRemover != null) {

                    removerCliente(cpfRemoverCliente);
                    System.out.println("Cliente removido com sucesso!");
                } else {
                    System.out.println("Cliente não encontrado.");
                }
                menuFC();
                break;

            case 6:
                venda.fazVenda(est.getListadeProdutos(), caixa, est);
                menuFC();
                break;

            case 7:
                Login login = new Login();
                login.AdminLogin();
                break;
            case 0:
                System.out.println("Saindo...");
                break;

        }

    }
//**************************************************QUESTÃO 17**************************************************
/**
 * 
 * @param comparator
 * @return o próximo elemento do iterador se houver, caso contrário, retorna null
 */
    public Cliente findCliente(Comparator<Cliente> comparator) {
        listadeClientes.sort(comparator);

        Iterator<Cliente> iterator = listadeClientes.iterator();
        return iterator.hasNext() ? iterator.next() : null;
    }
//**************************************************QUESTÃO 08**************************************************
/**
 * 
 * @param Cpf
 * @return Cliente ou null
 */
    public Cliente verificarCadastroCliente(String Cpf) {
        for (Cliente cliente : listadeClientes) {
            if (cliente.getCpf().equals(Cpf)) {
                return cliente;
            }
        }

        return null;
    }
 //**************************************************QUESTÃO 07**************************************************
/**
 * 
 * @param cpf
 * @param nome 
 */
    public void editarClientes(String cpf, String nome) {
        if (cpf == null || nome == null) {
            System.out.println("CPF ou nome nulo. Edição cancelada.");
            return;
        }

        Iterator<Cliente> iterator = listadeClientes.iterator();

        while (iterator.hasNext()) {
            Cliente cliente = iterator.next();

            if (cliente.getCpf().equals(cpf)) {
                if (!cliente.getNome().equals(nome)) {
                    cliente.setNome(nome);
                    System.out.println("Dados editados para o CPF " + cpf);
                } else {
                    System.out.println("O nome fornecido é igual ao nome existente. Nenhuma edição necessária.");
                }
                return;
            }
        }

        System.out.println("Cliente não encontrado com o CPF: " + cpf);
    }
    //**************************************************QUESTÃO 07**************************************************
    /**
     * 
     * @param Cpf 
     */

    public void removerCliente(String Cpf) {
        Iterator<Cliente> iterator = listadeClientes.iterator();

        while (iterator.hasNext()) {
            Cliente cliente = iterator.next();

            if (cliente.getCpf().equals(Cpf)) {
                iterator.remove();
                System.out.println("Cliente removido");
                return;
            }
        }
        System.out.println("Cliente não encontrado:" + Cpf);
    }
    //**************************************************QUESTÃO 06**************************************************
    /**
     * 
     * @param listaDeFuncionario
     * @param cpf 
     */

    public void RemoveFunc(List<Funcionario> listaDeFuncionario, int cpf) {
        Iterator<Funcionario> iterator = listaDeFuncionario.iterator();

        while (iterator.hasNext()) {
            Funcionario func = iterator.next();

            if (func.getCpf() == cpf) {
                iterator.remove();
                System.out.println("Funcionário Demitido");
                return;
            }
        }
        System.out.println("Funcionário não encontrado: " + cpf);
    }
//**************************************************QUESTÃO 06**************************************************
//**************************************************QUESTÃO 15**************************************************
//o método percorre a ArrayList utilizando um Iterator, verifica se o CPF fornecido corresponde
//ao CPF de algum funcionário na lista e, se encontrar, permite ao usuário editar o nome e a senha desse funcionário.
//A relação entre o código original (com Iterator) e o código com foreach é que ambos têm o mesmo propósito - percorrer uma 
    //ArrayList de objetos
/**
 * 
 * @param cpf 
 */
    public void editarFuncionario(int cpf) {
        Iterator<Funcionario> iterator = listadeFuncionario.iterator();

        while (iterator.hasNext()) {
            Funcionario func = iterator.next();

            if (func.getCpf() == cpf) {
                System.out.println("Digite o novo nome:");
                String novoNome = scanner.next();
                System.out.println("Digite a nova senha:");
                int novaSenha = scanner.nextInt();

                func.setNome(novoNome);
                func.setSenha(novaSenha);

                System.out.println("Funcionário editado com sucesso!");
                return;
            }
        }
        System.out.println("Funcionário não encontrado com CPF: " + cpf);
    }
//**************************************************QUESTÃO 07**************************************************
/**
 * Método responsável por cadastrar o cliente
 */
    public void criarCliente() {
        System.out.println("Nome");
        String nomec = scanner.next();
        System.out.println("sobrenome");
        String sobrenomec = scanner.next();
        System.out.println("Cpf");
        String CpfC = scanner.next();
        System.out.println("endereco");
        String enderecoC = scanner.next();
        System.out.println("tel");
        String telC = scanner.next();
        System.out.println("email");
        String emailC = scanner.next();
        System.out.println("Idade");
        int idadeC = scanner.nextInt();
        Cliente cliente = new Cliente(nomec, sobrenomec, CpfC, enderecoC, telC, emailC, idadeC);
        listadeClientes.add(cliente);

        System.out.println("Cliente cadastrado com sucesso!");

    }
    //**************************************************QUESTÃO 06**************************************************
    /**
     * Metodo responsável or cadastrar o ADM
     */

    public void cadastroADM() {
        System.out.println("CPF:");
        int cpfADM = scanner.nextInt();
        System.out.println("Nome:");
        String nomeADM = scanner.next();
        System.out.println("Senha:");
        int senhaADM = scanner.nextInt();

        ADM administrador = new ADM(cpfADM, nomeADM, senhaADM);

        listadeFuncionario.add(administrador);

        System.out.println("Administrador cadastrado com sucesso!");
    }
    //**************************************************QUESTÃO 12**************************************************
    /**
     * ela está na main também
     * Metodo responsável por mostrar quantas instancias cliadas de Produto e Cliente
     */ 

    public void mostraInstancia() {
        System.out.println("Numero de produtos: " + Produto.getCont());
        System.out.println("Numero de Clientes: " + Cliente.getCont());
    }
//**************************************************QUESTÃO 16**************************************************
/**
 * 
 * @param lista
 * @param comparator 
 */
    public static void ordenarPorCpf(List<Funcionario> lista, Comparator<Funcionario> comparator) {
        Collections.sort(lista, comparator);
    }
    
/**
 * 
 * @return a lista de cliente
 */
    public List<Cliente> getListadeClientes() {
        return listadeClientes;
    }
/**
 * 
 * @param cliente 
 */
    public void adicionarCliente(Cliente cliente) {
        listadeClientes.add(cliente);
    }
    /**
     * Mostra os dados dos Funcionarios
     */

    public void exibirFuncionarios() {
        for (Funcionario func : listadeFuncionario) {
            System.out.println("CPF: " + func.getCpf() + ", Nome: " + func.getNome());
        }
    }

}
