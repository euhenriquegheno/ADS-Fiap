//package br.com.fiap.fintech.view;
//
//import br.com.fiap.fintech.model.*;
//
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int op;
//        do {
//            System.out.println("Escolha uma opção: \n1-Criar uma conta \n2-Fazer login \n" +
//                    "3-Alterar senha \n4-Informar um recebimento \n5-Informar um pagamento \n0-Sair");
//            op = sc.nextInt();
//
//            switch (op) {
//                case 1:
//                    Conta conta = new Conta();
//
//                    System.out.println("Nome completo: ");
//                    conta.nomeCompleto = sc.next() + sc.nextLine();
//                    System.out.println("Data de nascimento: ");
//                    conta.dataNascimento = sc.nextLine();
//                    System.out.println("Genero: ");
//                    conta.genero = sc.nextLine();
//                    System.out.println("Email: ");
//                    conta.email = sc.nextLine();
//                    System.out.println("br.com.fiap.fintech.model.Senha: ");
//                    conta.senha = sc.nextLine();
//
//                    conta.criarConta();
//                    break;
//                case 2:
//                    System.out.println("Efetue o br.com.fiap.fintech.model.Login na conta");
//                    System.out.println("Informe o usuário/email:");
//                    String usuario = sc.next() + sc.nextLine();
//                    System.out.println("Informe a senha:");
//                    String senhaConta = sc.nextLine();
//
//                    Login login = new Login(usuario, senhaConta);
//                    login.fazerLogin();
//                    break;
//                case 3:
//                    System.out.println("Informe a senha antiga:");
//                    String senhaAntiga = sc.next() + sc.nextLine();
//                    System.out.println("Informe a nova senha:");
//                    String novaSenha = sc.nextLine();
//                    System.out.println("Repita a nova senha:");
//                    String novaSenhaRepetida = sc.nextLine();
//
//                    Senha senha = new Senha();
//                    senha.alterarSenha(senhaAntiga, novaSenha, novaSenhaRepetida);
//                    break;
//                case 4:
//                    Recebimento recebimento = new Recebimento();
//                    System.out.println("Informe a descrição do recebimento: ");
//                    recebimento.descricao = sc.next() + sc.nextLine();
//                    System.out.println("Informe a data do recebimento: ");
//                    recebimento.dataRecebimento = sc.nextLine();
//                    System.out.println("Informe o valor recebido: ");
//                    recebimento.valor = sc.nextDouble();
//
//                    recebimento.inserirRecebimento();
//                    recebimento.exibirRecebimento();
//                    break;
//                case 5:
//                    Pagamento pagamento = new Pagamento();
//                    System.out.println("Informe a descrição do pagamento: ");
//                    pagamento.descricao = sc.next() + sc.nextLine();
//                    System.out.println("Informe a data do pagamento: ");
//                    pagamento.dataPagamento = sc.nextLine();
//                    System.out.println("Informe o valor pago: ");
//                    pagamento.valor = sc.nextDouble();
//
//                    pagamento.inserirPagamento();
//                    pagamento.exibirPagamento();
//
//                    break;
//                case 0:
//                    System.out.println("Finalizando o programa");
//                    break;
//                default:
//                    System.out.println("Opção inválida");
//            }
//        }while(op != 0);
//
//        sc.close();
//    }
//}