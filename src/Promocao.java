import java.io.Serializable;

/**
 * Objeto do tipo Promocao.
 */
public abstract class Promocao implements Serializable {
    /**
     * O Produto.
     */
    protected Produto produto;
    /**
     * A Data de Início da Promoção.
     */
    protected  Data inicio,
    /**
     * A Data de Fim da Promoção.
     */
    fim;

    /**
     * Cria um novo objeto Promocao.
     */
    public Promocao() {
    }

    /**
     * Cria um novo objeto Promocao.
     *
     * @param produto o produto
     * @param inicio  a data de inicio da promoção
     * @param fim     a data de fim da promoção
     */
    public Promocao(Produto produto, Data inicio, Data fim) {
        this.produto = produto;
        this.inicio = inicio;
        this.fim = fim;
    }

    /**
     * Gets produto.
     *
     * @return o produto
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * Sets produto.
     *
     * @param produto o produto
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    /**
     * Gets inicio.
     *
     * @return a data de início da promoção
     */
    public Data getInicio() {
        return inicio;
    }

    /**
     * Sets inicio.
     *
     * @param inicio a data de início da promoção
     */
    public void setInicio(Data inicio) {
        this.inicio = inicio;
    }

    /**
     * Gets fim.
     *
     * @return a data de fim da promoção
     */
    public Data getFim() {
        return fim;
    }

    /**
     * Sets fim.
     *
     * @param fim a data de fim da promoção
     */
    public void setFim(Data fim) {
        this.fim = fim;
    }

    /**
     * Desconto int.
     *
     * @param quantidade  a quantidade comprada
     * @param preco       o preço do produto
     * @param totalCompra o preço total da compra
     * @return um int
     */
    public abstract float desconto(int quantidade, float preco, float totalCompra);

    @Override
    public String toString() {
        return "Promocao{" +
                "produto=" + produto +
                ", inicio=" + inicio +
                ", fim=" + fim +
                '}';
    }
}
