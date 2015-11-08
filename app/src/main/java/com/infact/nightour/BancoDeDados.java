package com.infact.nightour;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.infact.nightour.model.Evento;
import com.infact.nightour.model.Usuario;

/**
 * Created by Timóteo on 08/11/2015.
 */
public class BancoDeDados extends SQLiteOpenHelper {
    public static String NOME_BANCO = "banco_nightour.db";
    public static int VERSAO = 1;

    public BancoDeDados(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + Evento.NOME_TABELA + " ( "
                + Evento.BD_ID + " integer primary key autoincrement, "
                + Evento.BD_NOME + " text, "
                + Evento.BD_DESCRICAO + " text, "
                + Evento.BD_GENERO + " text, "
                + Evento.BD_IMAGEM + " text "
                + " ) ";

        db.execSQL(query);

        query = "CREATE TABLE " + Usuario.BD_TABELA + " ( "
                + Usuario.BD_ID + " integer primary key autoincrement, "
                + Usuario.BD_EMAIL + " text, "
                + Usuario.BD_SENHA + " text "
                + " ) ";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Evento.NOME_TABELA);
        db.execSQL("DROP TABLE IF EXISTS " + Usuario.BD_TABELA);
        onCreate(db);
    }
}
