import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private HashMap<String, String> emails;
    private HashMap<String, String> usuarios;
    private Scanner scanner;

    public Main() {
        emails = new HashMap<>();
        usuarios = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\nMENU");
            System.out.println("1 - Login");
            System.out.println("2 - Cadastrar Conta");
            System.out.println("3 - Esqueci minha senha");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    loginUsuario();
                    break;
                case 2:
                    cadastrarUsuario();
                    break;
                case 3:
                    esqueciMinhaSenha();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void cadastrarUsuario() {
        System.out.print("Digite o nome de Usuário: ");
        String usuario = scanner.nextLine();
        if (usuarios.containsKey(usuario)) {
            System.out.println("Usuário já cadastrado!");
            return;
        }
        System.out.println("Digite seu Email: ");
        String email = scanner.nextLine();
        if(emails.containsKey(email)) {
            System.out.println("Email já cadastrado!");
            return;
        }

        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();
        System.out.print("Digite novamente sua senha: ");
        String senhaB = scanner.nextLine();
        if(senha.equals(senhaB)){
            usuarios.put(usuario, senha);
            System.out.println("Usuário cadastrado com sucesso!");
            exibirMenu();
        }else {
            System.out.println("As senhas não são iguais tente novamente");
            cadastrarUsuario();
        }
    }

    private void loginUsuario() {
        System.out.print("Digite seu nome de usuário: ");
        String usuario = scanner.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();

        if (usuarios.containsKey(usuario) && usuarios.get(usuario).equals(senha)) {
            System.out.println("Login bem-sucedido! Bem-vindo, " + usuario + "!");
        } else {
            System.out.println("Usuário ou senha incorretos!");
        }
    }

    private void esqueciMinhaSenha() {

    }

    public static void main(String[] args) {
        Main menu = new Main();
        menu.exibirMenu();
    }
}