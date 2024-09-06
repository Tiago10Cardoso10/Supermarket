import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GerirSupermercado {

    public GerirSupermercado() {
    }

    /**
     * Início da aplicação.
     *
     * @param args os argumentos de entrada
     */
    public static void main(String[] args) {
        System.out.println("-----------Bem vindo ao supermercado online Superdescontão----------\n");
        GerirSupermercado g = new GerirSupermercado();
        Supermercado supermercado;
        Ficheiro f = new Ficheiro();
        Data d = new Data();
        Scanner ler = new Scanner(System.in);

        File objetos = new File("Supermercado.obj");
        if (!objetos.exists())
            supermercado = f.lerFicheirosTexto();
        else
            supermercado = f.lerFicheiroObj();

        Cliente cliente = g.decidirInicio(supermercado.getClientes());

        boolean sair = false;
        while (!sair) {
            g.menu();
            while (!ler.hasNextInt()) {
                System.out.println("Opção inválida.");
                g.menu();
                ler.next();
            }
            int escolha = ler.nextInt();

            switch (escolha) {
                case 1 -> {
                    System.out.println("\nIntroduza a data corrente");
                    Data data = d.data();
                    g.compra(supermercado.getProdutos(), cliente, data, supermercado.getPromocoes(), supermercado);
                }
                case 2 -> {
                    for (Venda venda : cliente.getCompras())
                        cliente.consultarCompras(venda);
                }
                case 3 -> {
                    boolean repetir = true;
                    while (repetir) {
                        g.subMenu();
                        while (!ler.hasNextInt()) {
                            System.out.println("Opção inválida. Tente novamente.");
                            g.subMenu();
                            ler.next();
                        }
                        int opcao = ler.nextInt();
                        if (opcao == 1) {
                            repetir = false;
                            cliente = g.login(supermercado.getClientes());
                        } else if (opcao == 2) {
                            repetir = false;
                            sair = true;
                            System.out.println("Até à proxima!");

                        } else
                            System.out.println("Opção inválida. Tente novamente.");
                    }
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
        f.escreveFicheiroObj(supermercado);
    }

    private Cliente login(ArrayList<Cliente> clientes) {
        Scanner ler = new Scanner(System.in);
        System.out.print("\nEfetue login.\n\tInsira o seu e-mail: ");
        String email = ler.nextLine();
        while (verificaEmail(clientes, email) == null) {
            System.out.print("E-mail não encontrado.\nInsira novamente o seu e-mail: ");
            email = ler.nextLine();
        }
        Cliente cliente = verificaEmail(clientes, email);
        System.out.println("Login efetuado com sucesso!");
        return cliente;
    }

    private Cliente verificaEmail(ArrayList<Cliente> clientes, String email) {
        Cliente cliente = null;
        for (Cliente c : clientes) {
            if (email.equals(c.getEmail()))
                cliente = c;
        }
        return cliente;
    }

    private void inicio() {
        System.out.print("O que deseja fazer:\n" +
                "\t1. Realizar login;\n" +
                "\t2. Fazer novo registo.\n" +
                "\t\t>>> ");
    }

    private void inserirCliente(ArrayList<Cliente> clientes) {
        Data d = new Data();
        Scanner ler = new Scanner(System.in);
        System.out.print("\nNovo registo\nInsira o seu nome: ");
        String nome = ler.nextLine();
        System.out.print("Insira a sua morada: ");
        String morada = ler.nextLine();
        System.out.print("Insira o seu e-mail: ");
        String email = ler.nextLine();
        System.out.print("Insira o seu número de telefone: ");
        while (!ler.hasNextInt()) {
            System.out.print("Opção inválida. Tente novamente.\n\tInsira o seu número de telefone: ");
            ler.next();
        }
        int telefone = ler.nextInt();
        System.out.println("Insira a sua data de nascimento: ");
        Data data = d.data();
        clientes.add(new Cliente(nome, morada, email, telefone, data, false));
    }

    private Cliente decidirInicio(ArrayList<Cliente> clientes) {
        Cliente cliente = null;
        Scanner ler = new Scanner(System.in);
        boolean continuar = true;
        while (continuar) {
            inicio();
            while (!ler.hasNextInt()) {
                System.out.println("Opção inválida. Tente novamente.");
                inicio();
                ler.next();
            }
            int escolha = ler.nextInt();
            switch (escolha) {
                case 1 -> {
                    cliente = login(clientes);
                    continuar = false;
                }
                case 2 -> {
                    inserirCliente(clientes);
                    cliente = login(clientes);
                    continuar = false;
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
        return cliente;
    }

    private void menu() {
        System.out.print("\nEscolha uma operação:\n" +
                "\t1. Realizar uma compra;\n" +
                "\t2. Consultar as compras realizadas;\n" +
                "\t3. Logout.\n" +
                "\t\t>>> ");
    }

    public void subMenu() {
        System.out.print("\nO que deseja fazer?\n" +
                "\t1. Realizar novo registo;\n" +
                "\t2. Sair da aplicação.\n" +
                "\t\t>>> ");
    }

    private void compra(ArrayList<Produto> produtos, Cliente cliente, Data data, ArrayList<Promocao> promocoes, Supermercado s) {
        ArrayList<Produto> compras = new ArrayList<>();
        Venda v = new Venda();
        Ficheiro f = new Ficheiro();
        float total = 0, pagar = total;
        boolean continuar = true;
        Scanner ler = new Scanner(System.in);
        while (continuar) {
            System.out.println("\nProdutos do supermercado:");
            for (Produto p : produtos) {
                p.escreve();
            }
            System.out.print("\nIndique o identificador do produto que deseja adicionar: ");
            while (!ler.hasNextInt()) {
                System.out.print("Opção inválida. Tente novamente.\nIndique o identificador do produto que deseja adicionar: ");
                ler.next();
            }
            int identificador = ler.nextInt();
            Produto produto = s.procuraId(produtos, identificador);
            if (produto.getStock() != 0) {
                System.out.print("Quantas unidades? ");
                while (!ler.hasNextInt()) {
                    System.out.print("Número inválido. Tente novamente.\nQuantas unidades? ");
                    ler.next();
                }
                int quantidade = ler.nextInt();
                while (quantidade <= 0) {
                    System.out.print("Número inválido. Tente novamente.\nQuantas unidades? ");
                    quantidade = ler.nextInt();
                }
                while (quantidade > produto.getStock()) {
                    System.out.print("Não existem " + quantidade + " quantidades de " + produto.getNome() + " apenas " + produto.getStock() + ". Tente novamente.\nQuantas unidades? ");
                    quantidade = ler.nextInt();
                }
                float preco;
                produto.setStock(produto.getStock() - quantidade); // O novo stock é o stock anterior menos a quantidade que a pessoa comprou
                preco = produto.getPreco();
                total += preco * quantidade;
                int quantCarrinho = produto.getQuantidade();
                int indice = compras.indexOf(produto);
                if (indice == -1) { // Se o produto não estiver em Compras adiciona
                    produto.setQuantidade(quantidade);
                    compras.add(produto);
                } else
                    compras.get(indice).setQuantidade(quantCarrinho + quantidade);
            } else
                System.out.println("De momento o produto está indisponível");
            boolean voltar = true;
            while (voltar) {
                menuCarrinho();
                ler = new Scanner(System.in);
                while (!ler.hasNextInt()) {
                    System.out.println("Opção inválida.");
                    menuCarrinho();
                    ler.next();
                }
                int escolha = ler.nextInt();
                switch (escolha) {
                    case 1 -> voltar = false;
                    case 2 -> {
                        System.out.println("\n-----------Fatura-----------");
                        System.out.println("Nome-Quantidade-Preço por unidade");
                        for (Produto c : compras)
                            System.out.println(c.getNome() + "-" + c.getQuantidade() + "-" + c.getPreco());
                        System.out.println();
                        System.out.printf("Total sem desconto: %.2f€\n", total);
                        pagar = v.aplicarDesconto(promocoes, data, compras, total);  // Descontos
                        System.out.printf("Desconto aplicado: %.2f€\n", total - pagar);
                        System.out.printf("Total com desconto: %.2f€\n", pagar);
                        if (cliente.isFrequente()) {  // Preço do transporte
                            if (pagar <= 40 && pagar > 0) {  // Se o cliente for frequente e o valor da sua compra for menor do que 40€
                                pagar += 15;
                                System.out.println("Preço de transporte: 15,00€");
                            }
                        } else {  // Se o cliente não for frequente
                            if (pagar > 0) {
                                pagar += 20;
                                System.out.println("Preço de transporte: 20,00€");
                            }
                        }
                        for (Produto c : compras) {
                            if (c.peso() > 15) {
                                pagar += 10;  // Adicionar preço de transporte se o produto tiver mais de 15Kg
                                System.out.println("Preço de transporte adicional: 10,00€");
                            }
                        }
                        System.out.printf("Total a pagar: %.2f€\n", pagar);
                        voltar = false;
                        continuar = false;
                        System.out.println("Obrigada por escolher o nosso supermercado!");
                    }
                    case 3 -> {
                        System.out.print("\nIndique o identificador do produto que deseja remover: ");
                        while (!ler.hasNextInt()) {
                            System.out.print("Opção inválida. Tente novamente.\nIndique o identificador do produto que deseja remover: ");
                            ler.next();
                        }
                        identificador = ler.nextInt();
                        produto = s.procuraId(produtos, identificador);
                        int stock = produto.getStock();
                        produto.setStock(stock + produto.getQuantidade());  // Adicionar ao stock a quantidade retirada
                        total -= (produto.getPreco() * produto.getQuantidade());
                        int indice = compras.indexOf(produto);
                        if (indice != -1)  // Se o produto estiver em Compras remove
                            compras.remove(produto);
                        else
                            System.out.println("Este produto não está no carrinho.");
                    }
                    default -> System.out.println("Opção inválida");
                }
            }
        }
        v = new Venda(compras, data, pagar);  // Criar uma nova venda a cada compra
        cliente.adicionarCompra(v);  // Adicionar a compra ao histórico de compras do cliente
        f.escreveFicheiroObj(s);
    }

    private void menuCarrinho() {
        System.out.print("\nO que deseja fazer?\n" +
                "\t1. Adicionar mais produtos ao carrinho;\n" +
                "\t2. Pagar;\n" +
                "\t3. Remover produto do carrinho.\n" +
                "\t\t>>> ");
    }
}
