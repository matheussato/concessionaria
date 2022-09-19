package br.com.fiap.model;

public class Veiculo implements Comparable<Veiculo>{
    // BO BEAN Model POJO Entity Resource
    private String marca;
    private String modelo;
    private int ano;
    private double preco;
    private String placa;
    
     public Veiculo(String marca, String modelo, int ano, double preco, String placa) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.preco = preco;
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Override
    public String toString() {
        return marca + " " + modelo + " " + "(" + ano + ") " + " - " + preco;
        
    }

    @Override
    public int compareTo(Veiculo outro) {
        return Integer.compare(this.ano, outro.getAno());
       
    }

    



}
