import java.io.Serializable;

/**
 * Objeto do tipo Dimensao.
 */
public class Dimensao implements Serializable {
    private int altura, largura, profundidade;

    /**
     * Cria um novo objeto Dimensao.
     */
    public Dimensao() {
    }

    /**
     * Cria um novo objeto Dimensao.
     *
     * @param altura       a altura do produto de mobiliário
     * @param largura      a largura do produto de mobiliário
     * @param profundidade a profundidade do produto de mobiliário
     */
    public Dimensao(int altura, int largura, int profundidade) {
        this.altura = altura;
        this.largura = largura;
        this.profundidade = profundidade;
    }

    /**
     * Gets altura.
     *
     * @return a altura do produto de mobiliário
     */
    public int getAltura() {
        return altura;
    }

    /**
     * Sets altura.
     *
     * @param altura a altura do produto de mobiliário
     */
    public void setAltura(int altura) {
        this.altura = altura;
    }

    /**
     * Gets largura.
     *
     * @return a largura do produto de mobiliário
     */
    public int getLargura() {
        return largura;
    }

    /**
     * Sets largura.
     *
     * @param largura a largura do produto de mobiliário
     */
    public void setLargura(int largura) {
        this.largura = largura;
    }

    /**
     * Gets profundidade.
     *
     * @return a profundidade do produto de mobiliário
     */
    public int getProfundidade() {
        return profundidade;
    }

    /**
     * Sets profundidade.
     *
     * @param profundidade a profundidade do produto de mobiliário
     */
    public void setProfundidade(int profundidade) {
        this.profundidade = profundidade;
    }

    @Override
    public String toString() {
        return "Dimensao{" +
                "altura=" + altura +
                ", largura=" + largura +
                ", profundidade=" + profundidade +
                '}';
    }
}
