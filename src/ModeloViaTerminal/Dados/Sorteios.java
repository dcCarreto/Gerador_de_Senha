package ModeloViaTerminal.Dados;

import java.util.Random;

public class Sorteios {
    Random random = new Random();

    public String minusculo() {
        return String.valueOf((char) ('a' + random.nextInt(26)));
    }

    public String maiusculo() {
        return String.valueOf((char) ('A' + random.nextInt(26)));
    }

    public String numeral() {
        return String.valueOf(random.nextInt(10));
    }

    public String especial() {
        char[] possibilidades = {
                '+', '=', '!', '@', '#', '$', '%', '&', '*',
                '(', ')', '-', '_', '[', ']', '{', '}', '|',
                ';', ':', '"', '<', '>', ',', '.', '/', '?', '\\'
        };
        return String.valueOf(possibilidades[random.nextInt(possibilidades.length)]);
    }
}
