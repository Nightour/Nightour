package com.infact.nightour.controller;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.infact.nightour.BancoDeDados;

/**
 * Created by Timóteo on 24/11/2015.
 */
public class AvaliacaoController {
    private SQLiteDatabase db;
    private BancoDeDados banco;

    public AvaliacaoController(Context context) {
        banco = new BancoDeDados(context);
    }
}
