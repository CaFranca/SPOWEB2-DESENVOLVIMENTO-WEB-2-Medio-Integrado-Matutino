package Inventario;

import java.util.Scanner;
import java.util.InputMismatchException;

public class ProductTester {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int maxSize = -1; // Valor inicial que falha no loop

        System.out.println("=== SISTEMA DE INVENTÁRIO ===");

        // PASSO 2c: Loop do-while para entrada do usuário
        do {
            // PASSO 3a: Bloco try envolvendo todo o código dentro do loop
            try {
                // PASSO 2b: Prompt para o usuário
                System.out.println("\nInsira o número de produtos que gostaria de adicionar");
                System.out.println("Insira 0 (zero) se não quiser adicionar produtos:");

                maxSize = in.nextInt();

                // PASSO 2c: Validação de valor negativo
                if (maxSize < 0) {
                    System.out.println("Valor incorreto inserido!");
                }

            }
            // PASSO 3f: Captura específica para InputMismatchException
            catch (InputMismatchException e) {
                System.out.println("Tipo incorrecto de dados inserido!");
                in.nextLine(); // PASSO 3e: Esvazia o buffer de entrada
                maxSize = -1; // Mantém o valor que falha no loop
            }
            // PASSO 3b: Captura genérica para Exception
            catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
                in.nextLine(); // PASSO 3e: Esvazia o buffer de entrada
                maxSize = -1; // Mantém o valor que falha no loop
            }

        } while (maxSize < 0); // Continua até valor >= 0

        // PASSO 4a: Verifica se maxSize é zero
        if (maxSize == 0) {
            System.out.println("Não há produtos!");
        }
        // PASSO 4b: Instrução Else para valores diferentes de zero
        else {
            // PASSO 4b: Cria array unidimensional de produtos
            Produto[] produtos = new Produto[maxSize];

            // PASSO 5a: Loop for iterando pelo array
            for (int i = 0; i < maxSize; i++) {
                // PASSO 5b: Esvazia buffer de entrada na primeira linha do loop
                in.nextLine();

                System.out.println("\n--- Produto " + (i + 1) + " ---");

                // PASSO 5c: Código para obter entrada do usuário
                System.out.print("Digite o número do item: ");
                int tempNumber = in.nextInt();

                in.nextLine(); // Limpar buffer
                System.out.print("Digite o nome do produto: ");
                String tempName = in.nextLine();

                System.out.print("Digite a quantidade em estoque: ");
                int tempQty = in.nextInt();

                System.out.print("Digite o preço: ");
                double tempPrice = in.nextDouble();

                // PASSO 5d: Adiciona novo objeto Produto ao array
                produtos[i] = new Produto(tempNumber, tempName, tempQty, tempPrice);
            }

            // PASSO 6: Loop for-each para exibir informações
            System.out.println("\n===== RELATÓRIO DO INVENTÁRIO =====");
            for (Produto produto : produtos) {
                System.out.println(produto);
                System.out.println("-----------------------------");
            }
        }

        // PASSO 7: Códigos desnecessários removidos
        // PASSO 8: Projeto salvo
        in.close();
        System.out.println("Programa finalizado.");
    }
}