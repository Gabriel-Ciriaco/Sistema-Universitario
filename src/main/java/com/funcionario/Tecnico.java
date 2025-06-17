package com.funcionario;

import com.ConstantesSistema;


public class Tecnico extends Funcionario {
  private String funcao;

  public Tecnico(String codigo, String nome, double salario, String nivel, String funcao)
  {
    super(codigo, nome, salario, nivel);
    
    this.funcao = funcao;
  }

  public String getFuncao()
  {
    return funcao;
  }

  public void setFuncao(String funcao)
  {
    this.funcao = funcao;
  }

  public double calcularSalario()
  {
    switch (this.getNivel()) {
      case "T1":
      return this.getSalario() * (1 + ConstantesSistema.T1);

      case "T2":
      return this.getSalario() * (1 + ConstantesSistema.T2);

      default:
      return this.getSalario();
    }
  }
}
