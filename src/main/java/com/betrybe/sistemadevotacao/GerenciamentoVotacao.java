package com.betrybe.sistemadevotacao;

import java.util.ArrayList;

/**
 * The type Gerenciamento votacao.
 */
public class GerenciamentoVotacao implements GerenciamentoVotacaoInterface {
  private ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<PessoaCandidata>();
  private ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<PessoaEleitora>();
  private ArrayList<String> cpfsComputados = new ArrayList<String>();


  @Override
  public void cadastrarPessoaCandidata(String nome, int numero) {
    if (pessoasCandidatas
        .stream()
        .anyMatch(pessoaCandidata -> pessoaCandidata.getNumero() == numero)) {
      System.out.println("Número da pessoa candidata já utilizado!");
    }

    PessoaCandidata pessoaCandidata = new PessoaCandidata(nome, numero);
    pessoasCandidatas.add(pessoaCandidata);

  }

  @Override
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    if (pessoasEleitoras
        .stream()
        .anyMatch(pessoaEleitora -> pessoaEleitora.getCpf().equals(cpf))) {
      System.out.println("Pessoa eleitora já cadastrada!");
      return;
    }

    PessoaEleitora pessoaEleitora = new PessoaEleitora(nome, cpf);
    pessoasEleitoras.add(pessoaEleitora);
  }

  @Override
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    if (cpfsComputados.contains(cpfPessoaEleitora)) {
      System.out.println("Pessoa eleitora já votou!");
      return;
    }

    for (PessoaCandidata candidato : pessoasCandidatas) {
      if (candidato.getNumero() == numeroPessoaCandidata) {
        candidato.receberVoto();
        break;
      }
    }

    cpfsComputados.add(cpfPessoaEleitora);

  }

  @Override
  public void mostrarResultado() {
    if (cpfsComputados.isEmpty()) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
      return;
    }
    int totalVotos = cpfsComputados.size();
    for (PessoaCandidata candidato : pessoasCandidatas) {
      int votosCandidato = candidato.getVotos();
      double porcentagem = (votosCandidato * 100.0) / totalVotos;
      long porcentagemRound = Math.round(porcentagem);
      System.out.println("Nome: " + candidato.getNome()
          + " - " + candidato.getVotos()
          + " votos ( " + porcentagemRound + "% )");
    }
    System.out.println("Total de votos: " + totalVotos);
  }
}
