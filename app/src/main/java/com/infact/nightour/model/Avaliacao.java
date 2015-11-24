package com.infact.nightour.model;

/**
 * Created by Timóteo on 24/11/2015.
 */
public class Avaliacao {
    public static String NOME_TABELA = "eventos";

    public static String BD_ID = "_id";
    public static String BD_ID_TIPO = "integer primary key autoincrement";

    public static String BD_QUANT_ESTRELAS = "quantEstrelas";
    public static String BD_QUANT_ESTRELAS_TIPO = "integer";

    public static String BD_COMENTARIO = "comentario";
    public static String BD_COMENTARIO_TIPO = "text";

    public static String BD_TIMESTAMP = "timestamp";
    public static String BD_TIMESTAMP_TIPO = "int"; // Armazenado em Unix time
}
