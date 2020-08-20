package org.test.classes;

import java.util.ArrayList;
import java.util.List;

public class Marca {
    private String nome;

    public Marca() {}

    public Marca(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static List<Marca> lista() {
        List<Marca> marca = new ArrayList<>();

        marca.add(new Marca("GM - Chevrolet"));
        marca.add(new Marca("Fiat"));
        marca.add(new Marca("Audi"));
        marca.add(new Marca("Volkswagen"));
        marca.add(new Marca("Kia"));

        return marca;
    }


}
