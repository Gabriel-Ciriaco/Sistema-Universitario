package com.funcionario.docente;


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
        double adicional;

        if(getNivel().equals("S1"))
        {
            adicional = 0.05;
        
        }else{

            adicional = 0.1;

        }

        return getSalario() + (getSalario() * adicional);
    }

    
}
