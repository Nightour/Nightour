package com.infact.nightour.controller;

import android.content.ContentValues;
import android.content.Context;
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
}
