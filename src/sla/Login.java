package sla;

import java.util.Scanner;

/**
 * A classe Login representa um sistema de login para administradores e funcionários.
 * Inclui métodos para exibir o menu de login, realizar o login para admin e funcionário,
 * verificar se o usuário está logado e fornecer uma representação de string da instância da classe.
 * 
 * Além disso, a classe implementa o método toString para fornecer uma representação de string
 * da instância da classe.
 * 
 * A classe também contém uma instância de Scanner para a entrada do usuário.
 * 
 * @author ydebo
 */
//**************************************************QUESTÃO 01**************************************************
public class Login {
    private boolean logado;
    Scanner scanner = new Scanner(System.in);

    /**
     * Construtor da classe Login que inicializa o estado de login como falso.
     */
    public Login() {
        logado = false;
    }

    /**
     * Exibe o menu de login, permitindo ao usuário escolher entre admin e funcionário.
     */
    public void menuLogin() {
        System.out.println("Digite 1 para Admin, 2 para Funcionario:");
        int user = scanner.nextInt();

        switch (user) {
            case 1:
                AdminLogin();
                break;
            case 2:
                funcLogin();
                break;
            default:
                System.out.println("Usuário inválido.");
        }
    }

    //**************************************************QUESTÃO 02**************************************************
    /**
     * Realiza o login para um administrador, exige a senha correta.
     */
    public void AdminLogin() {
        Mercado mercado = new Mercado();
        System.out.println("Entre com a senha:");
        int adminSenha = scanner.nextInt();

        if (adminSenha == 1234) {
            System.out.println("Bem-vindo!");
            logado = true;
            mercado.menuADM();
        } else {
            System.out.println("Senha incorreta.");
        }
    }

    //**************************************************QUESTÃO 02**************************************************
    /**
     * Realiza o login para um funcionário, exige a senha correta.
     */
    private void funcLogin() {
        Mercado mercado = new Mercado();
        System.out.println("Entre com a senha:");
        int FCsenha = scanner.nextInt();

        if (FCsenha == 5678) {
            System.out.println("Bem-vindo!");
            logado = true;
            mercado.menuFC();
        } else {
            System.out.println("Senha incorreta.");
        }
    }

    /**
     * Verifica se o usuário está logado.
     *
     * @return true se o usuário estiver logado, false caso contrário.
     */
    public boolean talogado() {
        return logado;
    }

    //**************************************************QUESTÃO 03**************************************************
    @Override
    public String toString() {
        return "Login{" + "scanner=" + scanner + ", logado=" + logado + '}';
    }
}
