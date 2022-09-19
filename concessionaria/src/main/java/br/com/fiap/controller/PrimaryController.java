package br.com.fiap.controller;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.dao.VeiculoDao;
import br.com.fiap.model.Veiculo;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML private TextField textFieldMarca;
    @FXML private TextField textFieldModelo;
    @FXML private TextField textFieldAno;
    @FXML private TextField textFieldPreço;
    @FXML private TextField textFieldPlaca;
    @FXML private ListView<Veiculo> listView;
    
    private VeiculoDao veiculoDao; 

    private PrimaryController(){
        try {
            veiculoDao = new VeiculoDao();
        } catch (SQLException e) {
            mostrarAlerta("Erro de SQL " + e.getMessage());
        }
    }

    public void salvar(){
        
        try {
            veiculoDao.inserir(carregarVeiculoDoFormularario());
        } catch (SQLException e) {
            mostrarAlerta("Erro de SQL " + e.getMessage());
        }

        mostrarAlerta("Veiculo cadastrado com sucesso");

        limparFormulario();
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
        try {
            List<Veiculo> lista = veiculoDao.listarTodos();
            lista.sort((o1,o2) -> Double.compare(o1.getPreco(), o2.getPreco()));
            atualizarLista(lista);
        } catch (SQLException e) {
            mostrarAlerta("Erro de SQL " + e.getMessage());
        }
    }
    
    public void ordenarPorAno(){
        try {
            List<Veiculo> lista = veiculoDao.listarTodos();
            lista.sort((o1,o2) -> Double.compare(o1.getAno(), o2.getAno()));
            atualizarLista(lista);
        } catch (SQLException e) {
            mostrarAlerta("Erro de SQL " + e.getMessage());
        }
        
    }
    
    private void atualizarLista(List<Veiculo> lista){
        listView.getItems().clear();
        listView.getItems().addAll(lista);
    }

    public void mostrarTodos(){
        try {
            List<Veiculo> lista = veiculoDao.listarTodos();
            atualizarLista(lista);
        } catch (SQLException e) {
            mostrarAlerta("Erro de SQL " + e.getMessage());
        }
    }

    public void filtrarPorMarca(String marca){
        try {
            List<Veiculo> lista = veiculoDao.buscarPorMarca(marca);
            atualizarLista(lista);
        } catch (SQLException e) {
            mostrarAlerta("Erro de SQL " + e.getMessage());
        }
      
    }
    
}

