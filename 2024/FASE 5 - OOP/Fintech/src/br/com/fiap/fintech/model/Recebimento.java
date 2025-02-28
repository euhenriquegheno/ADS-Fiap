package br.com.fiap.fintech.model;

public class Recebimento extends FinanceiroMovimento {

    public Recebimento() {
        super();
    }

    public Recebimento(String usuario, String categoria, double valor, String data, String descricao) {
        super(usuario, categoria, valor, data, descricao);
    }

    @Override
    public String getMovimento() {
        return "Dados do recebimento"
                + "\nCategoria: " + this.getCategoria()
                + "\nDescrição: " + this.getDescricao()
                + "\nData: " + this.getData()
                + "\nValor: " + this.getValor()
                + "\nTipo: Recebimento";
    }

}
