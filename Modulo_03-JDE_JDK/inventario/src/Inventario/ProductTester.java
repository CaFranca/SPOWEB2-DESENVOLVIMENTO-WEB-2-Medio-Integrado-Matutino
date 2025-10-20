package Inventario;

public class ProductTester {
    public static void main(String[] args) {

        // Dois produtos com construtor padrão
        Produto p1 = new Produto();
        Produto p2 = new Produto();

        // Definindo valores manualmente com setters
        p1.setNumeroItem(1);
        p1.setNome("CD - Greatest Hits");
        p1.setQuantidadeEstoque(25);
        p1.setPreco(9.99);

        p2.setNumeroItem(2);
        p2.setNome("DVD - Matrix");
        p2.setQuantidadeEstoque(12);
        p2.setPreco(19.90);

        // Quatro produtos com construtor completo
        Produto p3 = new Produto(3, "CD - Rock Classics", 30, 12.50);
        Produto p4 = new Produto(4, "DVD - Interestelar", 10, 24.90);
        Produto p5 = new Produto(5, "CD - Pop Legends", 20, 14.00);
        Produto p6 = new Produto(6, "DVD - The Godfather", 8, 22.50);

        // Exibindo todos os produtos
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
        System.out.println(p5);
        System.out.println(p6);
    }
}
