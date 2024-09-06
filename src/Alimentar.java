/**
 * Objeto do tipo Alimentar.
 */
public class Alimentar extends Produto {
    private int calorias, gorduras;

    /**
     * Cria um novo objeto Alimentar.
     */
    public Alimentar() {
    }

    /**
     * Cria um novo objeto Alimentar.
     *
     * @param nome          o nome do produto
     * @param identificador o identificador do produto
     * @param preco         o preço do produto
     * @param stock         o stock do produto em loja
     * @param calorias      o numero de calorias por 100g
     * @param gorduras      a percentagem de gordura
     */
    public Alimentar(String nome, int identificador, float preco, int stock, int calorias, int gorduras) {
        super(nome, identificador, preco, stock);
        this.calorias = calorias;
        this.gorduras = gorduras;
    }

    /**
     * Cria um novo objeto Alimentar.
     *
     * @param calorias o numero de calorias por 100g
     * @param gorduras a percentagem de gordura
     */
    public Alimentar(int calorias, int gorduras) {
        this.calorias = calorias;
        this.gorduras = gorduras;
    }

    /**
     * Gets calorias.
     *
     * @return o numero de calorias por 100g
     */
    public int getCalorias() {
        return calorias;
    }

    /**
     * Sets calorias.
     *
     * @param calorias o numero de calorias por 100g
     */
    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    /**
     * Gets gorduras.
     *
     * @return a percentagem de gordura
     */
    public int getGorduras() {
        return gorduras;
    }

    /**
     * Sets gorduras.
     *
     * @param gorduras a percentagem de gordura
     */
    public void setGorduras(int gorduras) {
        this.gorduras = gorduras;
    }

    public int peso() {
        return 0;  // Peso não é um atributo da classe Alimentar
    }

    public void escreve() {
        super.escreve();
        System.out.println("; calorias: " + calorias + "/100g; goduras: " + gorduras + "%");
    }

    @Override
    public String toString() {
        return "Alimentar{" +
                "calorias=" + calorias +
                ", gorduras=" + gorduras +
                ", identificador='" + identificador + '\'' +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", stock=" + stock +
                '}';
    }
}
