import java.io.Serializable;
import java.util.Scanner;

/**
 * Objeto do tipo Data.
 */
public class Data implements Serializable {
    private int dia, mes, ano;

    /**
     * Cria um novo objeto Data.
     */
    public Data() {
    }

    /**
     * Cria um novo objeto.
     *
     * @param dia o dia
     * @param mes o mes
     * @param ano o ano
     */
    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    /**
     * Gets dia.
     *
     * @return o dia
     */
    public int getDia() {
        return dia;
    }

    /**
     * Sets dia.
     *
     * @param dia o dia
     */
    public void setDia(int dia) {
        this.dia = dia;
    }

    /**
     * Gets mes.
     *
     * @return o mes
     */
    public int getMes() {
        return mes;
    }

    /**
     * Sets mes.
     *
     * @param mes o mes
     */
    public void setMes(int mes) {
        this.mes = mes;
    }

    /**
     * Gets ano.
     *
     * @return o ano
     */
    public int getAno() {
        return ano;
    }

    /**
     * Sets ano.
     *
     * @param ano o ano
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * Data mostrarData.
     *
     * @param dados os dados
     * @param i     o indice
     * @return uma data
     */
    public Data mostrarData(String[] dados, int i) {
        String[] parametros = dados[i].split("/");
        return new Data(Integer.parseInt(parametros[0]), Integer.parseInt(parametros[1]), Integer.parseInt(parametros[2]));
    }

    /**
     * Data data.
     *
     * @return uma data
     */
    public Data data() {
        System.out.print("\tAno: ");
        int ano = lerData("\tAno: ");
        while (ano < 0) {
            System.out.print("Ano inválido. Tente novamnete.\n\tAno: ");
            ano = lerData("\tAno: ");
        }
        System.out.print("\tMês: ");
        int mes = lerData("\tMês: ");
        while (mes < 1 || mes > 12) {
            System.out.print("Mês inválido. Tente novamnete.\n\tMês: ");
            mes = lerData("\tMês: ");
        }
        System.out.print("\tDia: ");
        int dia = lerData("\tDia: ");
        if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
            while (dia < 1 || dia > 31) {
                System.out.print("Dia inválido. Tente novamnete.\n\tDia: ");
                dia = lerData("\tDia: ");
            }
        } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            while (dia < 1 || dia > 30) {
                System.out.print("Dia inválido. Tente novamnete.\n\tDia: ");
                dia = lerData("\tDia: ");
            }
        } else if (ano % 4 == 0 && (ano % 100 != 0 || ano % 400 == 0)) {
            while (dia < 1 || dia > 29) {
                System.out.print("Dia inválido. Tente novamnete.\n\tDia: ");
                dia = lerData("\tDia: ");
            }
        } else {
            while (dia < 1 || dia > 28) {
                System.out.print("Dia inválido. Tente novamnete.\n\tDia: ");
                dia = lerData("\tDia: ");
            }
        }
        return new Data(dia, mes, ano);
    }

    /**
     * Ler data int.
     *
     * @param parametro o parametro
     * @return um int lido da consola
     */
    public int lerData(String parametro) {
        Scanner ler = new Scanner(System.in);
        while (!ler.hasNextInt()) {
            System.out.print("Opção inválida. Tente novamente\n" + parametro);
            ler = new Scanner(System.in);
        }
        return ler.nextInt();
    }

    /**
     * Verificar data boolean.
     *
     * @param corrente a data do dia corrente
     * @param incio    a data de início da promoção
     * @param fim      a data de fim da promoção
     * @return the boolean
     */
    public boolean verificarData(Data corrente, Data incio, Data fim) {  // Verifica se existe uma promoção nesse dia
        return corrente.getAno() >= incio.getAno() && corrente.getAno() <= fim.getAno() && corrente.getMes() >= incio.getMes() && corrente.getMes() <= fim.getMes() && corrente.getDia() >= incio.getDia() && corrente.getDia() <= fim.getDia();
    }

    /**
     * Escreve data string.
     *
     * @param data a data
     * @return a data em string
     */
    public String escreveData(Data data) {
        return data.getDia() + "/" + data.getMes() + "/" + data.getAno();
    }

    @Override
    public String toString() {
        return "Data{" +
                "dia=" + dia +
                ", mes=" + mes +
                ", ano=" + ano +
                '}';
    }
}
