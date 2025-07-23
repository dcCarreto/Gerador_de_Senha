package ModeloComInterface;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InterfaceGrafica extends Application {

    Gerador gerador = new Gerador();

    @Override
    public void start(Stage stage) {
        Label labelQuantidade = new Label("Quantidade de senhas:");
        TextField campoQuantidade = new TextField("5");

        Label labelTamanho = new Label("Dígitos:");
        TextField campoTamanho = new TextField("10");

        CheckBox maiusculas = new CheckBox("Incluir letras maiúsculas");
        CheckBox numeros = new CheckBox("Incluir números");
        CheckBox especiais = new CheckBox("Incluir caracteres especiais");

        Button botao = new Button("Gerar Senhas");
        TextArea output = new TextArea();
        output.setEditable(false);
        output.setWrapText(true);

        botao.setOnAction(e -> {
            try {
                int tamanho = Integer.parseInt(campoTamanho.getText());
                int quantidade = Integer.parseInt(campoQuantidade.getText());

                StringBuilder parametros = new StringBuilder();
                if (maiusculas.isSelected()) parametros.append("M");
                if (numeros.isSelected()) parametros.append("N");
                if (especiais.isSelected()) parametros.append("E");

                String[] senhas = gerador.gerarSenhasArray(quantidade, tamanho, parametros.toString());

                output.setText("");
                for (String senha : senhas) {
                    output.appendText(senha + "\n");
                }

            } catch (NumberFormatException ex) {
                output.setText("Por favor, insira valores numéricos válidos.");
            }
        });

        VBox root = new VBox(10, labelQuantidade, campoQuantidade, labelTamanho, campoTamanho,
                maiusculas, numeros, especiais, botao, output);
        root.setPadding(new Insets(15));

        Scene scene = new Scene(root, 400, 450);
        stage.setTitle("Gerador de Senhas");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
