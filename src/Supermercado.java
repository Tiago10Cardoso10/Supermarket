import java.io.Serializable;
import java.util.ArrayList;

/**
 * Objeto do tipo Supermercado.
 */
public class Supermercado implements Serializable {
    private ArrayList<Cliente> clientes;
    private ArrayList<Produto> produtos;
    private ArrayList<Promocao> promocoes;

    /**
     * Cria um novo objeto Supermercado.
     */
    public Supermercado() {
    }

    /**
     * Cria um novo objeto Supermercado.
     *
     * @param clientes  os clientes
     * @param produtos  os produtos
     * @param promocoes as promocoes
     */
    public Supermercado(ArrayList<Cliente> clientes, ArrayList<Produto> produtos, ArrayList<Promocao> promocoes) {
        this.clientes = clientes;
        this.produtos = produtos;
        this.promocoes = promocoes;
    }

    /**
     * Gets clientes.
     *
     * @return os clientes
     */
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    /**
     * Sets clientes.
     *
     * @param clientes os clientes
     */
    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    /**
     * Gets produtos.
     *
     * @return os produtos
     */
    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    /**
     * Sets produtos.
     *
     * @param produtos os produtos
     */
    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    /**
     * Gets promocoes.
     *
     * @return os promocoes
     */
    public ArrayList<Promocao> getPromocoes() {
        return promocoes;
    }

    /**
     * Sets promocoes.
     *
     * @param promocoes os promocoes
     */
    public void setPromocoes(ArrayList<Promocao> promocoes) {
        this.promocoes = promocoes;
    }

    /**
     * Procura produto produto.
     *
     * @param produtos os produtos
     * @param nome     o nome do produto
     * @return o produto
     */
    public Produto procuraProduto(ArrayList<Produto> produtos, String nome) {
        Produto produto = null;
        for (Produto p: produtos) {
            if (nome.equals(p.getNome())) {
                produto = p;
            }
        }
        return produto;
    }

    /**
     * Procura id produto.
     *
     * @param produtos os produtos
     * @param id       o identificador do produto
     * @return um produto
     */
    public Produto procuraId(ArrayList<Produto> produtos, int id) {
        Produto produto = null;
        for (Produto p: produtos) {
            if (id == p.getIdentificador()) {
                produto = p;
            }
        }
        return produto;
    }

    @Override
    public String toString() {
        return "Supermercado{" +
                "registos=" + clientes +
                ", produtos=" + produtos +
                '}';
    }
}
