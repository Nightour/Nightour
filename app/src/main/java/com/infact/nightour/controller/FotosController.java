package com.infact.nightour.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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

    public Cursor carregaFotos() {
        String[] campos = camposTabelaFoto();

        db = banco.getReadableDatabase();
        Cursor cursor = db.query(Foto.NOME_TABELA, campos, null, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        db.close();
        return cursor;
    }

    public Cursor carregaFotoById(int id) {
        String[] campos = camposTabelaFoto();
        String where = Foto.BD_ID + " = " + id;

        db = banco.getReadableDatabase();
        Cursor cursor = db.query(Foto.NOME_TABELA, campos, where, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        db.close();
        return cursor;
    }

    public void alteraFoto(Foto foto) {
        ContentValues valores = new ContentValues();
        valores.put(foto.BD_IMAGEM, foto.getImagemBytes());
        valores.put(foto.BD_DESCRICAO, foto.getDescricao());
        valores.put(foto.BD_TIMESTAMP, foto.getTimestampUnixTime());

        String where = foto.BD_ID + " = " + foto.getId();

        db = banco.getWritableDatabase();
        db.update(foto.NOME_TABELA, valores, where, null);
        db.close();
    }

    public void deletaFoto(int id) {
        String where = Foto.BD_ID + " = " + id;

        db = banco.getWritableDatabase();
        db.delete(Foto.NOME_TABELA, where, null);
        db.close();
    }
}
