import com.departamento.Departamento;
import com.funcionario.Tecnico;
import com.funcionario.docente.Efetivo;
import com.funcionario.docente.Substituto;
import com.universidade.Universidade;
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

    public void criarEfetivo(String codigo, String nome, double salario, String nivel, String titulacao, String area, String codigoDepartamento)
    {
        Departamento departamento = universidade.getDepartamentoPorCodigo(codigoDepartamento);

        if(departamento != null)
        {

            Efetivo novoEfetivo = new Efetivo(codigo, nome, salario, nivel, titulacao, area);

            if(departamento.addFuncionario(novoEfetivo))
            {

                System.out.println("Docente efetivo adicionado com sucesso!");
                return;
            
            }else{

                System.out.println("Nao foi possivel adicionar o docente efetivo!");
                return;

            }

        }else{

            System.out.println("Departamento nao encontrado!");
            return;
        }
    }

    public void criarSubstituto(String codigo, String nome, double salario, String nivel, String titulacao, int cargaHoraria, String codigoDepartamento)
    {
        Departamento departamento = universidade.getDepartamentoPorCodigo(codigoDepartamento);

        if(departamento != null)
        {

            Substituto novSubstituto = new Substituto(codigo, nome, salario, nivel, titulacao, cargaHoraria);

            if(departamento.addFuncionario(novSubstituto))
            {
                System.out.println("Docente substituto adicionado com sucesso!");
                return;

            }else{

                System.out.println("Nao foi possivel adicionar o docente substituto!");
                return;
            }

        }else{

            System.out.println("Departamento nao encontrado!");
            return;
        }
    }

}
