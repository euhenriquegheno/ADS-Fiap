package br.com.fiap.game.model;

public class PersonagemMagico {

    //Atributos
    private String nome;
    private String poderMagico;
    private int nivelEnergia;

    private HabilidadeEspecial habilidade;

    public PersonagemMagico() {}

    public PersonagemMagico(String nome) {
        this.nome = nome;
    }

    // Método que realiza um ataque
    public void atacar(String ataque) {
        if (nivelEnergia >= 10) {
            System.out.println(nome + " realizou um ataque: " + ataque + "!");
            nivelEnergia -= 10;
        } else {
            System.out.println(nome + " está sem energia para atacar.");
        }
    }

    // Método que aumenta e retorna o nível de energia
    public int aumentarEnergia(int energia){
        nivelEnergia = nivelEnergia + energia;
        return nivelEnergia;
    }

    public void ativarHabilidadeEspecial(){
        if (!habilidade.isHabilitada()){
            System.out.println("Habilidade especial não está ativada");
        } else if (nivelEnergia >= habilidade.getCustoEnergia()){
            System.out.println("Ativando a habilidade: " + habilidade.getNome());
            nivelEnergia -= habilidade.getCustoEnergia();
        } else {
            System.out.println(nome + "está sem energia para a habilidade especial");
        }
    }

    // Método que retorna os detalhes do personagem
    public void exibirDetalhes() {
        System.out.println(nome + " Poder Mágico: " + poderMagico + " Nível de Energia: " + nivelEnergia);
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public String getPoderMagico() {
        return poderMagico;
    }

    public void setPoderMagico(String poderMagico) {
        this.poderMagico = poderMagico;
    }

    public int getNivelEnergia() {
        return nivelEnergia;
    }

    public void setNivelEnergia(int nivelEnergia) {
        this.nivelEnergia = nivelEnergia;
    }

    public HabilidadeEspecial getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(HabilidadeEspecial habilidade) {
        this.habilidade = habilidade;
    }
}