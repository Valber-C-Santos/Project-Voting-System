package com.betrybe.sistemadevotacao;

import java.util.ArrayList;

/**
 * class GerenciamentoVotacao implements GerenciamentoVotacaoInterface.
 */

public class GerenciamentoVotacao implements GerenciamentoVotacaoInterface {
  /**
   * class GerenciamentoVotacao implements GerenciamentoVotacaoInterface.
   */

  private ArrayList<PessoaCandidata> pessoasCandidatas;
  private ArrayList<PessoaEleitora> pessoasEleitoras;
  private ArrayList<String> cpfsComputados;

  public GerenciamentoVotacao() {
    this.pessoasCandidatas = new ArrayList<>();
    this.pessoasEleitoras = new ArrayList<>();
    this.cpfsComputados = new ArrayList<>();
  }

  @Override
  public void cadastrarPessoaCandidata(String nome, int numero) {
    if (!pessoasCandidatas.isEmpty()) {
      for (PessoaCandidata candidata : pessoasCandidatas) {
        if (candidata.getNumero() == numero) {
          System.out.println("Número da pessoa candidata já utilizado!");
          return;
        }
      }
    }
    PessoaCandidata candidato = new PessoaCandidata(nome, numero);
    pessoasCandidatas.add(candidato);
  }

  @Override
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    if (!pessoasEleitoras.isEmpty()) {
      for (PessoaEleitora eleitor : pessoasEleitoras) {
        if (eleitor.getCpf().equals(cpf)) {
          System.out.println("Pessoa eleitora já cadastrada!");
          return;
        }
      }
    }
    PessoaEleitora eleitor = new PessoaEleitora(nome, cpf);
    pessoasEleitoras.add(eleitor);
  }


  @Override
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {

  }

  @Override
  public void mostrarResultado() {

  }
}
