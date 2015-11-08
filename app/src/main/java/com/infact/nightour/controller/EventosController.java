package com.infact.nightour.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.infact.nightour.BancoDeDados;
import com.infact.nightour.model.Evento;

/**
 * Created by Timóteo on 08/11/2015.
 */
public class EventosController {
    private SQLiteDatabase db;
    private BancoDeDados banco;

    public EventosController(Context context) {
        banco = new BancoDeDados(context);
    }

    public long insereEvento(Evento evento) {
        ContentValues valores = new ContentValues();
        valores.put(Evento.BD_NOME, evento.getNome());
        valores.put(Evento.BD_DESCRICAO, evento.getDescricao());
        valores.put(Evento.BD_GENERO, evento.getGenero());
        valores.put(Evento.BD_IMAGEM, evento.getImagemBytes());

        db = banco.getWritableDatabase();
        long resultado = db.insert(Evento.TABELA_NOME, null, valores);
        db.close();

        return resultado;
    }

    public Cursor carregaEventos() {
        String[] campos = { Evento.BD_ID, Evento.BD_NOME, Evento.BD_DESCRICAO, Evento.BD_GENERO, Evento.BD_IMAGEM };

        db = banco.getWritableDatabase();
        Cursor cursor = db.query(Evento.TABELA_NOME, campos, null, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        db.close();
        return cursor;
    }


}
