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

    private static String[] camposTabelaEvento() {
        return new String[]{ Evento.BD_ID, Evento.BD_NOME, Evento.BD_DESCRICAO, Evento.BD_GENERO, Evento.BD_IMAGEM };
    }

    public Cursor carregaEventos() {
        String[] campos = camposTabelaEvento();

        db = banco.getReadableDatabase();
        Cursor cursor = db.query(Evento.TABELA_NOME, campos, null, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        db.close();
        return cursor;
    }

    public Cursor carregaEventoById(int id) {
        String[] campos = camposTabelaEvento();
        String where = Evento.BD_ID + " = " + id;

        db = banco.getReadableDatabase();
        Cursor cursor = db.query(Evento.TABELA_NOME, campos, where, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        db.close();
        return cursor;
    }

    public void alteraEvento(Evento evento) {
        ContentValues valores = new ContentValues();
        valores.put(Evento.BD_ID, evento.getId());
        valores.put(Evento.BD_NOME, evento.getNome());
        valores.put(Evento.BD_DESCRICAO, evento.getDescricao());
        valores.put(Evento.BD_GENERO, evento.getGenero());
        valores.put(Evento.BD_IMAGEM, evento.getImagemBytes());

        String where = Evento.BD_ID + " = " + evento.getId());

        db = banco.getWritableDatabase();
        db.update(Evento.TABELA_NOME, valores, where, null);
        db.close();
    }
}
