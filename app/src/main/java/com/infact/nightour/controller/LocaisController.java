package com.infact.nightour.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.infact.nightour.BancoDeDados;
import com.infact.nightour.model.Local;

/**
 * Created by Timóteo on 26/11/2015.
 */
public class LocaisController {
    private SQLiteDatabase db;
    private BancoDeDados banco;

    public LocaisController(Context context) {
        banco = new BancoDeDados(context);
    }

    private static ContentValues makeContentValues(Local local) {
        ContentValues valores = new ContentValues();
        valores.put(local.BD_LATITUDE, local.getLatitude());
        valores.put(local.BD_LONGITUDE, local.getLongitude());
        valores.put(local.BD_ZOOM, local.getZoom());

        return valores;
    }

    public long insereLocal(Local local) {
        ContentValues valores = makeContentValues(local);

        db = banco.getWritableDatabase();
        long resultado = db.insert(local.NOME_TABELA, null, valores);
        db.close();

        return resultado;
    }

    private static String[] camposTabelaLocal() {
        return new String[]{ Local.BD_ID, Local.BD_LATITUDE, Local.BD_LONGITUDE, Local.BD_ZOOM };
    }

    public Cursor carregaLocais() {
        String[] campos = camposTabelaLocal();

        db = banco.getReadableDatabase();
        Cursor cursor = db.query(Local.NOME_TABELA, campos, null, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        db.close();
        return cursor;
    }

    public Cursor carregaLocalById(int id) {
        String[] campos = camposTabelaLocal();
        String where = Local.BD_ID + " = " + id;

        db = banco.getReadableDatabase();
        Cursor cursor = db.query(Local.NOME_TABELA, campos, where, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        db.close();
        return cursor;
    }
}
