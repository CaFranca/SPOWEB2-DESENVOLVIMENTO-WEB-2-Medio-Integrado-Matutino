package Inventario;

public class DVD extends Produto {
    private int duracaoMinutos;
    private String classificacaoEtaria;
    private String estudioCinematografico;

    public DVD(int numeroItem, String nomeProduto, int unidadesEstoque, double preco,
               int duracaoMinutos, String classificacaoEtaria, String estudioCinematografico) {
        super(numeroItem, nomeProduto, unidadesEstoque, preco);
        this.duracaoMinutos = duracaoMinutos;
        this.classificacaoEtaria = classificacaoEtaria;
        this.estudioCinematografico = estudioCinematografico;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }

    public String getClassificacaoEtaria() {
        return classificacaoEtaria;
    }

    public void setClassificacaoEtaria(String classificacaoEtaria) {
        this.classificacaoEtaria = classificacaoEtaria;
    }

    public String getEstudioCinematografico() {
        return estudioCinematografico;
    }

    public void setEstudioCinematografico(String estudioCinematografico) {
        this.estudioCinematografico = estudioCinematografico;
    }

    @Override
    public double calcularValorEstoque() {
        double valorBase = super.calcularValorEstoque();
        double taxaReposicao = valorBase * 0.05;
        return valorBase + taxaReposicao;
    }

    @Override
    public String toString() {
        return "Número do Item: " + getNumeroItem() +
                "\nNome: " + getNomeProduto() +
                "\nDuração do Filme: " + duracaoMinutos +
                "\nClassificação Etária: " + classificacaoEtaria +
                "\nEstúdio Cinematográfico: " + estudioCinematografico +
                "\nQuantidade em estoque: " + getUnidadesEstoque() +
                "\nPreço: " + getPreco() +
                "\nValor do Estoque: " + calcularValorEstoque() +
                "\nStatus do Produto: " + (isAtivo() ? "Ativo" : "Descontinuado");
    }
}