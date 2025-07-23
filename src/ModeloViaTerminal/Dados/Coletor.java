package ModeloViaTerminal.Dados;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Coletor {
    private final Scanner scan = new Scanner(System.in);
    private StringBuilder parametros = new StringBuilder();

    private String pergunta(String pergunta) {
        System.out.println(pergunta);
        return scan.nextLine().trim().toLowerCase();
    }

    public void pegaParametros() {
        parametros = new StringBuilder();
        perguntar("Adicionar letras maiúsculas? (sim/não)");
        perguntar("Adicionar numerais? (sim/não)");
        perguntar("Adicionar caracteres especiais? (sim/não)");
    }

    private boolean perguntar(String mensagem) {
        while(true) {
            String resposta = pergunta(mensagem);
            if(Verificador.verificaResposta(resposta)) {
                conversor(resposta);
                return resposta.equalsIgnoreCase("sim");
            }
        }
    }

    private void conversor(String parametro) {
        if (parametro.equalsIgnoreCase("sim")) {
            parametros.append("V");
        } else {
            parametros.append("F");
        }
    }

    public String getParametros() {
        return parametros.toString();
    }

    public int getDigitos() {
        while (true) {
            System.out.println("Quantos dígitos usar? (ex. 100)");
            try {
                int valor = scan.nextInt();
                scan.nextLine();
                return valor;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
                scan.nextLine();
            }
        }
    }

    public int getNumeroDeSenhas() {
        while (true) {
            System.out.println("Quantas senhas deseja gerar? (ex. 6)");
            try {
                int valor = scan.nextInt();
                scan.nextLine();
                return valor;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
                scan.nextLine();
            }
        }
    }
}
