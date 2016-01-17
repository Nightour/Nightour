package com.infact.nightour.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.infact.nightour.BancoDeDados;
import com.infact.nightour.model.Timestamp;

/**
 * Created by Timóteo on 17/01/2016.
 */
public class TimestampController {
    private SQLiteDatabase db;
    private BancoDeDados banco;

    public TimestampController(Context context) {
        banco = new BancoDeDados(context);
    }

    private static ContentValues makeContentValues(Timestamp timestamp) {
        ContentValues valores = new ContentValues();
        valores.put(timestamp.BD_CREATE_TIME, timestamp.getCreateTime());
        valores.put(timestamp.BD_UPDATE_TIME, timestamp.getUpdateTime());

        return valores;
    }


    public long insereTimestamp(Timestamp timestamp) {
        ContentValues valores = makeContentValues(timestamp);

        db = banco.getWritableDatabase();
        long resultado = db.insert(timestamp.NOME_TABELA, null, valores);
        db.close();

        return resultado;
    }

    private static String[] camposTabelaTimestamps() {
        return new String[]{ Timestamp.BD_ID, Timestamp.BD_CREATE_TIME, Timestamp.BD_UPDATE_TIME };
    }

    public Cursor carregaTimestamps() {
        String[] campos = camposTabelaTimestamps();

        db = banco.getReadableDatabase();
        Cursor cursor = db.query(Timestamp.NOME_TABELA, campos, null, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        db.close();
        return cursor;
    }

    public Cursor carregaTimestampById(int id) {
        String[] campos = camposTabelaTimestamps();
        String where = Timestamp.BD_ID + " = " + id;

        db = banco.getReadableDatabase();
        Cursor cursor = db.query(Timestamp.NOME_TABELA, campos, where, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        db.close();
        return cursor;
    }

    public void alteraTimestamp(Timestamp timestamp) {
        ContentValues valores = makeContentValues(timestamp);

        String where = timestamp.BD_ID + " = " + timestamp.getId();

        db = banco.getWritableDatabase();
        db.update(timestamp.NOME_TABELA, valores, where, null);
        db.close();
    }

    public void deletaTimestamp(int id) {
        String where = Timestamp.BD_ID + " = " + id;

        db = banco.getWritableDatabase();
        db.delete(Timestamp.NOME_TABELA, where, null);
        db.close();
    }
}
