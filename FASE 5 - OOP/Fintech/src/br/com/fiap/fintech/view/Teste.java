package br.com.fiap.fintech.view;

import br.com.fiap.fintech.model.Pagamento;
import br.com.fiap.fintech.model.Recebimento;
import br.com.fiap.fintech.model.Usuario;

public class Teste {

    public static void main(String[] args) {

        Usuario usuario = new Usuario();
        //Cria o usuário
        usuario.setNomeCompleto("Usuario teste");
        usuario.setEmail("teste@teste.com");
        usuario.setSenha("12345");
        usuario.setDataNascimento("04/06/2024");
        usuario.setGenero("Masculino");

        //Exibe o usuário cadastrado
        System.out.println(usuario.getUsuario());

        //Cria o registro de pagamento da conta
        Pagamento pagamento = new Pagamento();
        pagamento.setUsuario("Usuario teste");
        pagamento.setCategoria("Conta");
        pagamento.setDescricao("Pagamento da conta de Luz");
        pagamento.setValor(150);
        pagamento.setData("06/09/2024");

        //exibe o pagamento inserido
        System.out.println(pagamento.getMovimento());

        //Cria o registro de recebimento da conta
        Recebimento recebimento = new Recebimento();
        recebimento.setUsuario("Usuario teste");
        recebimento.setCategoria("Salario");
        recebimento.setDescricao("Recebimento de salário");
        recebimento.setValor(2650);
        recebimento.setData("05/09/2024");

        //exibe o pagamento inserido
        System.out.println(recebimento.getMovimento());

    }

}
