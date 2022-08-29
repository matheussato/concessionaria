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
       var veiculo = carregarVeiculoDoFormularario();
        lista.add(veiculo);

        mostrarAlerta("Veiculo cadastrado com sucesso");

        limparFormulario();

        listView.getItems().add(veiculo);
    }

    private void limparFormulario(){

        textFieldMarca.setText("");
        textFieldModelo.setText("");
        textFieldPreço.setText("");
        textFieldAno.setText("");
        textFieldPlaca.setText("");
    }

    private Veiculo carregarVeiculoDoFormularario(){

        String marca = textFieldMarca.getText();
        String modelo = textFieldModelo.getText();
     
        int ano = Integer.valueOf(textFieldAno.getText());
        double preco = Double.valueOf(textFieldPreço.getText());
        String placa = textFieldPlaca.getText();

        Veiculo veiculo = new Veiculo(marca, modelo, ano, preco, placa);
        return veiculo;
    }

    private void mostrarAlerta(String mensagem){

        Alert alerta = new Alert(AlertType.INFORMATION);
        alerta.setContentText(mensagem);
        alerta.show();

    }

    public void ordenarPorPreco(){
        //arrow function - funções lambda
        lista.sort((o1, o2) -> Double.compare(o1.getPreco(), o2.getPreco()));
        
        atualizarLista();
    }

    public void ordenarPorAno(){

        lista.sort((o1,o2) -> Integer.compare(o1.getAno(), o2.getAno()));
        atualizarLista();
    }

    private void atualizarLista(){
        listView.getItems().clear();
        listView.getItems().addAll(lista);
    }

    }

