package Inventario;

// Declarações de campo de instância
public class Produto {
    private int numeroItem;
    private String nome;
    private int quantidadeEstoque;
    private double preco;
    private boolean ativo = true;

    // Construtor padrão (sem parâmetros)
    public Produto() {
    }

    // Construtor com parâmetros
    public Produto(int numeroItem, String nome, int quantidadeEstoque, double preco) {
        this.numeroItem = numeroItem;
        this.nome = nome;
        this.quantidadeEstoque = quantidadeEstoque;
        this.preco = preco;
    }

    // Getters e Setters
    public int getNumeroItem() {
        return numeroItem;
    }

    public void setNumeroItem(int numeroItem) {
        this.numeroItem = numeroItem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    // Getter e Setter para o campo ativo
    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    // Método para calcular o valor do inventário
    public double getInventoryValue() {
        return preco * quantidadeEstoque;
    }

    // Sobrescrita do método toString() atualizado com Status e Valor do Estoque
    @Override
    public String toString() {
        return "Número do Item       : " + numeroItem + "\n" +
                "Nome                 : " + nome + "\n" +
                "Quantidade em estoque: " + quantidadeEstoque + "\n" +
                "Preço                : " + preco + "\n" +
                "Valor do Estoque     : " + getInventoryValue() + "\n" +
                "Status do Produto    : " + (ativo ? "Ativo" : "Descontinuado") + "\n";
    }
}