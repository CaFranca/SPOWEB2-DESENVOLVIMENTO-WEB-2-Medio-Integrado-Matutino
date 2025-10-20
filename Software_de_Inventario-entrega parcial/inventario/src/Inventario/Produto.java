package Inventario;

public class Produto {
    private int numeroItem;
    private String nomeProduto;
    private int unidadesEstoque;
    private double preco;
    private boolean ativo;

    public Produto() {
        this.numeroItem = 0;
        this.nomeProduto = "";
        this.unidadesEstoque = 0;
        this.preco = 0.0;
        this.ativo = true;
    }

    public Produto(int numeroItem, String nomeProduto, int unidadesEstoque, double preco) {
        this.numeroItem = numeroItem;
        this.nomeProduto = nomeProduto;
        this.unidadesEstoque = unidadesEstoque;
        this.preco = preco;
        this.ativo = true;
    }

    public int getNumeroItem() {
        return numeroItem;
    }

    public void setNumeroItem(int numeroItem) {
        this.numeroItem = numeroItem;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getUnidadesEstoque() {
        return unidadesEstoque;
    }

    public void setUnidadesEstoque(int unidadesEstoque) {
        this.unidadesEstoque = unidadesEstoque;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public void adicionarEstoque(int quantidade) {
        if (quantidade >= 0) {
            this.unidadesEstoque += quantidade;
        }
    }

    public void deduzirEstoque(int quantidade) {
        if (quantidade >= 0 && quantidade <= this.unidadesEstoque) {
            this.unidadesEstoque -= quantidade;
        }
    }

    @Override
    public String toString() {
        return "Número do Item: " + numeroItem +
                "\nNome do Produto: " + nomeProduto +
                "\nUnidades em Estoque: " + unidadesEstoque +
                "\nPreço: R$" + preco +
                "\nAtivo: " + (ativo ? "Sim" : "Não") +
                "\n";
    }
}