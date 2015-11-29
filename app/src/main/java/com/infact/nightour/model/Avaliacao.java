package com.infact.nightour.model;

import com.infact.nightour.helper.MakeCreateTableQuery;
import com.infact.nightour.helper.StringsCampo;

import java.util.Date;

/**
 * Created by Timóteo on 24/11/2015.
 */
public class Avaliacao {
    public static String NOME_TABELA = "avaliacoes";

    public static String BD_ID = "_id";
    public static String BD_ID_TIPO = "integer primary key autoincrement";

    public static String BD_QUANT_ESTRELAS = "quantEstrelas";
    public static String BD_QUANT_ESTRELAS_TIPO = "integer";

    public static String BD_COMENTARIO = "comentario";
    public static String BD_COMENTARIO_TIPO = "text";

    public static String BD_TIMESTAMP = "timestamp";
    public static String BD_TIMESTAMP_TIPO = "int"; // Armazenado em Unix time

    public Avaliacao() {
    }

    public static String getCreateTableQuery() {
        return MakeCreateTableQuery.makeString(NOME_TABELA, new StringsCampo[]{
                new StringsCampo(BD_ID, BD_ID_TIPO),
                new StringsCampo(BD_QUANT_ESTRELAS, BD_QUANT_ESTRELAS_TIPO),
                new StringsCampo(BD_COMENTARIO, BD_COMENTARIO_TIPO),
                new StringsCampo(BD_TIMESTAMP, BD_TIMESTAMP_TIPO)
        });
    }

    private int id;
    private int quantEstrelas;
    private String comentario;
    private Date timestamp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantEstrelas() {
        return quantEstrelas;
    }

    public void setQuantEstrelas(int quantEstrelas) {
        this.quantEstrelas = quantEstrelas;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public long getTimestampUnixTime() {
        long unixTime = getTimestamp().getTime() / 1000L;
        return unixTime;
    }
}
