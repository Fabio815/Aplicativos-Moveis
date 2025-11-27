package br.com.ifsc;

public class Notas {
    Integer id;
    String nome;
    String txt;

    public Notas(Integer id, String nome, String txt) {
        this.id = id;
        this.nome = nome;
        this.txt = txt;
    }

    public Notas(String nome, String txt) {
        this.id=null;
        this.nome = nome;
        this.txt = txt;
    }
}
