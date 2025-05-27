

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
}
