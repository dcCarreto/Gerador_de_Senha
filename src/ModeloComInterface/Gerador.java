package ModeloComInterface;

import java.util.Random;

public class Gerador {

    public String gerarSenhaUnica(int digitos, String parametros) {
        String letrasMinusculas = "abcdefghijklmnopqrstuvwxyz";
        String letrasMaiusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numeros = "0123456789";
        String especiais = "+=!@#$%&*()-_[]{}|;:\"<>,./?\\";
        StringBuilder caracteres = new StringBuilder(letrasMinusculas); // Sempre minúsculas

        if (parametros.contains("V")) caracteres.append(letrasMaiusculas);
        if (parametros.contains("F")) caracteres.append(numeros);
        if (parametros.contains("E")) caracteres.append(especiais);

        StringBuilder senha = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < digitos; i++) {
            int index = random.nextInt(caracteres.length());
            senha.append(caracteres.charAt(index));
        }

        return senha.toString();
    }

    public String[] gerarSenhasArray(int quantidade, int tamanho, String parametros) {
        String[] lista = new String[quantidade];
        for (int i = 0; i < quantidade; i++) {
            lista[i] = gerarSenhaUnica(tamanho, parametros);
        }
        return lista;
    }
}
