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
    }

    PessoaEleitora pessoaEleitora = new PessoaEleitora(nome, cpf);
    pessoasEleitoras.add(pessoaEleitora);
  }

  @Override
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {

  }

  @Override
  public void mostrarResultado() {

  }
}
