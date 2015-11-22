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
        String query = Evento.getCreateTableQuery();
        db.execSQL(query);

        query = "CREATE TABLE " + Usuario.BD_TABELA + " ( "
                + Usuario.BD_ID + " " + Usuario.BD_ID_TIPO + ","
                + Usuario.BD_EMAIL + " " + Usuario.BD_EMAIL_TIPO
                + Usuario.BD_SENHA + " " + Usuario.BD_SENHA_TIPO
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
