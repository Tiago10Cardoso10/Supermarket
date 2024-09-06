import java.io.Serializable;

/**
 * Objeto do tipo Tres quatro.
 */
public class TresQuatro extends Promocao implements Serializable {
    /**
     * Cria um novo objeto Tres quatro.
     */
    public TresQuatro() {
    }

    /**
     * Cria um novo objeto Tres quatro.
     *
     * @param produto o produto em promoção
     * @param inicio  a data de inicio da promoção
     * @param fim     a data de fim da promoção
     */
    public TresQuatro(Produto produto, Data inicio, Data fim) {
        super(produto, inicio, fim);
    }

    public float desconto(int quantidade, float preco, float totalCompra) {
        float total = (quantidade - (float) (quantidade / 4)) * preco;  // preço da quantidade a pagar
        return totalCompra - total;  // desconto aplicado à compra final
    }

    @Override
    public String toString() {
        return "TresQuatro{" +
                "produto=" + produto +
                ", inicio=" + inicio +
                ", fim=" + fim +
                '}';
    }
}
