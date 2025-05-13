package com.funcionario;


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
    /** TO-DO: Incluir o cálculo do salário do Técnico. */
    return 0.0;
  }
}
