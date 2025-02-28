import br.com.fiap.loja.model.Cliente;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        Cliente cliente = new Cliente();
        cliente.setNome("Henrique");
        cliente.setCpf("03640033086");
        cliente.exibirDados();
        System.out.println(cliente.getCpf());
    }

}