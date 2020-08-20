package org.test.classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Carro {

    private List<String> opcionais = new ArrayList<>();
    private String cor;
    private String modelo;
    private String marca;
    private int ano;

    public Carro() {}

    public Carro(List<String> opcionais, String cor, String modelo, String marca, int ano) {
        this.opcionais = opcionais;
        this.cor = cor;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
    }

    public List<String> getOpcionais() {
        return opcionais;
    }

    public void setOpcionais(List<String> opcionais) {
        this.opcionais = opcionais;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public static List<Carro> lista() {
        List<Carro> carros = new ArrayList<>();

        carros.add(new Carro(
                 new ArrayList<String>(Arrays.asList(
                         "Farol de neblina",
                         "Teto solar",
                         "Câmera de ré",
                         "Rodas de liga leve")),
                "Vermelho",
                "Camaro",
                "GM - Chevrolet",
                1980));

        carros.add(new Carro(
                new ArrayList<String>(Arrays.asList(
                        "Farol de neblina",
                        "Câmera de ré")),
                "Branco",
                "Agile",
                "GM - Chevrolet",
                2014));

        carros.add(new Carro(
                new ArrayList<String>(Arrays.asList(
                        "Farol de neblina",
                        "Teto solar",
                        "Câmera de ré",
                        "Rodas de liga leve")),
                "Preto",
                "Soul",
                "Kia",
                2011));

        carros.add(new Carro(
                new ArrayList<String>(Arrays.asList("Farol de neblina")),
                "Azul",
                "Vayage",
                "Volkswagen",
                1980));

        return carros;
    }
}
