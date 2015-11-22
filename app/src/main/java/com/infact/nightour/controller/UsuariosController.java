package com.infact.nightour.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;

import com.infact.nightour.BancoDeDados;
import com.infact.nightour.model.Usuario;

/**
 * Created by Timóteo on 22/11/2015.
 */
public class UsuariosController {
    private SQLiteDatabase db;
    private BancoDeDados banco;

    public UsuariosController(Context context) {
        banco = new BancoDeDados(context);
    }

    private static ContentValues makeContentValues(Usuario usuario) {
        ContentValues valores = new ContentValues();
        valores.put(usuario.BD_NOME, usuario.getNome());
        valores.put(usuario.BD_STATUS, usuario.getStatus());
        valores.put(usuario.BD_INTERESSE, usuario.getInteresse());
        valores.put(usuario.BD_ANIVERSARIO, usuario.getAniversarioUnixTime());

        return valores;
    }
}
