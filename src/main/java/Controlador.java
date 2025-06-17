import com.departamento.Departamento;
import com.funcionario.Funcionario;
import com.funcionario.Tecnico;
import com.funcionario.docente.Docente;
import com.funcionario.docente.Efetivo;
import com.funcionario.docente.Substituto;
import com.universidade.Universidade;

import java.util.ArrayList;

import com.ConstantesSistema;

public class Controlador {

    private Universidade universidade = new Universidade("FCT - Unesp", ConstantesSistema.numDepartamentos);

    public boolean existeDepartamento(String codigo)
    {
        return universidade.existeDepartamento(codigo);
    }

    public boolean criarDepartamento(String codigo, String nome, int numFuncionarios)
    {
        if (this.existeDepartamento(codigo))
        {
            return false;
        }
        else
        {
            return universidade.addDepartamento(codigo, nome, numFuncionarios);
        }
    }

    public boolean criarTecnico(String codigo, String nome, double salario, String nivel, String funcao, String codigoDepartamento)
    {
      
      Departamento departamento = universidade.getDepartamentoPorCodigo(codigoDepartamento);

      if(departamento == null)
      {

        return false;

      }else{

        return departamento.addTecnico(codigo, nome, salario, nivel, funcao);

      }
  
    }

    public boolean criarEfetivo(String codigo, String nome, double salario, String nivel, String titulacao, String area, String codigoDepartamento)
    {
        Departamento departamento = universidade.getDepartamentoPorCodigo(codigoDepartamento);

        if(departamento == null)
        {

            return false;

        }else{

            return departamento.addEfetivo(codigo, nome, salario, nivel, titulacao, area);

        }
    }

    public boolean criarSubstituto(String codigo, String nome, double salario, String nivel, String titulacao, int cargaHoraria, String codigoDepartamento)
    {
        Departamento departamento = universidade.getDepartamentoPorCodigo(codigoDepartamento);

        if(departamento == null)
        {

            return false;
           
        }else{

            return departamento.addSubstituto(codigoDepartamento, nome, salario, nivel, titulacao, cargaHoraria);
        }

    }

    public ArrayList<Funcionario> exibirFuncionarios()
    {
        return this.universidade.exibirFuncionarios();
    }    

    public ArrayList<Tecnico> exibirTecnicos()
    {
        return this.universidade.exibirTecnicos();
    }

    public ArrayList<Docente> exibirDocentes()
    {
        return this.universidade.exibirDocentes();
    }

    public ArrayList<Efetivo> exibirDocentesEfetivos()
    {
        return this.universidade.exibirDocentesEfetivos();
    }

    public ArrayList<Substituto> exibirDocentesSubstitutos()
    {
        return this.universidade.exibirDocentesSubstitutos();
    }

    public Departamento exibirInformacoesDepartamento(String codigo)
    {
        return this.universidade.getDepartamentoPorCodigo(codigo);
    }

    public Funcionario buscarFuncionarioPorCodigo(String codigo)
    {
        return this.universidade.buscarFuncionarioPorCodigo(codigo);
    }

    public Funcionario buscarFuncionarioPeloNome(String nome)
    {
        return this.universidade.buscarFuncionarioPeloNome(nome);
    }

}
