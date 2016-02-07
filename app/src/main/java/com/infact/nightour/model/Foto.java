package com.infact.nightour.model;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.infact.nightour.helper.MakeCreateTableQuery;
import com.infact.nightour.helper.StringChaveEstrangeira;
import com.infact.nightour.helper.StringsCampo;

import java.io.ByteArrayOutputStream;
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

    public static String BD_TIMESTAMP_CHAVE = "timestamp_chave"; // Chave estrangeira
    public static String BD_TIMESTAMP_CHAVE_TIPO = "INT";
    public static String BD_TIMESTAMP_REFERENCIA = Timestamp.NOME_TABELA;
    public static String BD_TIMESTAMP_CAMPO_REFERENCIADO = Timestamp.BD_ID;

    public static String BD_DESCRICAO = "descricao";
    public static String BD_DESCRICAO_TIPO = "text";

    public static String getCreateTableQuery() {
        return MakeCreateTableQuery.makeString(NOME_TABELA, new Object[] {
                new StringsCampo(BD_ID, BD_ID_TIPO),
                new StringsCampo(BD_IMAGEM, BD_IMAGEM_TIPO),
                new StringChaveEstrangeira(BD_TIMESTAMP_CHAVE, BD_TIMESTAMP_CHAVE_TIPO, BD_TIMESTAMP_REFERENCIA, BD_TIMESTAMP_CAMPO_REFERENCIADO),
                new StringsCampo(BD_DESCRICAO, BD_DESCRICAO_TIPO)
        });
    }

    // ---

    public static Bitmap bitmapFromBlob(byte[] byteArray) {
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
    }

    // ---

    private int id;
    private Bitmap imagem;
    private int chaveTimestamp;
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

    public byte[] getImagemBytes() {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        getImagem().compress(Bitmap.CompressFormat.PNG, 0, stream);
        return stream.toByteArray();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getChaveTimestamp() {
        return chaveTimestamp;
    }

    public void setChaveTimestamp(int chaveTimestamp) {
        this.chaveTimestamp = chaveTimestamp;
    }
}
