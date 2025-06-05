import java.util.ArrayList;

import com.departamento.Departamento;
import com.funcionario.Funcionario;
import com.funcionario.Tecnico;
import com.funcionario.docente.Docente;
import com.funcionario.docente.Efetivo;
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

    public void exibirFuncionario(Funcionario funcionario)
    {
      System.out.println("Tipo: " + funcionario.getClass().getSimpleName());
      System.out.println("Nome: " + funcionario.getNome());
      System.out.println("Código: " + funcionario.getCodigo());
      System.out.println("Salário: " + funcionario.calcularSalario());
      System.out.println("Nível: " + funcionario.getNivel());

    }

    public void exibirTecnico(Tecnico tecnico)
    {
      exibirFuncionario(tecnico);

      System.out.println("Função: " + tecnico.getFuncao());
    }

    public void exibirDocente(Docente docente)
    {
      exibirFuncionario(docente);
  
      System.out.println("Titulacao: " + docente.getTitulacao());
    }

    public void exibirDocenteSubstituto(Substituto substituto)
    {
      exibirDocente(substituto);

      System.out.println("Carga horaria: " + substituto.getCargaHoraria());
    }

    public void exibirDocenteEfetivo(Efetivo efetivo)
    {
      exibirDocente(efetivo);

      System.out.println("Área: " + efetivo.getArea());
    }

    public void exibirFuncionarios()
    {
      ArrayList<Funcionario> funcionarios = this.controladorSistema.exibirFuncionarios();

      if (!funcionarios.isEmpty())
      {
        for (int i = 0; i < funcionarios.size(); i++)
        {
          exibirFuncionario(funcionarios.get(i));

          System.out.println();
        }
      }
      else
      {
        System.out.println("Nenhum funcionário foi encontrado!");
      }

    }

    public void exibirTecnicos()
    {
      ArrayList<Tecnico> tecnicos = this.controladorSistema.exibirTecnicos();

      if (!tecnicos.isEmpty())
      {
        for (int i = 0; i < tecnicos.size(); i++)
        {
          exibirTecnico(tecnicos.get(i));

          System.out.println();
        }
      }
      else
      {
        System.out.println("Nenhum técnico foi encontrado!");
      }

    }

    public void exibirDocentes()
    {
      ArrayList<Docente> docentes = this.controladorSistema.exibirDocentes();

      if (!docentes.isEmpty())
      {
        for (int i = 0; i < docentes.size(); i++)
        {
          exibirDocente(docentes.get(i));

          System.out.println();
        }
      }
      else
      {
        System.out.println("Nenhum docente foi encontrado!");
      }
    }

    public void exibirDocentesEfetivos()
    {
      ArrayList<Efetivo> docentesEfetivos = this.controladorSistema.exibirDocentesEfetivos();

      if (!docentesEfetivos.isEmpty())
      {
        for (int i = 0; i < docentesEfetivos.size(); i++)
        {
          exibirDocenteEfetivo(docentesEfetivos.get(i));

          System.out.println();
        }
      }
      else
      {
        System.out.println("Nenhum docente efetivo foi encontrado!");
      }
    }


    public void exibirDocentesSubstitutos()
    {
      ArrayList<Substituto> docentesSubstitutos = new ArrayList<>();

      docentesSubstitutos = this.controladorSistema.exibirDocentesSubstitutos();

      if(!docentesSubstitutos.isEmpty())
      {

        for(int i=0; i < docentesSubstitutos.size(); i++)
        {
          exibirDocenteSubstituto(docentesSubstitutos.get(i));

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
            exibirFuncionario(funcionarios[i]);

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
       
        exibirFuncionario(funcionario);

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

        exibirFuncionario(funcionario);

      }else{

        System.out.println("Funcionario nao encontrado!");

      }
      
    }


}
