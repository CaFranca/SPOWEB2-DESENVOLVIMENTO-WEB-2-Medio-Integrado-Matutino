package Inventario;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestadorProduto {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tamanhoMaximo, opcaoMenu;

        tamanhoMaximo = obterNumeroProdutos(in);
        if (tamanhoMaximo == 0) {
            System.out.println("Nenhum produto necessário!");
        } else {
            Produto[] produtos = new Produto[tamanhoMaximo];
            adicionarAoInventario(produtos, in);
            do {
                opcaoMenu = obterOpcaoMenu(in);
                executarOpcaoMenu(opcaoMenu, produtos, in);
            } while (opcaoMenu != 0);
        }

        in.close();
    }

    public static int obterNumeroProdutos(Scanner scanner) {
        int tamanhoMaximo = -1;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print("Digite o número de produtos que deseja adicionar: ");
                tamanhoMaximo = scanner.nextInt();

                if (tamanhoMaximo >= 0) {
                    entradaValida = true;
                } else {
                    System.out.println("Por favor digite um número positivo ou zero.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor digite um número válido.");
                scanner.nextLine();
            }
        }

        return tamanhoMaximo;
    }

    public static void adicionarAoInventario(Produto[] produtos, Scanner scanner) {
        int escolhaEstoque = -1;

        for (int i = 0; i < produtos.length; i++) {
            boolean entradaValida = false;

            while (!entradaValida) {
                try {
                    System.out.println("\n--- Produto " + (i + 1) + " ---");
                    System.out.println("1: CD");
                    System.out.println("2: DVD");
                    System.out.print("Insira o tipo de produto: ");

                    escolhaEstoque = scanner.nextInt();
                    scanner.nextLine();

                    if (escolhaEstoque == 1) {
                        adicionarCDAoInventario(produtos, scanner, i);
                        entradaValida = true;
                    } else if (escolhaEstoque == 2) {
                        adicionarDVDaoInventario(produtos, scanner, i);
                        entradaValida = true;
                    } else {
                        System.out.println("Somente os números 1 ou 2 são permitidos!");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor digite um número válido.");
                    scanner.nextLine();
                }
            }
        }
    }

    public static void adicionarCDAoInventario(Produto[] produtos, Scanner scanner, int i) {
        try {
            System.out.println("\n--- Cadastro de CD " + (i + 1) + " ---");

            System.out.print("Insira o nome do CD: ");
            String nomeCD = scanner.nextLine();

            System.out.print("Insira o nome do artista: ");
            String artista = scanner.nextLine();

            System.out.print("Insira o nome do selo de gravação: ");
            String selo = scanner.nextLine();

            System.out.print("Insira o número de músicas: ");
            int numeroMusicas = scanner.nextInt();

            System.out.print("Insira a quantidade em estoque para este produto: ");
            int qtdEstoque = scanner.nextInt();

            System.out.print("Insira o preço para este produto: ");
            double preco = scanner.nextDouble();

            System.out.print("Insira o número do item: ");
            int numeroItem = scanner.nextInt();
            scanner.nextLine();

            produtos[i] = new CD(numeroItem, nomeCD, qtdEstoque, preco, artista, numeroMusicas, selo);

        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor tente novamente.");
            scanner.nextLine();
            i--;
        }
    }

    public static void adicionarDVDaoInventario(Produto[] produtos, Scanner scanner, int i) {
        try {
            System.out.println("\n--- Cadastro de DVD " + (i + 1) + " ---");

            System.out.print("Insira o nome do DVD: ");
            String nomeDVD = scanner.nextLine();

            System.out.print("Insira o nome do estúdio cinematográfico: ");
            String estudio = scanner.nextLine();

            System.out.print("Insira a classificação etária: ");
            String classificacao = scanner.nextLine();

            System.out.print("Insira a duração em minutos: ");
            int duracao = scanner.nextInt();

            System.out.print("Insira a quantidade em estoque para este produto: ");
            int qtdEstoque = scanner.nextInt();

            System.out.print("Insira o preço para este produto: ");
            double preco = scanner.nextDouble();

            System.out.print("Insira o número do item: ");
            int numeroItem = scanner.nextInt();
            scanner.nextLine();

            produtos[i] = new DVD(numeroItem, nomeDVD, qtdEstoque, preco, duracao, classificacao, estudio);

        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor tente novamente.");
            scanner.nextLine();
            i--;
        }
    }

    public static void exibirInventario(Produto[] produtos) {
        System.out.println("\n=== INVENTÁRIO ===");
        for (Produto produto : produtos) {
            if (produto != null && produto.isAtivo()) {
                System.out.println(produto);
                System.out.println("------------------------");
            }
        }
    }

    public static int obterOpcaoMenu(Scanner scanner) {
        int escolha = -1;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.println("\n=== MENU ===");
                System.out.println("1. Exibir Inventário");
                System.out.println("2. Adicionar Estoque");
                System.out.println("3. Deduzir Estoque");
                System.out.println("4. Descontinuar Produto");
                System.out.println("0. Sair");
                System.out.print("Digite uma opção do menu: ");

                escolha = scanner.nextInt();

                if (escolha >= 0 && escolha <= 4) {
                    entradaValida = true;
                } else {
                    System.out.println("Por favor digite um número entre 0 e 4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor digite um número válido.");
                scanner.nextLine();
            }
        }

        return escolha;
    }

    public static int obterNumeroProduto(Produto[] produtos, Scanner scanner) {
        int escolhaProduto = -1;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.println("\n=== SELECIONAR PRODUTO ===");
                for (int i = 0; i < produtos.length; i++) {
                    if (produtos[i] != null && produtos[i].isAtivo()) {
                        System.out.println(i + ". " + produtos[i].getNomeProduto() +
                                " (" + (produtos[i] instanceof CD ? "CD" : "DVD") + ")");
                    }
                }

                System.out.print("Digite o número do produto: ");
                escolhaProduto = scanner.nextInt();

                if (escolhaProduto >= 0 && escolhaProduto < produtos.length &&
                        produtos[escolhaProduto] != null && produtos[escolhaProduto].isAtivo()) {
                    entradaValida = true;
                } else {
                    System.out.println("Número de produto inválido. Por favor tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor digite um número válido.");
                scanner.nextLine();
            }
        }

        return escolhaProduto;
    }

    public static void adicionarEstoque(Produto[] produtos, Scanner scanner) {
        int escolhaProduto;
        int valorAtualizacao = -1;

        escolhaProduto = obterNumeroProduto(produtos, scanner);

        if (!produtos[escolhaProduto].isAtivo()) {
            System.out.println("Não é possível adicionar estoque a um produto descontinuado!");
            return;
        }

        boolean entradaValida = false;
        while (!entradaValida) {
            try {
                System.out.print("Quantos produtos deseja adicionar? ");
                valorAtualizacao = scanner.nextInt();

                if (valorAtualizacao >= 0) {
                    entradaValida = true;
                } else {
                    System.out.println("Por favor digite um número positivo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor digite um número válido.");
                scanner.nextLine();
            }
        }

        produtos[escolhaProduto].adicionarEstoque(valorAtualizacao);
        System.out.println("Estoque adicionado com sucesso!");
    }

    public static void deduzirEstoque(Produto[] produtos, Scanner scanner) {
        int escolhaProduto;
        int valorAtualizacao = -1;

        escolhaProduto = obterNumeroProduto(produtos, scanner);

        boolean entradaValida = false;
        while (!entradaValida) {
            try {
                System.out.print("Quantos produtos deseja deduzir? ");
                valorAtualizacao = scanner.nextInt();

                if (valorAtualizacao >= 0 && valorAtualizacao <= produtos[escolhaProduto].getUnidadesEstoque()) {
                    entradaValida = true;
                } else {
                    System.out.println("Por favor digite um número entre 0 e " +
                            produtos[escolhaProduto].getUnidadesEstoque());
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor digite um número válido.");
                scanner.nextLine();
            }
        }

        produtos[escolhaProduto].deduzirEstoque(valorAtualizacao);
        System.out.println("Estoque deduzido com sucesso!");
    }

    public static void descontinuarInventario(Produto[] produtos, Scanner scanner) {
        int escolhaProduto;

        escolhaProduto = obterNumeroProduto(produtos, scanner);
        produtos[escolhaProduto].setAtivo(false);
        System.out.println("Produto descontinuado com sucesso!");
    }

    public static void executarOpcaoMenu(int opcaoMenu, Produto[] produtos, Scanner scanner) {
        switch (opcaoMenu) {
            case 1:
                System.out.println("\n=== LISTA DE PRODUTOS ===");
                exibirInventario(produtos);
                break;
            case 2:
                System.out.println("\n=== ADICIONAR ESTOQUE ===");
                adicionarEstoque(produtos, scanner);
                break;
            case 3:
                System.out.println("\n=== DEDUZIR ESTOQUE ===");
                deduzirEstoque(produtos, scanner);
                break;
            case 4:
                System.out.println("\n=== DESCONTINUAR ESTOQUE ===");
                descontinuarInventario(produtos, scanner);
                break;
            case 0:
                System.out.println("Saindo do programa. Até logo!");
                break;
            default:
                System.out.println("Opção de menu inválida.");
        }
    }
}