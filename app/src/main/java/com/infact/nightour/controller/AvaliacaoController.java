package com.infact.nightour.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.infact.nightour.BancoDeDados;
import com.infact.nightour.model.Avaliacao;

/**
 * Created by Timóteo on 24/11/2015.
 */
public class AvaliacaoController {
    private SQLiteDatabase db;
    private BancoDeDados banco;

    public AvaliacaoController(Context context) {
        banco = new BancoDeDados(context);
    }

    private static ContentValues makeContentValues(Avaliacao avaliacao) {
        ContentValues valores = new ContentValues();
        valores.put(avaliacao.BD_QUANT_ESTRELAS, avaliacao.getQuantEstrelas());
        valores.put(avaliacao.BD_COMENTARIO, avaliacao.getComentario());
        valores.put(avaliacao.BD_TIMESTAMP, avaliacao.getTimestampUnixTime());

        return valores;
    }

    public long insereAvaliacao(Avaliacao avaliacao) {
        ContentValues valores = makeContentValues(avaliacao);

        db = banco.getWritableDatabase();
        long resultado = db.insert(avaliacao.NOME_TABELA, null, valores);
        db.close();

        return resultado;
    }

    private static String[] camposTabelaAvaliacao() {
        return new String[]{ Avaliacao.BD_ID, Avaliacao.BD_QUANT_ESTRELAS, Avaliacao.BD_COMENTARIO, Avaliacao.BD_TIMESTAMP };
    }

    public Cursor carregaAvaliacoes() {
        String[] campos = camposTabelaAvaliacao();

        db = banco.getReadableDatabase();
        Cursor cursor = db.query(Avaliacao.NOME_TABELA, campos, null, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        db.close();
        return cursor;
    }

    public Cursor carregaAvaliacaoById(int id) {
        String[] campos = camposTabelaAvaliacao();
        String where = Avaliacao.BD_ID + " = " + id;

        db = banco.getReadableDatabase();
        Cursor cursor = db.query(Avaliacao.NOME_TABELA, campos, where, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        db.close();
        return cursor;
    }
}
