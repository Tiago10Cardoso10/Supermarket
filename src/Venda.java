import java.io.Serializable;
import java.util.ArrayList;

/**
 * Objeto do tipo Venda.
 */
public class Venda implements Serializable {
    private ArrayList<Produto> produtos;
    private Data dataVenda;
    private float precoTotal;

    /**
     * Cria um novo objeto Venda.
     */
    public Venda() {
    }

    /**
     * Cria um novo objeto Venda.
     *
     * @param produtos   o produtos
     * @param dataVenda  a data da venda
     * @param precoTotal o preco total da compra
     */
    public Venda(ArrayList<Produto> produtos, Data dataVenda, float precoTotal) {
        this.produtos = produtos;
        this.dataVenda = dataVenda;
        this.precoTotal = precoTotal;
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
     * Gets data venda.
     *
     * @return a data da venda
     */
    public Data getDataVenda() {
        return dataVenda;
    }

    /**
     * Sets data venda.
     *
     * @param dataVenda a data da venda
     */
    public void setDataVenda(Data dataVenda) {
        this.dataVenda = dataVenda;
    }

    /**
     * Gets preco total.
     *
     * @return o preco total da compra
     */
    public float getPrecoTotal() {
        return precoTotal;
    }

    /**
     * Sets preco total.
     *
     * @param precoTotal o preco total comptra
     */
    public void setPrecoTotal(float precoTotal) {
        this.precoTotal = precoTotal;
    }

    /**
     * Aplicar desconto float.
     *
     * @param promocoes as promoções
     * @param data      a data da compra
     * @param compras   as compras
     * @param total     o total da compra
     * @return valor da compra com desconto
     */
    public float aplicarDesconto(ArrayList<Promocao> promocoes, Data data, ArrayList<Produto> compras, float total) {
        float desconto = 0;
        Data d = new Data();
        for (Promocao p : promocoes) {
            if (d.verificarData(data, p.getInicio(), p.getFim())) {
                for (Produto c : compras) {
                    if (p.getProduto().getNome().equals(c.getNome()))
                        desconto += p.desconto(c.getQuantidade(), c.getPreco(), total);
                }
            }
        }
        return total - desconto;
    }

    @Override
    public String toString() {
        return "Venda{" +
                "produtos=" + produtos +
                ", dataVenda=" + dataVenda +
                ", precoTotal=" + precoTotal +
                '}';
    }
}
