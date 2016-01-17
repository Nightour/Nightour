package com.infact.nightour.model;

/**
 * Created by Timóteo on 17/01/2016.
 */
public class Timestamp {
    public static String NOME_TABELA = "timestamps";

    public static String BD_ID = "_id";
    public static String BD_ID_TIPO = "integer primary key autoincrement";

    public static String BD_CREATE_TIME = "create_time";
    public static String BD_CREATE_TIME_TIPO = "INT"; // Armazenado em Unix time
}
