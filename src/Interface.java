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


}
