

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
}
