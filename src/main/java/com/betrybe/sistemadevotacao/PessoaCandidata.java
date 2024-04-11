package com.betrybe.sistemadevotacao;

/**
 * The type Pessoa candidata.
 */
public class PessoaCandidata extends Pessoa {

  int numero;
  int votos;

  /**
   * Instantiates a new Pessoa candidata.
   *
   * @param nome   the nome
   * @param numero the numero
   */
  public PessoaCandidata(String nome, int numero) {
    this.nome = nome;
    this.numero = numero;
    this.votos = 0;
  }

  public int getNumero() {
    return numero;
  }

  public int getVotos() {
    return votos;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public void receberVoto() {
    this.votos++;
  }
}
