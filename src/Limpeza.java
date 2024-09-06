import java.io.Serializable;

/**
 * Objeto do tipo Limpeza.
 */
public class Limpeza extends Produto implements Serializable {
    private int toxicidade;

    /**
     * Cria um novo objeto Limpeza.
     */
    public Limpeza() {
    }

    /**
     * Cria um novo objeto Limpeza.
     *
     * @param nome          o nome do produto
     * @param identificador o identificador do produto
     * @param preco         o preço do produto
     * @param stock         o stock do produto em loja
     * @param toxicidade    o toxicidade do produto
     */
    public Limpeza(String nome, int identificador, float preco, int stock, int toxicidade) {
        super(nome, identificador, preco, stock);
        this.toxicidade = toxicidade;
    }

    /**
     * Cria um novo objeto Limpeza.
     *
     * @param toxicidade a toxicidade do produto
     */
    public Limpeza(int toxicidade) {
        this.toxicidade = toxicidade;
    }

    /**
     * Gets toxicidade.
     *
     * @return a toxicidade do produto
     */
    public int getToxicidade() {
        return toxicidade;
    }

    /**
     * Sets toxicidade.
     *
     * @param toxicidade the toxicidade do produto
     */
    public void setToxicidade(int toxicidade) {
        this.toxicidade = toxicidade;
    }

    public int peso() {
        return 0;  // Peso não é um atributo da classe Limpeza
    }

    public void escreve() {
        super.escreve();
        System.out.println("; toxicidade: " + toxicidade);
    }

    @Override
    public String toString() {
        return "Limpeza{" +
                "toxicidade=" + toxicidade +
                ", identificador='" + identificador + '\'' +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", stock=" + stock +
                '}';
    }
}
