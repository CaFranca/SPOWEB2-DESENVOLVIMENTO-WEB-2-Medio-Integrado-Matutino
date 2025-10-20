package Inventario;

import java.util.Scanner;

public class ProductTester {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int tempNumber, tempQty;
        double tempPrice;
        String tempName;

        // Entrada de dados para p1
        System.out.println("=== Cadastro do Produto 1 ===");
        System.out.print("Digite o número do item: ");
        tempNumber = in.nextInt();
        in.nextLine(); // Limpar buffer
        System.out.print("Digite o nome do produto: ");
        tempName = in.nextLine();
        System.out.print("Digite a quantidade em estoque: ");
        tempQty = in.nextInt();
        System.out.print("Digite o preço: ");
        tempPrice = in.nextDouble();

        Produto p1 = new Produto(tempNumber, tempName, tempQty, tempPrice);

        // Entrada de dados para p2
        System.out.println("=== Cadastro do Produto 2 ===");
        System.out.print("Digite o número do item: ");
        tempNumber = in.nextInt();
        in.nextLine();
        System.out.print("Digite o nome do produto: ");
        tempName = in.nextLine();
        System.out.print("Digite a quantidade em estoque: ");
        tempQty = in.nextInt();
        System.out.print("Digite o preço: ");
        tempPrice = in.nextDouble();

        Produto p2 = new Produto(tempNumber, tempName, tempQty, tempPrice);

        // Produtos fixos (como na Seção 4)
        Produto p3 = new Produto(3, "CD - Rock Classics", 30, 12.50);
        Produto p4 = new Produto(4, "DVD - Interestelar", 10, 24.90);
        Produto p5 = new Produto(5, "CD - Pop Legends", 20, 14.00);
        Produto p6 = new Produto(6, "DVD - The Godfather", 8, 22.50);

        // Tornando p6 descontinuado
        p6.setAtivo(false);

        in.close();

        // Exibir todos os produtos
        System.out.println("\n===== RELATÓRIO DO INVENTÁRIO =====");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
        System.out.println(p5);
        System.out.println(p6);
    }
}
