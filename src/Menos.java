import java.io.Serializable;

/**
 * Objeto do tipo Menos.
 */
public class Menos extends Promocao implements Serializable {
    /**
     * Cria um novo objeto Menos.
     */
    public Menos() {
    }

    /**
     * Cria um novo objeto Menos.
     *
     * @param produto o produto
     * @param inicio  o data de inicio da promoção
     * @param fim     o data de fim da promoção
     */
    public Menos(Produto produto, Data inicio, Data fim) {
        super(produto, inicio, fim);
    }

    public float desconto(int quantidade, float preco, float totalCompra) {
        float percentagem = 1, total = 0;
        for (int i = 0; i < quantidade; i++) {
            total += preco * percentagem;
            if (percentagem > 0.5)
                percentagem -= 0.05;
        }
        return totalCompra - total;  // desconto aplicado à compra final
    }

    @Override
    public String toString() {
        return "Menos{" +
                "produto=" + produto +
                ", inicio=" + inicio +
                ", fim=" + fim +
                '}';
    }
}
