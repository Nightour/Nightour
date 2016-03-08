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

    public static String BD_DESCRICAO = "descricao";
    public static String BD_DESCRICAO_TIPO = "text";

    public static String BD_TIMESTAMP = "timestamp";
    public static String BD_TIMESTAMP_TIPO = "integer";

    public static String getCreateTableQuery() {
        return MakeCreateTableQuery.makeString(NOME_TABELA, new Object[] {
                new StringsCampo(BD_ID, BD_ID_TIPO),
                new StringsCampo(BD_IMAGEM, BD_IMAGEM_TIPO),
                new StringsCampo(BD_DESCRICAO, BD_DESCRICAO_TIPO),
                new StringsCampo(BD_TIMESTAMP, BD_TIMESTAMP_TIPO)
        });
    }

    // ---

    public static Bitmap bitmapFromBlob(byte[] byteArray) {
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
    }

    public static byte[] blobFromBitmap(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, stream);
        return stream.toByteArray();
    }

    public static Foto fromCursor(Cursor cursor) {
        Foto foto = new Foto();

        foto.setId(cursor.getLong(cursor.getColumnIndexOrThrow(BD_ID)));
        foto.setImagem(bitmapFromBlob(cursor.getBlob(cursor.getColumnIndexOrThrow(BD_IMAGEM))));
        foto.setDescricao(cursor.getString(cursor.getColumnIndexOrThrow(BD_DESCRICAO)));
        foto.setTimestamp(cursor.getLong(cursor.getColumnIndexOrThrow(BD_TIMESTAMP)));

        return foto;
    }

    // ---

    private long id;
    private Bitmap imagem;
    private Long timestamp;
    private String descricao;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
