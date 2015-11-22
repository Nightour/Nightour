package com.infact.nightour.model;

/**
 * Created by Timóteo on 08/11/2015.
 */
public class Usuario {
    public static String BD_TABELA = "usuarios";

    public static String BD_ID = "_id";
    public static String BD_ID_TIPO = "integer primary key autoincrement";

    public static String BD_EMAIL = "email";
    public static String BD_EMAIL_TIPO = "text";

    public static String BD_SENHA = "senha";
    public static String BD_SENHA_TIPO = "text";

    private int id;
    private String email;
    private String senha;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
