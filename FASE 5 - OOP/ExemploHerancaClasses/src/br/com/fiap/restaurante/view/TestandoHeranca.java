package br.com.fiap.restaurante.view;

import br.com.fiap.restaurante.model.Bebida;
import br.com.fiap.restaurante.model.PratoQuente;

public class TestandoHeranca {

    public static void main(String[] args) {
        Bebida bebida = new Bebida("Suco de Laranja", "Água, laranja, açúcar, gelo", 7.25, 500);
        System.out.print("A bebida informada foi " + bebida.getNome());
        System.out.print(", é composta por " + bebida.getIngredientes());
        System.out.print(", custa R$" + bebida.getPreco());
        System.out.print(" e seu tamanho é de " + bebida.getQuantidade() + "ml");

        PratoQuente prato = new PratoQuente();
        prato.setNome("Omelete");
        prato.setIngredientes("Ovo, tomate, cebola e queijo");
        prato.setPreco(20.0);
        prato.setServe(2);
        System.out.print("Prato:");
        System.out.println("O prato informado foi " + prato.getNome());
        System.out.print(", é composta por " + prato.getIngredientes());
        System.out.print(", custa R$" + prato.getPreco());
        System.out.print(" e serve " + prato.getServe() + " pessoas");

        System.out.println(bebida.getResumo());
        System.out.println(prato.getResumo());
    }

}