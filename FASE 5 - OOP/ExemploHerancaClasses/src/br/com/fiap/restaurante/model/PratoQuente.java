package br.com.fiap.restaurante.model;

//Aqui inicia a subclasse br.com.fiap.restaurante.model.PratoQuente
//que herda da superclasse br.com.fiap.restaurante.model.Produto
public class PratoQuente extends Produto {
    //A subclasse tem um atributo a mais do
    //que a super classe
    private int serve;

    //A subclasse tem seus próprios construtores
    public PratoQuente() {
        super();
    }
    public PratoQuente(String nome, String ingredientes, double preco, int serve) {
        //abaixo, invocamos o construtor da superclasse
        //para atribuir o nome, os ingredientes e
        //o preço do prato quente
        super(nome, ingredientes, preco);
        //como o construtor da superclasse não possui serve,
        //essa atribuição é feita separadamente
        this.serve = serve;
    }

    //Os métodos da superclasse já foram herdados,
    //portanto, bastou criar os métodos exclusivos
    //da subclasse
    public int getServe() {
        return serve;
    }
    public void setServe(int serve) {
        this.serve = serve;
    }

    //A superclasse nos obriga a criar
    //um método chamado getResumo() que retorne uma String
    @Override
    public String getResumo() {
        return "Nome: " + this.getNome() +
        "Ingredientes: " + this.getIngredientes() +
        "Preco: R$" + this.getPreco() +
        "Serve: " + this.getServe() + " pessoas";
    }
}