package com.infact.nightour.controller;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.infact.nightour.BancoDeDados;

/**
 * Created by Timóteo on 26/11/2015.
 */
public class LocalController {
    private SQLiteDatabase db;
    private BancoDeDados banco;

    public LocalController(Context context) {
        banco = new BancoDeDados(context);
    }
}
