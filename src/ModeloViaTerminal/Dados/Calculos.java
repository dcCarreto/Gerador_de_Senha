package ModeloViaTerminal.Dados;

import java.util.Random;

public class Calculos {
    private Random random = new Random();
    private Sorteios sort = new Sorteios();

    public Calculos() {
        this(new Random(), new Sorteios());
    }

    public Calculos(Random random, Sorteios sort) {
        this.random = random;
        this.sort = sort;
    }

    private String selecionarAleatorio(String... opcoes) {
        return opcoes[random.nextInt(opcoes.length)];
    }

    public String calcular(TipoCalculo tipo) {
        return switch (tipo) {
            case VVV -> selecionarAleatorio(sort.minusculo(), sort.maiusculo(), sort.numeral(), sort.especial());
            case VFV -> selecionarAleatorio(sort.minusculo(), sort.maiusculo(), sort.especial());
            case VVF -> selecionarAleatorio(sort.minusculo(), sort.maiusculo(), sort.numeral());
            case FVV -> selecionarAleatorio(sort.minusculo(), sort.numeral(), sort.especial());
            case VFF -> selecionarAleatorio(sort.minusculo(), sort.maiusculo());
            case FFV -> selecionarAleatorio(sort.minusculo(), sort.especial());
            case FVF -> selecionarAleatorio(sort.minusculo(), sort.numeral());
            case FFF -> sort.minusculo();
        };
    }
}
