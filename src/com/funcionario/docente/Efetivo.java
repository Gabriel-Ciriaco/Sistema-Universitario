package com.funcionario.docente;

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
        double adicional;

        if(getNivel().equals("D1"))
        {
            adicional = 0.05;
        
        }else if(getNivel().equals("D2")){

            adicional = 0.1;

        }else{

            adicional = 0.2;
        }

        return getSalario() + (getSalario() * adicional);

    }

}
