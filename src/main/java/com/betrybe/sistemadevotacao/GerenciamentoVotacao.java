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

  /**
   * class GerenciamentoVotacao implements GerenciamentoVotacaoInterface.
   */

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
    if (!cpfsComputados.isEmpty()) {
      for (PessoaEleitora eleitor : pessoasEleitoras) {
        if (cpfPessoaEleitora.equals(eleitor.getCpf())) {
          System.out.println("Pessoa eleitora já votou!");
        }
      }
    }

    for (PessoaCandidata candidato : pessoasCandidatas) {
      if (candidato.getNumero() == numeroPessoaCandidata) {
        candidato.receberVoto();
        cpfsComputados.add(cpfPessoaEleitora);
      }
    }
  }

  @Override
  public void mostrarResultado() {
    if (cpfsComputados.isEmpty()) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
    }
    for (PessoaCandidata candidato : pessoasCandidatas) {
      System.out.println("Nome: " + candidato.getNome()
          + " - " + candidato.getVotos() + " votos " + "( " + Math.round(
          (float) (candidato.getVotos() * 100) / cpfsComputados.size()) + " )");
    }
    System.out.println("Total de votos: " + cpfsComputados.size());
  }

}
