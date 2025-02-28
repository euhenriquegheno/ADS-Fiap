//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String[] produtosEstoque = {"Notebook", "Celular", "Tablet", "Fones de ouvido", "Carregador portatil"};
        String produtoProcurado = "Tablet";

        boolean produtoEncontrado = false;
        var i = 0;

        while (!produtoEncontrado && i < produtosEstoque.length) {
            if (produtosEstoque[i].equals(produtoProcurado)) {
                produtoEncontrado = true;
            }
            i++;
        }

        if (produtoEncontrado) {
            System.out.println(produtoProcurado + " está disponível no estoque.");
        } else {
            System.out.println(produtoProcurado + " não foi encontrado no estoque.");
        }
    }
}