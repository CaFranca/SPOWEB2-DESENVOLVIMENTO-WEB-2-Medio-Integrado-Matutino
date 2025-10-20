package Inventario;

// Declarações de campo de instância
public class Produto {
    private int numeroItem;
    private String nome;
    private int quantidadeEstoque;
    private double preco;

    // Construtor padrão (sem parâmetros)
    // Este construtor permite que o Java inicialize os valores padrão dos campos
    public Produto() {
    }

    // Construtor sobrecarregado com parâmetros
    public Produto(int numeroItem, String nome, int quantidadeEstoque, double preco) {
        this.numeroItem = numeroItem;
        this.nome = nome;
        this.quantidadeEstoque = quantidadeEstoque;
        this.preco = preco;
    }

    // Métodos Getter/Accessor e Setter/Mutator para cada variável de instância
    // Esses métodos permitem acessar e modificar os valores dos campos privados

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

    // Sobrescrita do método toString() para exibir os dados do produto
    @Override
    public String toString() {
        return "Número do Item       : " + numeroItem + "\n" +
                "Nome                 : " + nome + "\n" +
                "Quantidade em estoque: " + quantidadeEstoque + "\n" +
                "Preço                : " + preco + "\n";
    }
}
