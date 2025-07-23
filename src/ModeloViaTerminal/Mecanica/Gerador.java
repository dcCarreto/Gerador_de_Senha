package ModeloViaTerminal.Mecanica;

import ModeloViaTerminal.Dados.Calculos;
import ModeloViaTerminal.Dados.Coletor;
import ModeloViaTerminal.Dados.TipoCalculo;
import java.util.function.Function;

public class Gerador {
    Coletor col = new Coletor();
    Calculos calc = new Calculos();

    private String logicaSenha(Function<Calculos,String> estrategia) {
        int digitos = col.getDigitos();
        int quantidadeDeSenhas = col.getNumeroDeSenhas();

        if (quantidadeDeSenhas > 1) {
            String[] listaDeSenhas = new String[quantidadeDeSenhas];
            for (int i = 0; i < quantidadeDeSenhas; i++) {
                listaDeSenhas[i] = gerarSenha(digitos, estrategia);
            }
            return String.join("\n", listaDeSenhas);
        } else {
            return gerarSenha(digitos, estrategia);
        }
    }

    private String gerarSenha(int digitos, Function<Calculos, String> estrategia) {
        StringBuilder senha = new StringBuilder();
        for (int i = 0; i < digitos; i++) {
            senha.append(estrategia.apply(calc));
        }
        return senha.toString();
    }

    public void principal() {
        try {
            col.pegaParametros();
            TipoCalculo tipo = TipoCalculo.valueOf(col.getParametros());
            System.out.println(logicaSenha(calc -> calc.calcular(tipo)));
        } catch (IllegalArgumentException e) {
            System.out.println("Erro na chamada do Enum.");
        }
    }
}
