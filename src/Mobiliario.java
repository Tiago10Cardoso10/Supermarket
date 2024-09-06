import java.io.Serializable;

/**
 * Objeto do tipo Mobiliario.
 */
public class Mobiliario extends Produto implements Serializable {
    private int peso;
    private Dimensao dimensao;

    /**
     * Cria um novo objeto Mobiliario.
     */
    public Mobiliario() {
    }

    /**
     * Cria um novo objeto Mobiliario.
     *
     * @param nome          o nome do produto
     * @param identificador o identificador do produto
     * @param preco         o preço do produto
     * @param stock         o stock do produto em loja
     * @param peso          o peso do produto
     * @param dimensao      a dimensão do produto
     */
    public Mobiliario(String nome, int identificador, float preco, int stock, int peso, Dimensao dimensao) {
        super(nome, identificador, preco, stock);
        this.peso = peso;
        this.dimensao = dimensao;
    }

    /**
     * Instantiates a new Mobiliario.
     *
     * @param peso     o peso do produto
     * @param dimensao a dimensao do produto
     */
    public Mobiliario(int peso, Dimensao dimensao) {
        this.peso = peso;
        this.dimensao = dimensao;
    }

    /**
     * Gets peso.
     *
     * @return the peso do produto
     */
    public int getPeso() {
        return peso;
    }

    /**
     * Sets peso.
     *
     * @param peso the peso do produto
     */
    public void setPeso(int peso) {
        this.peso = peso;
    }

    /**
     * Gets dimensao.
     *
     * @return the dimensao do produto
     */
    public Dimensao getDimensao() {
        return dimensao;
    }

    /**
     * Sets dimensao.
     *
     * @param dimensao the dimensao do produto
     */
    public void setDimensao(Dimensao dimensao) {
        this.dimensao = dimensao;
    }

    public int peso() {
        return peso;
    }

    public void escreve() {
        super.escreve();
        System.out.println("; peso: " + peso + "; dimensões: " + dimensao.getAltura() + " x " + dimensao.getLargura() + " x " + dimensao.getProfundidade());
    }

    @Override
    public String toString() {
        return "Mobiliario{" +
                "peso=" + peso +
                ", dimensao=" + dimensao +
                ", identificador='" + identificador + '\'' +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", stock=" + stock +
                '}';
    }
}
