package org.test.classes;

import java.util.ArrayList;
import java.util.List;

public class Opcionais {
    private String nome;

    public Opcionais() {}

    public Opcionais(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static List<Opcionais> lista() {
        List<Opcionais> opcionais = new ArrayList<>();

        opcionais.add(new Opcionais("Farol de neblina"));
        opcionais.add(new Opcionais("Teto solar"));
        opcionais.add(new Opcionais("Câmera de ré"));
        opcionais.add(new Opcionais("Rodas de liga leve"));

        return opcionais;
    }
}
