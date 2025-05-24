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
        switch (this.getNivel()) {
            case "D1":
            return getSalario() * (1 + ConstantesSistema.D1);

            case "D2":
            return getSalario() * (1 + ConstantesSistema.D2);

            case "D3":
            return getSalario() + (1 + ConstantesSistema.D3);

            default:
            return getSalario();
        }
    }

}
