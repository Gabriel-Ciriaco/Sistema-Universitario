package com.departamento;

import com.funcionario.Funcionario;
import com.funcionario.Tecnico;
import com.funcionario.docente.Efetivo;
import com.funcionario.docente.Substituto;


public class Departamento {
  private String codigo;
  private String nome;

  private Funcionario[] funcionarios;
  private int contadorFuncionarios;
  private int maxFuncionarios;

  public Departamento(String codigo, String nome, int numFuncionarios)
  {
    this.codigo = codigo;
    this.nome = nome;
    
    this.contadorFuncionarios = 0;
    this.maxFuncionarios = numFuncionarios;
    this.funcionarios = new Funcionario[numFuncionarios];
  }


  public String getCodigo()
  {
    return this.codigo;
  }

  public String getNome()
  {
    return this.nome;
  }
  
  public int getQtdFuncionarios()
  {
      return this.contadorFuncionarios;
  }

  public Funcionario[] getFuncionarios()
  {
    return this.funcionarios;
  }

  public void setCodigo(String codigo)
  {
    this.codigo = codigo;
  }

  public void setNome(String nome)
  {
    this.nome = nome;
  }

  public boolean addTecnico(String codigo, String nome, double salario, String nivel, String funcao)
  {
    if (this.contadorFuncionarios < this.maxFuncionarios)
    {
      this.funcionarios[this.contadorFuncionarios++] = new Tecnico(codigo, nome, salario, nivel, funcao);

      return true;
    }

    return false;
  }

  public boolean addEfetivo(String codigo, String nome, double salario, String nivel, String titulacao, String area)
  {
    if (this.contadorFuncionarios < this.maxFuncionarios)
    {
      this.funcionarios[this.contadorFuncionarios++] = new Efetivo(codigo, nome, salario, nivel, titulacao, area);

      return true;
    }

    return false;
  }

  public boolean addSubstituto(String codigo, String nome, double salario, String nivel, String titulacao, int cargaHoraria)
  {
    if (this.contadorFuncionarios < this.maxFuncionarios)
    {
      this.funcionarios[this.contadorFuncionarios++] = new Substituto(codigo, nome, salario, nivel, titulacao, cargaHoraria);

      return true;
    }

    return false;
  }



  public boolean removeFuncionario(String codigoFuncionario)
  {
    for (int i = 0; i < this.contadorFuncionarios; i++)
    {
      if (this.funcionarios[i].getCodigo().equals(codigoFuncionario))
      {
        int j;

        for (j = i; j + 1 < this.contadorFuncionarios; j++)
        {
          this.funcionarios[j] = this.funcionarios[j+1];
        }

        this.funcionarios[j] = null;

        this.contadorFuncionarios--;

        return true;
      }
    }

    return false;
  }

}
