package com.infact.nightour.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.infact.nightour.BancoDeDados;
import com.infact.nightour.model.Usuario;

/**
 * Created by Timóteo on 22/11/2015.
 */
public class UsuariosController {
    private SQLiteDatabase db;
    private BancoDeDados banco;
    private Context context;

    public UsuariosController(Context context) {
        this.banco = new BancoDeDados(context);
        this.context = context;
    }

    private static ContentValues makeContentValues(Usuario usuario) {
        ContentValues valores = new ContentValues();
        valores.put(usuario.BD_NOME, usuario.getNome());
        valores.put(usuario.BD_STATUS, usuario.getStatus());
        valores.put(usuario.BD_INTERESSE, usuario.getInteresse());
        valores.put(usuario.BD_IMAGEM_PERFIL, usuario.getChaveImagemPerfil());

        return valores;
    }


    public long insereUsuario(Usuario usuario) {
        ContentValues valores = makeContentValues(usuario);

        db = banco.getWritableDatabase();
        long resultado = db.insert(usuario.NOME_TABELA, null, valores);
        db.close();

        if (resultado != -1) {
            usuario.setId(resultado);

            FotosController fotosController = new FotosController(this.context);
            fotosController.insereFoto(usuario.getImagemPerfil());
        }

        return resultado;
    }

    private static String[] camposTabelaUsuario() {
        return new String[]{ Usuario.BD_ID, Usuario.BD_NOME, Usuario.BD_STATUS, Usuario.BD_INTERESSE, Usuario.BD_ANIVERSARIO, Usuario.BD_IMAGEM_PERFIL };
    }

    public Cursor carregaUsuarios() {
        String[] campos = camposTabelaUsuario();

        db = banco.getReadableDatabase();
        Cursor cursor = db.query(Usuario.NOME_TABELA, campos, null, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        db.close();
        return cursor;
    }

    public Cursor carregaUsuarioById(Long id) {
        String[] campos = camposTabelaUsuario();
        String where = Usuario.BD_ID + " = " + id;

        db = banco.getReadableDatabase();
        Cursor cursor = db.query(Usuario.NOME_TABELA, campos, where, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        db.close();
        return cursor;
    }

    public void alteraUsuario(Usuario usuario) {
        ContentValues valores = makeContentValues(usuario);

        String where = usuario.BD_ID + " = " + usuario.getId();

        db = banco.getWritableDatabase();
        db.update(usuario.NOME_TABELA, valores, where, null);
        db.close();
    }

    public void deletaUsuario(Long id) {
        String where = Usuario.BD_ID + " = " + id;

        db = banco.getWritableDatabase();
        db.delete(Usuario.NOME_TABELA, where, null);
        db.close();
    }
}
