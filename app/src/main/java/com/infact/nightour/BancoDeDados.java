package com.infact.nightour;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.infact.nightour.model.Avaliacao;
import com.infact.nightour.model.Evento;
import com.infact.nightour.model.Foto;
import com.infact.nightour.model.Local;
import com.infact.nightour.model.Timestamp;
import com.infact.nightour.model.Usuario;
import com.infact.nightour.relation.UsuarioFoiAEvento;
import com.infact.nightour.relation.UsuarioSegueUsuario;

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
        String query;

        query = Timestamp.getCreateTableQuery();
        db.execSQL(query);

        query = Foto.getCreateTableQuery();
        db.execSQL(query);

        query = Local.getCreateTableQuery();
        db.execSQL(query);

        query = Evento.getCreateTableQuery();
        db.execSQL(query);

        query = Usuario.getCreateTableQuery();
        db.execSQL(query);

        query = Avaliacao.getCreateTableQuery();
        db.execSQL(query);

        // Relações

        query = UsuarioSegueUsuario.getCreateTableQuery();
        db.execSQL(query);

        query = UsuarioFoiAEvento.getCreateTableQuery();
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Relações

        db.execSQL("DROP TABLE IF EXISTS " + UsuarioFoiAEvento.NOME_TABELA);
        db.execSQL("DROP TABLE IF EXISTS " + UsuarioSegueUsuario.NOME_TABELA);

        // Objetos

        db.execSQL("DROP TABLE IF EXISTS " + Avaliacao.NOME_TABELA);
        db.execSQL("DROP TABLE IF EXISTS " + Usuario.NOME_TABELA);
        db.execSQL("DROP TABLE IF EXISTS " + Evento.NOME_TABELA);
        db.execSQL("DROP TABLE IF EXISTS " + Local.NOME_TABELA);
        db.execSQL("DROP TABLE IF EXISTS " + Foto.NOME_TABELA);
        db.execSQL("DROP TABLE IF EXISTS " + Timestamp.NOME_TABELA);

        onCreate(db);
    }
}
