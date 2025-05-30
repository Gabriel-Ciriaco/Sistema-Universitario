package com.universidade;

import com.departamento.Departamento;
import com.funcionario.Funcionario;
import com.funcionario.docente.Substituto;

import java.util.ArrayList;



public class Universidade {
  private String nome;
  private Departamento[] departamentos;
  private int contadorDepartamentos;
  private int maxDepartamentos;

  public Universidade(String nome, int numDepartamentos)
  {
    this.nome = nome;

    this.maxDepartamentos = numDepartamentos;
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

  public boolean addDepartamento(String codigo, String nome, int numFuncionarios)
  {
    if(this.contadorDepartamentos < this.maxDepartamentos)
    {
      this.departamentos[this.contadorDepartamentos++] = new Departamento(codigo, nome, numFuncionarios);
      return true;
    }

    return false;
  }

  public boolean removeDepartamento(String codigoDepartamento)
  {
    for (int i = 0; i < this.contadorDepartamentos; i++)
    {
      if (this.departamentos[i].getCodigo().equals(codigoDepartamento))
        {
          int j;

          for (j = i; j + 1 < this.contadorDepartamentos; j++)
          {
            this.departamentos[j] = this.departamentos[j + 1];
          }

          this.departamentos[j] = null;

          this.contadorDepartamentos--;

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

  public ArrayList<Substituto> exibirDocentesSubstitutos()
  {
      ArrayList<Substituto> docentesSubstitutos = new ArrayList<>();

      for(int i=0; i < departamentos.length; i++)
      {

        Departamento departamento = departamentos[i];

        Funcionario[] funcionarios = departamento.getFuncionarios();

        if(funcionarios != null)
        {

          for(int j=0; j < funcionarios.length; j++)
          {

            if(funcionarios[j] instanceof Substituto)
            {

              docentesSubstitutos.add((Substituto) funcionarios[j]);
            
            }

          }

        }

      }

      return docentesSubstitutos;
  }

  public Funcionario buscarFuncionarioPorCodigo(String codigo)
  {

    for(int i=0; i < departamentos.length; i++)
    {

      Funcionario funcionarios[] = departamentos[i].getFuncionarios();

      if(funcionarios != null)
      {

        for(int j=0; j < funcionarios.length; j++)
        {

          if(funcionarios[j].getCodigo().equals(codigo))
          {

            return funcionarios[j];

          }

        }

      }

    }

    return null;

  }

  public Funcionario buscarFuncionarioPeloNome(String nome)
  {

    for(int i=0; i < departamentos.length; i++)
    {

      Funcionario funcionarios[] = departamentos[i].getFuncionarios();

      if(funcionarios != null)
      {

         for(int j=0; j < funcionarios.length; j++)
        {

          if(funcionarios[j].getNome().equals(nome))
          {

            return funcionarios[j];
          }

        }

      }
     
    }

    return null;
    
  }
  


}
