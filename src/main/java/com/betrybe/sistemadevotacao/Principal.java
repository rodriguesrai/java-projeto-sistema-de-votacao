package com.betrybe.sistemadevotacao;

import java.util.Scanner;

/**
 * The type Principal.
 */
public class Principal {

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    GerenciamentoVotacao gerenciamentoVotacao = new GerenciamentoVotacao();

    // Cadastrar pessoas candidatas
    boolean continuarCadastroCandidatos = true;
    while (continuarCadastroCandidatos) {
      System.out.println("Cadastrar pessoa candidata?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:");
      int opcao = scanner.nextInt();
      scanner.nextLine();

      if (opcao == 1) {
        System.out.println("Entre com o nome da pessoa candidata:");
        String nome = scanner.nextLine();
        System.out.println("Entre com o número da pessoa candidata:");
        int numero = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer
        gerenciamentoVotacao.cadastrarPessoaCandidata(nome, numero);
      } else {
        continuarCadastroCandidatos = false;
      }
    }

    // Cadastrar pessoas eleitoras
    boolean continuarCadastroEleitores = true;
    while (continuarCadastroEleitores) {
      System.out.println("Cadastrar pessoa eleitora?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:");
      int opcao = scanner.nextInt();


      if (opcao == 1) {
        System.out.println("Entre com o nome da pessoa eleitora:");
        String nome = lerLinha(scanner);
        System.out.println("Entre com o CPF da pessoa eleitora:");
        String cpf = lerLinha(scanner);
        gerenciamentoVotacao.cadastrarPessoaEleitora(nome, cpf);
      } else {
        continuarCadastroEleitores = false;
      }
    }

    // Votação
    boolean votacaoFinalizada = false;
    while (!votacaoFinalizada) {
      System.out.println("Entre com o número correspondente à opção desejada:");
      System.out.println("1 - Votar");
      System.out.println("2 - Resultado Parcial");
      System.out.println("3 - Finalizar Votação");
      int opcao = scanner.nextInt();


      switch (opcao) {
        case 1:
          System.out.println("Entre com o cpf da pessoa eleitora:");
          String cpfEleitor = lerLinha(scanner);
          System.out.println("Entre com o número da pessoa candidata:");
          int numeroCandidato = scanner.nextInt();
          gerenciamentoVotacao.votar(cpfEleitor, numeroCandidato);
          break;
        case 2:
          gerenciamentoVotacao.mostrarResultado();
          break;
        case 3:
          votacaoFinalizada = true;
          gerenciamentoVotacao.mostrarResultado();
          break;
        default:
          System.out.println("Opção inválida!");
      }
    }
  }

  private static String lerLinha(Scanner scanner) {
    String linha = "";
    while (linha.isEmpty()) {
      linha = scanner.nextLine();
    }
    return linha;
  }
}


