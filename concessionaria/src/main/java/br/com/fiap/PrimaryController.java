package br.com.fiap;

import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class PrimaryController {

    @FXML private TextField textFieldMarca;
    @FXML private TextField textFieldModelo;
    @FXML private TextField textFieldAno;
    @FXML private TextField textFieldPreço;
    @FXML private TextField textFieldPlaca;
    @FXML private ListView<Veiculo> listView;

    private List<Veiculo> lista = new ArrayList<>();
    
    public void salvar(){
        String marca = textFieldMarca.getText();
        String modelo = textFieldModelo.getText();
        //TODO tratar erro de conversão
        int ano = Integer.valueOf(textFieldAno.getText());
        double preco = Double.valueOf(textFieldPreço.getText());
        String placa = textFieldPlaca.getText();

        Veiculo veiculo = new Veiculo(marca, modelo, ano, preco, placa);
        lista.add(veiculo);

        Alert alerta = new Alert(AlertType.INFORMATION);
        alerta.setContentText("Veículo cadastrado com sucesso");
        alerta.show();

        textFieldMarca.setText("");
        textFieldModelo.setText("");
        textFieldPreço.setText("");
        textFieldAno.setText("");
        textFieldPlaca.setText("");
        

        listView.getItems().addAll(lista);
    }

}
