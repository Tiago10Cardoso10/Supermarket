import java.io.Serializable;
import java.util.ArrayList;

/**
 * Objeto do tipo Cliente.
 */
public class Cliente implements Serializable {
    private String nome, morada, email;
    private int telefone;
    private Data dataNascimento;
    private boolean frequente;
    private ArrayList<Venda> compras = new ArrayList<>();

    /**
     * Cria um novo objeto Cliente.
     */
    public Cliente() {
    }

    /**
     * Objeto do tipo Cliente.
     *
     * @param nome           o nome do cliente
     * @param morada         a morada do cliente
     * @param email          o e-mail do cliente
     * @param telefone       o número de telefone do cliente
     * @param dataNascimento a data de nascimento do cliente
     * @param frequente      se o cliente é frequente ou não
     */
    public Cliente(String nome, String morada, String email, int telefone, Data dataNascimento, boolean frequente) {
        this.nome = nome;
        this.morada = morada;
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.frequente = frequente;
    }

    /**
     * Gets nome.
     *
     * @return o nome do cliente
     */
    public String getNome() {
        return nome;
    }

    /**
     * Sets nome.
     *
     * @param nome o nome do cliente
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Gets morada.
     *
     * @return a morada do cliente
     */
    public String getMorada() {
        return morada;
    }

    /**
     * Sets morada.
     *
     * @param morada a morada do cliente
     */
    public void setMorada(String morada) {
        this.morada = morada;
    }

    /**
     * Gets email.
     *
     * @return o e-mail do cliente
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email o e-mail do cliente
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets telefone.
     *
     * @return o número de telefone do cliente
     */
    public int getTelefone() {
        return telefone;
    }

    /**
     * Sets telefone.
     *
     * @param telefone o número de telefone do cliente
     */
    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    /**
     * Gets data nascimento.
     *
     * @return a data de nascimento do cliente
     */
    public Data getDataNascimento() {
        return dataNascimento;
    }

    /**
     * Sets data nascimento.
     *
     * @param dataNascimento a data de nascimento do cliente
     */
    public void setDataNascimento(Data dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * Is frequente boolean.
     *
     * @return se o cliente é frequente ou não
     */
    public boolean isFrequente() {
        return frequente;
    }

    /**
     * Sets frequente.
     *
     * @param frequente se o cliente é frequente ou não
     */
    public void setFrequente(boolean frequente) {
        this.frequente = frequente;
    }

    /**
     * Gets compras.
     *
     * @return as compras realizadas pelo cliente
     */
    public ArrayList<Venda> getCompras() {
        return compras;
    }

    /**
     * Sets compras.
     *
     * @param compras as compras realizadas pelo cliente
     */
    public void setCompras(ArrayList<Venda> compras) {
        this.compras = compras;
    }

    public void adicionarCompra(Venda compra) {
        compras.add(compra);
    }

    /**
     * Consultar compras.
     *
     * @param historico o historico de compras realizadas pelo cliente
     */
    public void consultarCompras(Venda historico) {
        Data d = new Data();
        System.out.println("Compra realizada no dia " + d.escreveData(historico.getDataVenda()) + ":");
        System.out.println("\tProduto: Quantidade");
        for (Produto p: historico.getProdutos())
            System.out.println("\t" + p.getNome() + ": " + p.getQuantidade());
        System.out.printf("Total da Compra: %.2f€\n\n", historico.getPrecoTotal());
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", morada='" + morada + '\'' +
                ", email='" + email + '\'' +
                ", telefone=" + telefone +
                ", dataNascimento=" + dataNascimento +
                ", frequente=" + frequente +
                ", compras=" + compras +
                '}';
    }
}
