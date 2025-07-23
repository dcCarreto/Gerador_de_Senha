package ModeloViaTerminal.Dados;

public class Verificador {
    protected Verificador() {}

    protected static boolean verificaResposta(String parametro) {
        if (parametro.equalsIgnoreCase("sim") ||
                parametro.equalsIgnoreCase("nao") ||
                parametro.equalsIgnoreCase("não")) {
            return true;
        } else {
            System.out.println("Resposta inválida (" + parametro + "), digite sim ou não.");
            System.out.println();
            return false;
        }
    }
}
