package com.funcionario;

public abstract class Funcionario {

  private String codigo;
  private String nome;
  private double salario;
  private String nivel;

  

  public Funcionario(String codigo, String nome, double salario, String nivel) 
  {
    this.codigo = codigo;
    this.nome = nome;
    this.salario = salario;
    this.nivel = nivel;
  }

  public String getNome() 
  {
    return nome;
  }

  public void setNome(String nome) 
  {
    this.nome = nome;
  }

  public double getSalario() 
  {
    return salario;
  }

  public void setSalario(double salario) 
  {
    this.salario = salario;
  }

  public String getNivel() 
  {
    return nivel;
  }

  public void setNivel(String nivel) 
  {
    this.nivel = nivel;
  }

  public String getCodigo()
  {
    return this.codigo;
  }

  public void setCodigo(String codigo)
  {
    this.codigo = codigo;
  }

  public abstract double calcularSalario();


}
