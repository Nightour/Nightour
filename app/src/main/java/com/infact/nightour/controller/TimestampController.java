package com.infact.nightour.controller;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.infact.nightour.BancoDeDados;

/**
 * Created by Timóteo on 17/01/2016.
 */
public class TimestampController {
    private SQLiteDatabase db;
    private BancoDeDados banco;

    public TimestampController(Context context) {
        banco = new BancoDeDados(context);
    }
}
