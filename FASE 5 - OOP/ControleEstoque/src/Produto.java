public class Produto {
    String nome;
    double preco;
    int quantidade;

    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public Produto(){}

    public void exibirInformacoes() {
        System.out.println("Nome do produto: " + nome);
        System.out.println("Preço R$: " + preco);
        System.out.println("Quantidade em estoque: " + quantidade);
    }

    public void vender(int quantidadeComprada) {
        int totalEstoque = quantidade - quantidadeComprada;
        if (totalEstoque < 0) {
            System.out.println("Sem estoque suficiente!");
        } else {
            quantidade = totalEstoque;
        }
    }

    public void adicionarEstoque(int quantidadeAdicional) {
        if (quantidadeAdicional > 0) {
            quantidade = +quantidadeAdicional;
        } else {
            System.out.println("Quantidade informada é invalida!");
        }
    }

    public void aplicarDesconto(double percentual) {
        double descontoReais = preco * (percentual / 100);
        preco -= descontoReais;
    }
}
