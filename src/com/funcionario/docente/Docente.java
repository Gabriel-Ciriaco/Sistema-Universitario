package com.funcionario.docente;

import com.funcionario.Funcionario;


public abstract class Docente extends Funcionario {

    String titulacao;

    
    public Docente(String codigo, String nome, double salario, String nivel, String titulacao) 
    {
        super(codigo, nome, salario, nivel);
        this.titulacao = titulacao;
    }

    public String getTitulacao() 
    {
        return titulacao;
    }

    public void setTitulacao(String titulacao) 
    {
        this.titulacao = titulacao;
    }

    public abstract double calcularSalario();


}
