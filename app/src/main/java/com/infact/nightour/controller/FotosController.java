package com.infact.nightour.controller;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.infact.nightour.BancoDeDados;

/**
 * Created by Timóteo on 22/11/2015.
 */
public class FotosController {
    private SQLiteDatabase db;
    private BancoDeDados banco;

    public FotosController(Context context) {
        banco = new BancoDeDados(context);
    }
}
