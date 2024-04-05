package com.betrybe.sistemadevotacao;

/**
 * class PessoaEleitora extends Pessoa.
 */

public class PessoaEleitora extends Pessoa {
  private String cpf;

  /**
  * class PessoaEleitora extends Pessoa.
  */

  public PessoaEleitora(String nome, String cpf) {
    this.nome = nome;
    this.cpf = cpf;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }
}
