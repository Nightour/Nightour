package com.infact.nightour.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.infact.nightour.BancoDeDados;
import com.infact.nightour.model.Foto;

/**
 * Created by Timóteo on 22/11/2015.
 */
public class FotosController {
    private SQLiteDatabase db;
    private BancoDeDados banco;

    public FotosController(Context context) {
        banco = new BancoDeDados(context);
    }

    public long insereFoto(Foto foto) {
        ContentValues valores = new ContentValues();
        valores.put(foto.BD_IMAGEM, foto.getImagemBytes());
        valores.put(foto.BD_DESCRICAO, foto.getDescricao());
        valores.put(foto.BD_TIMESTAMP, foto.getTimestampUnixTime());

        db = banco.getWritableDatabase();
        long resultado = db.insert(foto.NOME_TABELA, null, valores);
        db.close();

        return resultado;
    }

    private static String[] camposTabelaFoto() {
        return new String[]{ Foto.BD_ID, Foto.BD_IMAGEM, Foto.BD_DESCRICAO, Foto.BD_TIMESTAMP };
    }
}
