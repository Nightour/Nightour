package com.infact.nightour.controller;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.infact.nightour.BancoDeDados;

/**
 * Created by Timóteo on 08/11/2015.
 */
public class EventosController {
    private SQLiteDatabase db;
    private BancoDeDados banco;

    public EventosController(Context context) {
        banco = new BancoDeDados(context);
    }
}
