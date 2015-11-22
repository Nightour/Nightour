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


    public long insereUsuario(Usuario usuario) {
        ContentValues valores = makeContentValues(usuario);

        db = banco.getWritableDatabase();
        long resultado = db.insert(usuario.NOME_TABELA, null, valores);
        db.close();

        return resultado;
    }

    private static String[] camposTabelaUsuario() {
        return new String[]{ Usuario.BD_ID, Usuario.BD_NOME, Usuario.BD_STATUS, Usuario.BD_INTERESSE, Usuario.BD_ANIVERSARIO, Usuario.BD_IMAGEM_PERFIL };
    }
}
