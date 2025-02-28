package br.com.fiap.fintech.model;

public class Pagamento extends FinanceiroMovimento {

    public Pagamento() {
        super();
    }

    public Pagamento(String usuario, String categoria, double valor, String data, String descricao) {
        super(usuario, categoria, valor, data, descricao);
    }

    @Override
    public String getMovimento() {
        return "Dados pagamento "
                + "\nCategoria: " + this.getCategoria()
                + "\nDescrição: " + this.getDescricao()
                + "\nData: " + this.getData()
                + "\nValor: " + this.getValor()
                + "\nTipo: Pagamento";
    }

}
