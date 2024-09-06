import java.io.Serializable;

/**
 * Objeto do tipo Produto.
 */
public abstract class Produto implements Serializable {
    /**
     * O Nome do Produto.
     */
    protected String nome;
    /**
     * O Identificador do Produto.
     */
    protected int identificador,
    /**
     * O Stock do Produto em Loja.
     */
    stock,
    /**
     * A Quantidade de Produto Comprada.
     */
    quantidade;
    /**
     * O Preco do Produto.
     */
    protected float preco;

    /**
     * Cria um novo objeto Produto.
     */
    public Produto() {
    }

    /**
     * Cria um novo objeto Produto.
     *
     * @param nome          o nome do produto
     * @param identificador o identificador do produto
     * @param preco         o preço do produto
     * @param stock         o stock do produto em loja
     */
    public Produto(String nome, int identificador, float preco, int stock) {
        this.nome = nome;
        this.identificador = identificador;
        this.preco = preco;
        this.stock = stock;
    }

    /**
     * Gets nome.
     *
     * @return o nome do produto
     */
    public String getNome() {
        return nome;
    }

    /**
     * Sets nome.
     *
     * @param nome o nome do produto
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Gets identificador.
     *
     * @return o identificador do produto
     */
    public int getIdentificador() {
        return identificador;
    }

    /**
     * Sets identificador.
     *
     * @param identificador o identificador do produto
     */
    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    /**
     * Gets preco.
     *
     * @return o preco do produto
     */
    public float getPreco() {
        return preco;
    }

    /**
     * Sets preco.
     *
     * @param preco o preco
     */
    public void setPreco(float preco) {
        this.preco = preco;
    }

    /**
     * Gets stock.
     *
     * @return o stock do produto em loja
     */
    public int getStock() {
        return stock;
    }

    /**
     * Sets stock.
     *
     * @param stock o stock do produto em loja
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Gets quantidade.
     *
     * @return a quantidade do produto comprada
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * Sets quantidade.
     *
     * @param quantidade a quantidade de produto comprada
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * Peso int.
     *
     * @return um int
     */
    public abstract int peso();

    /**
     * Escreve.
     */
    public void escreve() {
        System.out.print(nome + "\n\tCaracterísticas -> identificador: " + identificador + "; preço: " + preco + "€; em stock: " + stock);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", identificador=" + identificador +
                ", preco=" + preco +
                ", stock=" + stock +
                ", quantidade=" + quantidade +
                '}';
    }
}
