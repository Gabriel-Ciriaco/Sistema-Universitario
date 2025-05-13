package com.funcionario.docente;

import com.ConstantesSistema;

public class Substituto extends Docente {

    int cargaHoraria;

    public Substituto(String codigo, String nome, double salario, String nivel, String titulacao, int cargaHoraria) 
    {
        super(codigo, nome, salario, nivel, titulacao);
        this.cargaHoraria = cargaHoraria;
    }

    public int getCargaHoraria() 
    {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) 
    {
        this.cargaHoraria = cargaHoraria;
    }

    public double calcularSalario()
    {
      return getSalario() + (getSalario() * ConstantesSistema.adicionalSubstituto(getNivel()));
    }

}
