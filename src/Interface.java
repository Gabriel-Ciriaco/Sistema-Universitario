import java.util.ArrayList;

import com.departamento.Departamento;
import com.funcionario.Funcionario;
import com.funcionario.docente.Substituto;

public class Interface {

    private Controlador controladorSistema;

    public Interface()
    {

    }

    public void criarDepartamento(String codigo, String nome, int numFuncionarios)
    {
        if(this.controladorSistema.existeDepartamento(codigo))
        {
            System.out.println("Esse departamento ja existe!");
        }else{

            if(this.controladorSistema.criarDepartamento(codigo, nome, numFuncionarios))
            {
                System.out.println("Departamento criado com sucesso!");       
            }else{

                System.out.println("Nao foi possivel criar o departamento!");
            }
        }
    }

    public void criarTecnico(String codigo, String nome, double salario, String nivel, String funcao, String codigoDepartamento)
    {

      if(this.controladorSistema.criarTecnico(codigo, nome, salario, nivel, funcao, codigoDepartamento))
      {

        System.out.println("Funcionario tecnico criado com sucesso!");
      
      }else{

        System.out.println("Nao foi possivel criar o funcionario tecnico!");

      }
      
    }

    public void criarEfetivo(String codigo, String nome, double salario, String nivel, String titulacao, String area, String codigoDepartamento)
    {

      if(this.controladorSistema.criarEfetivo(codigo, nome, salario, nivel, titulacao, area, codigoDepartamento))
      {

        System.out.println("Docente efetivo criado com sucesso!");

      }else{

        System.out.println("Nao foi possivel criar o docente efetivo!");
      }

    }

    public void criarSubstituto(String codigo, String nome, double salario, String nivel, String titulacao, int cargaHoraria, String codigoDepartamento)
    {
      
      if(this.controladorSistema.criarSubstituto(codigo, nome, salario, nivel, titulacao, cargaHoraria, codigoDepartamento))
      {
       
        System.out.println("Docente substituto criado com sucesso!");

      }else{

        System.out.println("Nao foi possivel criar o docente substituto!");

      }

    }

    public void exibirDocentesSubstitutos()
    {
      ArrayList<Substituto> docentesSubstitutos = new ArrayList<>();

      docentesSubstitutos = this.controladorSistema.exibirDocentesSubstitutos();

      if(docentesSubstitutos != null)
      {

        for(int i=0; i < docentesSubstitutos.size(); i++)
        {
          System.out.println("Nome: " + docentesSubstitutos.get(i).getNome());
          System.out.println("Codigo: " + docentesSubstitutos.get(i).getCodigo());
          System.out.println("Salario: " + docentesSubstitutos.get(i).calcularSalario());
          System.out.println("Nivel: " + docentesSubstitutos.get(i).getNivel());
          System.out.println("Titulacao: " + docentesSubstitutos.get(i).getTitulacao());
          System.out.println("Carga horaria: " + docentesSubstitutos.get(i).getCargaHoraria());
          System.out.println();

        }
      
      }else{

        System.out.println("Nenhum docente substituto foi encontrado!");

      }

    }

    public void exibirInformacoesDepartamento(String codigo)
    {
      Departamento departamento = this.controladorSistema.exibirInformacoesDepartamento(codigo);

      if(departamento != null)
      {
        System.out.println("=== INFORMACOES SOBRE O DEPARTAMENTO ===");
        System.out.println("Nome: " + departamento.getNome());
        System.out.println("Codigo: " + departamento.getCodigo());

        System.out.println("=== FUNCIONARIOS DO DEPARTAMENTO ===");
        Funcionario funcionarios[] = departamento.getFuncionarios();

        if(funcionarios != null)
        {
          double gastoTotal = 0;

          for(int i=0; i < funcionarios.length; i++)
          {
            System.out.println("Nome: " + funcionarios[i].getNome());
            System.out.println("Codigo: " + funcionarios[i].getCodigo());
            System.out.println("Tipo: " + funcionarios[i].getClass().getSimpleName());
            System.out.println("Nivel: " + funcionarios[i].getNivel());
            System.out.println("Salario: " + funcionarios[i].calcularSalario());
            gastoTotal += funcionarios[i].calcularSalario();
            System.out.println();
            
          }

          System.out.println("=== GASTO TOTAL COM FUNCIONARIOS ===");
          System.out.println("Gasto: " + gastoTotal);
        
        }else{

          System.out.println("Nao existe nenhum funcionario neste departamento!");
        }

      }else{

        System.out.println("Departamento nao encontrado!");

      }

    }

    public void buscarFuncionarioPorCodigo(String codigo)
    {

      Funcionario funcionario = this.controladorSistema.buscarFuncionarioPorCodigo(codigo);

      if(funcionario != null)
      {

        System.out.println("=== INFORMACOES DO FUNCIONARIO ===");
        System.out.println("Nome: " + funcionario.getNome());
        System.out.println("Codigo: " + funcionario.getCodigo());
        System.out.println("Tipo: " + funcionario.getClass().getSimpleName());
        System.out.println("Nivel: " + funcionario.getNivel());
        System.out.println("Salario: " + funcionario.calcularSalario());

      }else{

        System.out.println("Funcionario nao encontrado!");

      }

    }

    public void buscarFuncionarioPeloNome(String nome)
    {

      Funcionario funcionario = this.controladorSistema.buscarFuncionarioPeloNome(nome);

      if(funcionario != null)
      {

        System.out.println("=== INFORMACOES DO FUNCIONARIO ===");
        System.out.println("Nome: " + funcionario.getNome());
        System.out.println("Codigo: " + funcionario.getCodigo());
        System.out.println("Tipo: " + funcionario.getClass().getSimpleName());
        System.out.println("Nivel: " + funcionario.getNivel());
        System.out.println("Salario: " + funcionario.calcularSalario());

      }else{

        System.out.println("Funcionario nao encontrado!");

      }
      
    }


}
