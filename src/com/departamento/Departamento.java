package com.departamento;

import com.funcionario.Funcionario;
import com.funcionario.Tecnico;
import com.funcionario.docente.Efetivo;
import com.funcionario.docente.Substituto;


public class Departamento {
  private String codigo;
  private String nome;
  private Funcionario[] funcionarios;

  public Departamento(String codigo, String nome, int numFuncionarios)
  {
    this.codigo = codigo;
    this.nome = nome;
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
    for (int i = 0; i < this.funcionarios.length; i++)
    {
      if (this.funcionarios[i] == null)
      {
        this.funcionarios[i] = new Tecnico(codigo, nome, salario, nivel, funcao);

        return true;
      }
    }

    return false;
  }

  public boolean addEfetivo(String codigo, String nome, double salario, String nivel, String titulacao, String area)
  {
    for (int i = 0; i < this.funcionarios.length; i++)
    {
      if (this.funcionarios[i] == null)
      {
        this.funcionarios[i] = new Efetivo(codigo, nome, salario, nivel, titulacao, area);

        return true;
      }
    }

    return false;
  }

  public boolean addSubstituto(String codigo, String nome, double salario, String nivel, String titulacao, int cargaHoraria)
  {

    for(int i=0; i < this.funcionarios.length; i++)
    {

      if(this.funcionarios[i] == null)
      {

        this.funcionarios[i] = new Substituto(codigo, nome, salario, nivel, titulacao, cargaHoraria);
        return true;
      
      }
      
    }

    return false;
  }



  public boolean removeFuncionario(String codigoFuncionario)
  {
    for (int i = 0; i < this.funcionarios.length; i++)
    {
      if (this.funcionarios[i] != null &&
          this.funcionarios[i].getCodigo().equals(codigoFuncionario))
      {
        int j;

        for (j = i; j + 1 < this.funcionarios.length; j++)
        {
          this.funcionarios[j] = this.funcionarios[j+1];
        }

        this.funcionarios[j] = null;

        return true;
      }
    }

    return false;
  }

}
