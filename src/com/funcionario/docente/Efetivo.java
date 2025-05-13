package com.funcionario.docente;

import com.ConstantesSistema;

public class Efetivo extends Docente {

    String area;

    public Efetivo(String codigo, String nome, double salario, String nivel, String titulacao, String area) 
    {
        super(codigo, nome, salario, nivel, titulacao);
        this.area = area;
    }

    public String getArea() 
    {
        return area;
    }

    public void setArea(String area) 
    {
        this.area = area;
    }

    public double calcularSalario()
    {
      return getSalario() + (getSalario() * ConstantesSistema.adicionalEfetivo(getNivel()));
    }

}
