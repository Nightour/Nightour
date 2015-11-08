package com.infact.nightour.model;

/**
 * Created by Timóteo on 08/11/2015.
 */
public class Evento {
    public static String BD_TABELA = "eventos";

    public static String BD_ID = "_id";
    public static String BD_NOME = "evento_nome";
    public static String BD_DESCRICAO = "evento_descricao";
    public static String BD_GENERO = "genero";

    private int id;
    private String nome;
    private String descricao;
    private String genero;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
