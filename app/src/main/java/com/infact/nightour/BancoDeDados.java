package com.infact.nightour;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.infact.nightour.model.Evento;

/**
 * Created by Timóteo on 08/11/2015.
 */
public class BancoDeDados extends SQLiteOpenHelper {
    public static String NOME_BANCO = "banco_nightour.db";
    public static int VERSAO = 1;

    public static class Usuarios {
        public static String TABELA = "usuarios";

        public static String ID = "_id";
        public static String EMAIL = "email";
        public static String SENHA = "senha";
    }

    public static class Eventos {
        public static String TABELA = "eventos";

        public static String ID = "_id";
        public static String NOME = "nome";
        public static String DESCRICAO = "descricao";
    }

    public BancoDeDados(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + Evento.BD_TABELA + " ( "
                + Evento.BD_ID + " integer primary key autoincrement, "
                + Evento.BD_NOME + " text, "
                + Evento.BD_DESCRICAO + " text "
                + " ) ";

        db.execSQL(query);

        query = "CREATE TABLE " + Usuarios.TABELA + " ( "
                + Usuarios.ID + " integer primary key autoincrement, "
                + Usuarios.EMAIL + " text, "
                + Usuarios.SENHA + " text "
                + " ) ";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Evento.BD_TABELA);
        db.execSQL("DROP TABLE IF EXISTS " + Usuarios.TABELA);
        onCreate(db);
    }
}
