package com.universidade;

import com.departamento.Departamento;

import com.funcionario.Funcionario;
import com.funcionario.Tecnico;
import com.funcionario.docente.Docente;
import com.funcionario.docente.Efetivo;
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

    this.contadorDepartamentos = 0;
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
  
  public int getContadorDepartamentos()
  {
      return this.contadorDepartamentos;
  }

  public Departamento getDepartamentoPorCodigo(String codigo)
  {
    for(int i=0; i<this.contadorDepartamentos; i++)
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
    for(int i = 0; i < this.contadorDepartamentos; i++)
    {
      if(this.departamentos[i].getCodigo().equals(codigoDepartamento))
      {
        return true;
      }
    }

    return false;

  }
  
  public ArrayList<Departamento> relatorioGeral()
  {
      ArrayList<Departamento> departamentos = new ArrayList<Departamento>();
      
      for (int i = 0; i < this.contadorDepartamentos; i++)
      {
          Departamento d = this.departamentos[i];
          
          departamentos.add(d);
      }
      
      return departamentos;
  }
  
  public ArrayList<Departamento> resumoDepartamento()
  {
      ArrayList<Departamento> departamentos = new ArrayList<Departamento>();

      for (int i = 0; i < this.contadorDepartamentos; i++)
      {
          Departamento d = this.departamentos[i];
          
          departamentos.add(d);
      }
      
      return departamentos;
  }
  
  public ArrayList<Departamento> resumoDepartamentosMinMax(double min, double max)
  {
      ArrayList<Departamento> departamentos = new ArrayList<Departamento>();

      for (int i = 0; i < this.contadorDepartamentos; i++)
      {
          Departamento d = this.departamentos[i];
          
          if (d.getGasto() >= min && d.getGasto() <= max)
          {
              departamentos.add(d);
          }
      }
      
      return departamentos;
  }
 
  public ArrayList<Funcionario> funcionarioMinMax(double min, double max)
  {
      ArrayList<Funcionario> funcionariosFaixa = new ArrayList<Funcionario>();
      
      for (int i = 0; i < this.contadorDepartamentos; i++)
      {
          Departamento d = this.departamentos[i];
          
          Funcionario[] funcionarios = d.getFuncionarios();

          for (int j = 0; j < d.getQtdFuncionarios(); j++)
          {
              Funcionario f = funcionarios[j];
              
              double salario = f.calcularSalario();
              
              if (salario >= min && salario <= max)
              {
                  funcionariosFaixa.add(funcionarios[j]);
              }
          }
      }
      
      return funcionariosFaixa;
  }

  public ArrayList<Funcionario> exibirFuncionarios()
  {
    ArrayList<Funcionario> todosFuncionarios = new ArrayList<Funcionario>();

    for (int i = 0; i < this.contadorDepartamentos; i++)
    {
      Funcionario[] funcionarios = this.departamentos[i].getFuncionarios();

      for (int j = 0; j < funcionarios.length; j++)
      {
        todosFuncionarios.add(funcionarios[i]);
      }

    }

    return todosFuncionarios;
  }

  public ArrayList<Tecnico> exibirTecnicos()
  {
    ArrayList<Tecnico> tecnicos = new ArrayList<Tecnico>();

    for (int i = 0; i < this.contadorDepartamentos; i++)
    {
      Funcionario[] funcionarios = this.departamentos[i].getFuncionarios();

      for (int j = 0; j < funcionarios.length; j++)
      {
        if (funcionarios[j] instanceof Tecnico)
        {
          tecnicos.add((Tecnico) funcionarios[j]);
        }
      }
    }

    return tecnicos;
  }

  public ArrayList<Docente> exibirDocentes()
  {
    ArrayList<Docente> docentes = new ArrayList<Docente>();

    for (int i = 0; i < this.contadorDepartamentos; i++)
    {
      Funcionario[] funcionarios = this.departamentos[i].getFuncionarios();

      for (int j = 0; j < funcionarios.length; j++)
      {
        if (funcionarios[j] instanceof Docente)
        {
          docentes.add((Docente) funcionarios[j]);
        }
      }
    }

    return docentes;
  }

  public ArrayList<Efetivo> exibirDocentesEfetivos()
  {
    ArrayList<Efetivo> efetivos = new ArrayList<Efetivo>();

    for (int i = 0; i < this.contadorDepartamentos; i++)
    {
      Funcionario[] funcionarios = this.departamentos[i].getFuncionarios();

      for (int j = 0; j < funcionarios.length; j++)
      {
        if (funcionarios[j] instanceof Efetivo)
        {
          efetivos.add((Efetivo) funcionarios[j]);
        }
      }
    }

    return efetivos;
  }

  public ArrayList<Substituto> exibirDocentesSubstitutos()
  {
      ArrayList<Substituto> docentesSubstitutos = new ArrayList<>();

      for(int i=0; i < contadorDepartamentos; i++)
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

    for(int i=0; i < contadorDepartamentos; i++)
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

    for(int i=0; i < contadorDepartamentos; i++)
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
