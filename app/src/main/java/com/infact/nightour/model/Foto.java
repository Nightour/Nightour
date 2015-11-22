package com.infact.nightour.model;

import android.graphics.Bitmap;

import com.infact.nightour.helper.MakeCreateTableQuery;
import com.infact.nightour.helper.StringsCampo;

import java.util.Date;

/**
 * Created by Timóteo on 22/11/2015.
 */
public class Foto {
    public static String NOME_TABELA = "fotos";

    public static String BD_ID = "_id";
    public static String BD_ID_TIPO = "integer primary key autoincrement";

    public static String BD_IMAGEM = "imagem";
    public static String BD_IMAGEM_TIPO = "blob";

    public static String BD_TIMESTAMP = "timestamp";
    public static String BD_TIMESTAMP_TIPO = "integer"; // Usa o Unix time

    public static String BD_DESCRICAO = "descricao";
    public static String BD_DESCRICAO_TIPO = "text";

    public static String getCreateTableQuery() {
        return MakeCreateTableQuery.makeString(NOME_TABELA, new Object[] {
                new StringsCampo(BD_ID, BD_ID_TIPO),
                new StringsCampo(BD_IMAGEM, BD_IMAGEM_TIPO),
                new StringsCampo(BD_TIMESTAMP, BD_TIMESTAMP_TIPO),
                new StringsCampo(BD_DESCRICAO, BD_DESCRICAO_TIPO)
        });
    }

    private int id;
    private Bitmap imagem;
    private Date timestamp;
    private String descricao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Bitmap getImagem() {
        return imagem;
    }

    public void setImagem(Bitmap imagem) {
        this.imagem = imagem;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
