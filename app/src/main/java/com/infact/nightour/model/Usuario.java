package com.infact.nightour.model;

/**
 * Created by Timóteo on 08/11/2015.
 */
public class Usuario {
    public static String BD_TABELA = "usuarios";

    public static String BD_ID = "_id";
    public static String BD_EMAIL = "email";
    public static String BD_SENHA = "senha";

    private int id;
    private String email;
    private String senha;
}
