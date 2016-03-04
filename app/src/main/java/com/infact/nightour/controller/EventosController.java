package com.infact.nightour.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.infact.nightour.BancoDeDados;
import com.infact.nightour.model.Evento;

/**
 * Created by Timóteo on 08/11/2015.
 */
public class EventosController {
    private SQLiteDatabase db;
    private BancoDeDados banco;
    private Context context;

    public EventosController(Context context) {
        this.banco = new BancoDeDados(context);
        this.context = context;
    }

    private static ContentValues makeContentValues(Evento evento) {
        ContentValues valores = new ContentValues();
        valores.put(Evento.BD_NOME, evento.getNome());
        valores.put(Evento.BD_DESCRICAO, evento.getDescricao());
        valores.put(Evento.BD_IMAGEM_CHAVE, evento.getChaveImagem());
        valores.put(Evento.BD_LOCAL_CHAVE, evento.getChaveLocal());

        return valores;
    }

    public long insereEvento(Evento evento) {
        ContentValues valores = makeContentValues(evento);

        db = banco.getWritableDatabase();
        long resultado = db.insert(Evento.NOME_TABELA, null, valores);
        db.close();

        if (resultado != -1) {
            evento.setId(resultado);

            FotosController fotosController = new FotosController(this.getContext());
            long fotoResultado = fotosController.insereFoto(evento.getImagem());

            if (fotoResultado != -1) {
                LocaisController locaisController = new LocaisController(this.getContext());
                locaisController.insereLocal(evento.getLocal());
            }
        }

        return resultado;
    }

    private static String[] camposTabelaEvento() {
        return new String[]{ Evento.BD_ID, Evento.BD_NOME, Evento.BD_DESCRICAO, Evento.BD_IMAGEM_CHAVE };
    }

    public Cursor carregaEventos() {
        String[] campos = camposTabelaEvento();

        db = banco.getReadableDatabase();
        Cursor cursor = db.query(Evento.NOME_TABELA, campos, null, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        db.close();
        return cursor;
    }

    public Cursor carregaEventoById(Long id) {
        String[] campos = camposTabelaEvento();
        String where = Evento.BD_ID + " = " + id;

        db = banco.getReadableDatabase();
        Cursor cursor = db.query(Evento.NOME_TABELA, campos, where, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        db.close();
        return cursor;
    }

    public void alteraEvento(Evento evento) {
        ContentValues valores = makeContentValues(evento);

        String where = Evento.BD_ID + " = " + evento.getId();

        db = banco.getWritableDatabase();
        db.update(Evento.NOME_TABELA, valores, where, null);
        db.close();

        new FotosController(this.getContext()).alteraFoto(evento.getImagem());
        new LocaisController(this.getContext()).alteraLocal(evento.getLocal());
    }

    public void deletaEvento(Long id) {
        String where = Evento.BD_ID + " = " + id;

        db = banco.getWritableDatabase();
        db.delete(Evento.NOME_TABELA, where, null);
        db.close();
    }

    public Context getContext() {
        return context;
    }
}
