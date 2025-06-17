

public class Main {
    
    public static void main(String[] args)
    {
       Controlador controladorSistema = new Controlador();
       
       TelaPrincipal novaTela = new TelaPrincipal(controladorSistema);
       
       novaTela.setVisible(true);
    }
}
