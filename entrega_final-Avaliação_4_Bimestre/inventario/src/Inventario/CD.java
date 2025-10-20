package Inventario;

public class CD extends Produto {
    private String artista;
    private int numeroMusicas;
    private String selo;

    public CD(int numeroItem, String nomeProduto, int unidadesEstoque, double preco,
              String artista, int numeroMusicas, String selo) {
        super(numeroItem, nomeProduto, unidadesEstoque, preco);
        this.artista = artista;
        this.numeroMusicas = numeroMusicas;
        this.selo = selo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getNumeroMusicas() {
        return numeroMusicas;
    }

    public void setNumeroMusicas(int numeroMusicas) {
        this.numeroMusicas = numeroMusicas;
    }

    public String getSelo() {
        return selo;
    }

    public void setSelo(String selo) {
        this.selo = selo;
    }

    @Override
    public String toString() {
        return "Número do Item: " + getNumeroItem() +
                "\nNome: " + getNomeProduto() +
                "\nArtista: " + artista +
                "\nMúsicas do Álbum: " + numeroMusicas +
                "\nSelo de gravação: " + selo +
                "\nQuantidade em estoque: " + getUnidadesEstoque() +
                "\nPreço: " + getPreco() +
                "\nValor do Estoque: " + calcularValorEstoque() +
                "\nStatus do Produto: " + (isAtivo() ? "Ativo" : "Descontinuado");
    }
}