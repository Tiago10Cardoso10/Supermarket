import java.io.*;
import java.util.ArrayList;

/**
 * Objeto do tipo Ficheiro.
 */
public class Ficheiro {
    /**
     * Ler ficheiros texto supermercado.
     *
     * @return um supermercado
     */
    public Supermercado lerFicheirosTexto() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Produto> produtos = new ArrayList<>();
        ArrayList<Promocao> promocoes = new ArrayList<>();
        Data d = new Data();
        Supermercado s = new Supermercado();
        File fich;
        for (int i = 0; i < 4; i++) {
            if (i == 0)
                fich = new File("Clientes_frequentes");
            else if (i == 1)
                fich = new File("Clientes_regulares");
            else if (i == 2)
                fich = new File("Produtos");
            else
                fich = new File("Promocoes");
            try (FileReader fr = new FileReader(fich);
                 BufferedReader br = new BufferedReader(fr)) {
                String linha = br.readLine();
                while (linha != null) {
                    String[] dados = linha.split(",");
                    switch (dados[0]) {
                        case "limpeza" -> produtos.add(new Limpeza(dados[1], Integer.parseInt(dados[2]), Float.parseFloat(dados[3]), Integer.parseInt(dados[4]), Integer.parseInt(dados[5])));
                        case "mobiliario" -> {
                            String[] dimensoes = dados[6].split("x");
                            Dimensao dimensao = new Dimensao(Integer.parseInt(dimensoes[0]), Integer.parseInt(dimensoes[1]), Integer.parseInt(dimensoes[2]));
                            produtos.add(new Mobiliario(dados[1], Integer.parseInt(dados[2]), Float.parseFloat(dados[3]), Integer.parseInt(dados[4]), Integer.parseInt(dados[5]), dimensao));
                        }
                        case "alimentar" -> produtos.add(new Alimentar(dados[1], Integer.parseInt(dados[2]), Float.parseFloat(dados[3]), Integer.parseInt(dados[4]), Integer.parseInt(dados[5]), Integer.parseInt(dados[6])));
                        case "menos" -> promocoes.add(new Menos(s.procuraProduto(produtos, dados[1]), d.mostrarData(dados, 2), d.mostrarData(dados, 3)));
                        case "tresquatro" -> promocoes.add(new TresQuatro(s.procuraProduto(produtos, dados[1]), d.mostrarData(dados, 2), d.mostrarData(dados, 3)));
                        default -> {
                            if (i == 0)
                                clientes.add(new Cliente(dados[0], dados[1], dados[2], Integer.parseInt(dados[3]), d.mostrarData(dados, 4), true));
                            else if (i == 1)
                                clientes.add(new Cliente(dados[0], dados[1], dados[2], Integer.parseInt(dados[3]), d.mostrarData(dados, 4), false));
                        }
                    }
                    linha = br.readLine();
                }
            } catch (FileNotFoundException e) {
                System.out.println("Erro de abertura do ficheiro.");
            } catch (IOException e) {
                System.out.println("Erro a ler ficheiro.");
            }
        }
        return new Supermercado(clientes, produtos, promocoes);
    }

    /**
     * Escreve ficheiro obj.
     *
     * @param supermercado um supermercado
     */
    public void escreveFicheiroObj(Supermercado supermercado) {
        File fich = new File("Supermercado.obj");
        try (FileOutputStream fos = new FileOutputStream(fich);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(supermercado);
        } catch (FileNotFoundException e) {
            System.out.println("Erro a criar ficheiro");
        }
        catch (IOException e) {
            System.out.println("Erro a escrever no ficheiro.");
        }
    }

    /**
     * Ler ficheiro obj supermercado.
     *
     * @return um supermercado
     */
    public Supermercado lerFicheiroObj() {
        Supermercado supermercado = null;
        File fich = new File("Supermercado.obj");
        try (FileInputStream fis = new FileInputStream(fich);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            supermercado = (Supermercado) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Erro de abertura do ficheiro.");
        } catch (IOException e) {
            System.out.println("Erro a ler ficheiro.");
        } catch (ClassNotFoundException e) {
            System.out.println("Erro a converter para objeto.");
        }
        return supermercado;
    }
}
