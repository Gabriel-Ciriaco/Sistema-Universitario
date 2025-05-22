package com.universidade;

import com.departamento.Departamento;


public class Universidade {
  private String nome;
  private Departamento[] departamentos;

  public Universidade(String nome, int numDepartamentos)
  {
    this.nome = nome;
    this.departamentos = new Departamento[numDepartamentos];
  }

  public String getNome()
  {
    return this.nome;
  }

  public void setNome(String nome)
  {
    this.nome = nome;
  }

  public Departamento[] getDepartamentos()
  {
    return this.departamentos;
  }

  public Departamento getDepartamentoPorCodigo(String codigo)
  {
    for(int i=0; i<departamentos.length; i++)
    {
      if(departamentos[i].getCodigo().equals(codigo))
      {
        return departamentos[i];
      }
    }

    return null;
  }

  public boolean addDepartamento(Departamento departamento)
  {
    for (int i = 0; i < this.departamentos.length; i++)
    {
      if (this.departamentos[i] == null)
      {
        this.departamentos[i] = departamento;

        return true;
      }
    }

    return false;
  }

  public boolean removeDepartamento(String codigoDepartamento)
  {
    for (int i = 0; i < this.departamentos.length; i++)
    {
      if (this.departamentos[i] != null &&
          this.departamentos[i].getCodigo().equals(codigoDepartamento))
        {
          int j;

          for (j = i; j + 1 < this.departamentos.length; j++)
          {
            this.departamentos[j] = this.departamentos[j + 1];
          }

          this.departamentos[j] = null;

          return true;
        }
    }

    return false;
  }

  public boolean existeDepartamento(String codigoDepartamento)
  {
    for(int i = 0; i < this.departamentos.length; i++)
    {
      if(this.departamentos[i] != null && this.departamentos[i].getCodigo().equals(codigoDepartamento))
      {
        return true;
      }
    }

    return false;

  }


}
